package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    @Test
    public void test() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

}
