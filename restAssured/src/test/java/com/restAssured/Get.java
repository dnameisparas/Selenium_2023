package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
   @Test
	void get() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		int st=response.getStatusCode();
		Assert.assertEquals(st, 201);
		
	}
}
