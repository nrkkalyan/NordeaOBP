package org.lwapp.obp.nordea.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.lwapp.obp.nordea.response.error.ErrorResponse;
import org.lwapp.obp.nordea.response.ok.GetAssetsResponse;
import org.lwapp.provider.MyObjectMapper;

public class GetAssetsJerseyExample {

    public static void main(final String[] args) throws Exception {

        final String url = "https://api.nordeaopenbanking.com/v1";

        Client client = ClientBuilder.newClient()//
                .register(MyObjectMapper.class)
                .register(JacksonFeature.class);
        WebTarget webTarget = client.target(url);

        WebTarget accountsWebTarget = webTarget.path("assets");
        Invocation.Builder invocationBuilder = accountsWebTarget.request();
        addHeaders(invocationBuilder);

        Response response = invocationBuilder.get();
        System.out.println("Status:" + response.getStatus());

        if (response.getStatus() == 200) {
            GetAssetsResponse getAssetsResponse = response.readEntity(GetAssetsResponse.class);
            System.out.println(new MyObjectMapper().toString(getAssetsResponse));
        } else {
            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            System.out.println(new MyObjectMapper().toString(errorResponse));
        }

    }

    private static void addHeaders(final Invocation.Builder request) {
        request.header("Authorization", "Bearer authenticated-user-full-access")//
                .accept(MediaType.APPLICATION_JSON)
                .header("X-IBM-Client-Id", "d03610ec-bc89-43f7-a14c-f8eaf7d10837")//
                .header("X-IBM-Client-Secret", "rQ6wN5rC0nB0oH8xT4qW7oT7wD0jY2qJ7sW5lX0rU8lO0fY5lA");
    }

}