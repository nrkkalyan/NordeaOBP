package org.lwapp.jaxrs.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.apache.http.HttpEntity;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class MyObjectMapper implements ContextResolver<ObjectMapper> {

    final ObjectMapper mapper;

    public MyObjectMapper() {
        this.mapper = new ObjectMapper()//
                .setSerializationInclusion(Include.NON_EMPTY)
                .setSerializationInclusion(Include.NON_NULL)// Only not null values are considered
                .enable(SerializationFeature.INDENT_OUTPUT);

    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return this.mapper;
    }

    public <T> T unMarshal(HttpEntity httpEntity, Class<T> clazz) throws Exception {
        return this.mapper.readValue(httpEntity.getContent(), clazz);
    }

    public <T> T unMarshal(String json, Class<T> clazz) throws Exception {
        return this.mapper.readValue(json, clazz);
    }

    public String marshal(Object value) throws Exception {
        return this.mapper.writeValueAsString(value);
    }

}