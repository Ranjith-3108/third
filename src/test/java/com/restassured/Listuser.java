package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Listuser {

	public static void main(String[] args) {
		RequestSpecification req;
		//intialize the rest assured
		 req = RestAssured.given();
		 //Method type
		 Response response = req.get("https://reqres.in/api/users?page=2");
		 //To get the response code 
		 int code = response.getStatusCode();
		 System.out.println(code);
		 
		 // To get the response body
		 String asString = response.asString();
		// System.out.println(asString);
		 
		 //Beautify
		 String prettyString = response.asPrettyString();
		 System.out.println(prettyString);
	}

}
