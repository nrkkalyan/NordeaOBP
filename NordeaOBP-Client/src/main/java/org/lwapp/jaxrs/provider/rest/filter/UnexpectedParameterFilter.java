package org.lwapp.jaxrs.provider.rest.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class UnexpectedParameterFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        final Set<String> validParams = new HashSet<>();
        final Method method = this.resourceInfo.getResourceMethod();
        for (final Annotation[] annos : method.getParameterAnnotations()) {
            for (final Annotation anno : annos) {
                if (anno instanceof QueryParam) {
                    validParams.add(((QueryParam) anno).value());
                }
            }
        }

        final MultivaluedMap<String, String> queryParameters = requestContext.getUriInfo().getQueryParameters();
        for (final String param : queryParameters.keySet()) {
            if (!validParams.contains(param) && !(param.equals("randomValue") || param.equals("cacheBuster"))) {
                requestContext.abortWith(Response.status(Status.BAD_REQUEST).entity("unexpected paramter: " + param).build());
            }
        }
    }

}