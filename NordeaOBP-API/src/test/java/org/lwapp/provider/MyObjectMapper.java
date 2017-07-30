package org.lwapp.provider;

import java.io.Serializable;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class MyObjectMapper implements ContextResolver<ObjectMapper> {

    final ObjectMapper mapper;

    public MyObjectMapper() {
        this.mapper = new ObjectMapper()//
                .setSerializationInclusion(Include.NON_EMPTY)
                .setSerializationInclusion(Include.NON_NULL)
                .enable(SerializationFeature.INDENT_OUTPUT)
        //                .setDefaultPrettyPrinter(new DefaultPrettyPrinter())// Only not null values are considered
        ;

    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return this.mapper;
    }

    public String toString(Serializable s) throws JsonProcessingException {
        return this.mapper.writeValueAsString(s);
    }
}