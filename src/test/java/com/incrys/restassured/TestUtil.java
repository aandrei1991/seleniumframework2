package com.incrys.restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;

public class TestUtil {
    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }

    //Get Clients
    public <T> ArrayList<T> getClients(JsonPath jp) {
        return jp.get();
    }
}
