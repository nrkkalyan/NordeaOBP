package org.lwapp.obp.nordea.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.lwapp.obp.nordea.response.error.ErrorResponse;
import org.lwapp.obp.nordea.response.ok.GetAccountResponse;
import org.lwapp.provider.MyObjectMapper;

public class GetAccountByIdJerseyExample {

    public static void main(final String[] args) throws Exception {

        final String url = "https://api.nordeaopenbanking.com/v1";

        final Client client = ClientBuilder.newBuilder()//
                .register(MyObjectMapper.class)
                .register(JacksonFeature.class)
                .build();
        final WebTarget webTarget = client.target(url);

        final WebTarget accountsWebTarget = webTarget.path("accounts").path("FI6593857450293470-EUR");
        final Invocation.Builder invocationBuilder = accountsWebTarget.request();
        addHeaders(invocationBuilder);

        final Response response = invocationBuilder.get();
        System.out.println("Status:" + response.getStatus());
        if (response.getStatus() == 200) {
            final GetAccountResponse getAccountsResponse = response.readEntity(GetAccountResponse.class);
            System.out.println(new MyObjectMapper().toString(getAccountsResponse));
        } else {
            final ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
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