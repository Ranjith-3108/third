package com.Base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass1 {

	RequestSpecification reqspec;
	Response response;
	
	public void addHeaders(Headers headers) {
		reqspec= RestAssured.given().headers(headers);
	}
	public RequestSpecification addBody(Object body) {
	reqspec =	reqspec.body(body);
      return reqspec;
	}
	
	public void addHeader(String key, String value ) {
           reqspec = RestAssured.given().header(key,value);
	}
	public void addPathParam(String key , String value) {
		reqspec = reqspec.pathParam(key, value);
	}
	public void addQueryParam(String key, String value) {
		reqspec = reqspec.queryParam(key, value);
	}
	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}
	public Response requestType(String type, String endpoint) {
		switch(type){
		case "GET":
			response=reqspec.log().all().get(endpoint);
			break;
		case "POST":
			response= reqspec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqspec.log().all().put(endpoint);
		case "DELETE":
			response = reqspec.log().all().delete(endpoint);
			break;
			default:
				break;
		}
		return response;	
		}
public void login(String username,String password) {
	 reqspec.auth().preemptive().basic( username, password);

}
public int getStatusCode(Response response) {
	int statusCode = response.getStatusCode();
 return statusCode;
}

public String getResBodyAsPrettyString(Response response) {
	String prettyString = response.asPrettyString();
	int a=1;
	return prettyString;

}

}

