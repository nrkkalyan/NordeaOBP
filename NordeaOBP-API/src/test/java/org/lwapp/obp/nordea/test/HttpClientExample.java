package org.lwapp.obp.nordea.test;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientExample {

    public static void main(final String[] args) throws Exception {

        final String url = "https://api.nordeaopenbanking.com/v1/accounts";

        final HttpClient client = HttpClientBuilder.create().build();
        final HttpGet request = new HttpGet(url);
        addHeaders(request);
        // add request header
        System.out.println("Fetching accounts.");
        final HttpResponse response = client.execute(request);
        System.out.println(response.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());
        final String string = IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset());
        System.out.println(string);

    }

    private static void addHeaders(final HttpRequestBase request) {
        request.addHeader("Authorization", "Bearer authenticated-user-full-access");
        request.addHeader("X-IBM-Client-Id", "d03610ec-bc89-43f7-a14c-f8eaf7d10837");
        request.addHeader("X-IBM-Client-Secret", "rQ6wN5rC0nB0oH8xT4qW7oT7wD0jY2qJ7sW5lX0rU8lO0fY5lA");
    }

}