package org.lwapp.psd2.jaxrs.rest.resources;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.lwapp.jaxrs.httpclient.utils.ApacheHttpClient;
import org.lwapp.psd2.BasicTest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

@ManagedBean
public class AccountsResourceTest extends BasicTest {

    @EJB
    private ApacheHttpClient httpClient;

    @Override
    public void before() throws Exception {
        super.before();
        RestAssured.baseURI = "http://127.0.0.1:4204/oogla/aisp";
    }

    @Test
    public void testPing() throws Exception {
        this.createBaseRestAssured().expect().body(Matchers.startsWith("System is ALIVE ")).when().get();
    }

    @Test
    public void testGetBanks() throws Exception {
        this.createBaseRestAssured().expect().body(Matchers.equalTo("[ \"Nordea\", \"Swedbank\" ]")).when().get("banks");
    }

    @Test
    public void testGetFileTransferDetails() throws Exception {
        this.createBaseRestAssured().accept(ContentType.JSON).expect().statusCode(Response.Status.OK.getStatusCode())//
                .and().body(Matchers.containsString("\"httpCode\" : 200"))
                .and().body(Matchers.containsString("\"messageIdentification\" : \"wGjKCyetftk\""))
                .when().get("accounts");
    }

    private RequestSpecification createBaseRestAssured() {
        return RestAssured.given().header("iv-user", "someuser").and().header("iv-groups", "testuser").and().header("Authorization", "e3thcGlLZXl9fTp7e2FwaVNlY3JldH19");
    }

}
