package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put {

	public static void main(String[] args) {
		// https://reqres.in/api/users/2

		// https://reqres.in/api/register
				RequestSpecification req;
				//intialize the rest assured
				 req = RestAssured.given();
				 //Method type
				 RequestSpecification body = req.body("{\r\n"
				 		+ "    \"name\": \"morpheus\",\r\n"
				 		+ "    \"job\": \"zion resident\"\r\n"
				 		+ "}");
				 Response response = req.put("https://reqres.in/api/users/2");
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
