package org.lwapp.jaxrs.provider.rest.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final Map<String, String> headers = new HashMap<String, String>();

    public CustomHttpServletRequestWrapper(final HttpServletRequest request) {
        super(request);
    }

    public void addHeader(final String name, final String value) {
        this.headers.put(name, value);
    }

    @Override
    public String getHeader(final String name) {
        final String paramValue = this.headers.get(name);
        if (StringUtils.isBlank(paramValue)) {
            // if the value is not present in the custom header then return from the original place.
            return super.getHeader(name);
        }
        return paramValue;
    }

    @Override
    public String getParameter(final String name) {
        final String paramValue = this.headers.get(name);
        if (StringUtils.isBlank(paramValue)) {
            // if the value is not present in the custom header then return from the original place.
            return super.getParameter(name);
        }
        return paramValue;
    }

    @Override
    public Enumeration<String> getHeaders(final String name) {
        final String paramValue = this.headers.get(name);
        if (StringUtils.isBlank(paramValue)) {
            // if the value is not present in the custom header then return from the original place.
            return super.getHeaders(name);
        }
        return Collections.enumeration(Arrays.asList(paramValue));

    }

    @Override
    public Enumeration<String> getHeaderNames() {
        final List<String> names = Collections.list(super.getHeaderNames());
        names.addAll(this.headers.keySet());
        return Collections.enumeration(names);
    }

}
