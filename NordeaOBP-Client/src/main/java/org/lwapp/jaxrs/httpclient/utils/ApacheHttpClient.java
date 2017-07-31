package org.lwapp.jaxrs.httpclient.utils;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.lwapp.jaxrs.provider.MyObjectMapper;
import org.lwapp.nordeaobp.psd2.response.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApacheHttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(ApacheHttpClient.class);

    public Response get(final String url, Class<?> clazz) throws Exception {

        final HttpGet request = new HttpGet(url);
        addHeaders(request);
        // add request header
        final HttpClient client = HttpClientBuilder.create().build();
        final HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            clazz = ErrorResponse.class;
        }

        final MyObjectMapper myObjectMapper = new MyObjectMapper();
        final Object entity = myObjectMapper.unMarshal(response.getEntity(), clazz);

        return Response.ok(entity).build();

    }

    // TODO: Need to read the data from database
    private static void addHeaders(final HttpRequestBase request) {
        request.addHeader("Authorization", "Bearer authenticated-user-full-access");
        request.addHeader("X-IBM-Client-Id", "d03610ec-bc89-43f7-a14c-f8eaf7d10837");
        request.addHeader("X-IBM-Client-Secret", "rQ6wN5rC0nB0oH8xT4qW7oT7wD0jY2qJ7sW5lX0rU8lO0fY5lA");
    }

}