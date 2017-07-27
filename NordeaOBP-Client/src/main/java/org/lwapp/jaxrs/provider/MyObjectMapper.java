package org.lwapp.jaxrs.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class MyObjectMapper implements ContextResolver<ObjectMapper> {

    final ObjectMapper mapper;

    public MyObjectMapper() {
        this.mapper = new ObjectMapper()//
                .setSerializationInclusion(Include.NON_NULL)// Only not null values are considered
        ;

    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return this.mapper;
    }
}