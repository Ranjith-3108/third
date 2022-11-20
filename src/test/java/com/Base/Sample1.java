package com.Base;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pojo.AddUserAddress_Input;
import com.Pojo.AddUserAdress_Output;
import com.Pojo.Citylist;
import com.Pojo.DeleteuserAddressOutput;
import com.Pojo.DeleteuseraddressInput;
import com.Pojo.GetcitylistInput;
import com.Pojo.GetcitylistOutput;

import com.Pojo.Getstatelist;
import com.Pojo.Getstatelist_Output;
import com.Pojo.GetuserAdressoutput;
import com.Pojo.Login_Output;
import com.Pojo.ProductSearchInput;
import com.Pojo.ProductSearchOutput;
import com.Pojo.UpdateAddressI;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Sample1 extends Baseclass1 {
	String logtoken;                                            //="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijc5MmJmODI4YjhkYzY2NDIxMzNhNTE1ZjliZmY3MmJiMTE5MTA3ZTllMDUzY2ZhOTcwM2IwMTBmOGE2ZDY5N2M1ZTA1NTMyMmNiNjIzM2NmIn0.eyJhdWQiOiIzIiwianRpIjoiNzkyYmY4MjhiOGRjNjY0MjEzM2E1MTVmOWJmZjcyYmIxMTkxMDdlOWUwNTNjZmE5NzAzYjAxMGY4YTZkNjk3YzVlMDU1MzIyY2I2MjMzY2YiLCJpYXQiOjE2Njc1Njc2MTksIm5iZiI6MTY2NzU2NzYxOSwiZXhwIjoxNjk5MTAzNjE5LCJzdWIiOiIxMTY0Iiwic2NvcGVzIjpbXX0.OW025gHjIvq6VXipffR5G8-Adtx4oTlyVZrU7qcYPMOaHiYFJlksSDofIrdxJIzMSjtXX4aDALi_Ya9omKRiLYl8KMTt9hxXHEBxrkJ200ldCfpMZvv5ZiO6rKU0DxpwFxhc3fiTvMeF492WWuTOzz788efuseJm1emJH19INFFsSzp1p0HVvtLv7DATW8NnmEb8iDThcaMqJHUNPZ-XGke5jXO9blLCf38vke-BaGswj6uFc1x9Q6fZ1w_krg_T0roIYFtaoMs_rF8kxqYQzjNvTHmkJM-i8sCI53EaxP8weG2aQa6E1j5Op-8CUa9a_RjNLkap-XbTBL6qPhGBAcmZffaTsBDusUSzkbE0UOtwB8XOAUQb7N4HuQWQvy5IQiV7YrUcNbJFTIbAx7gsglqKuqGoMv9aSlAsN123Ifhvj6Emuc1iCr5_a2OQlG2EYUUo6xrdtV7hPhnsGdGc99XRDWV4eg1OwAsXmHYGD08VKYfaef5K6nTsZrffeUp76s4ZIZLM-7wpPLBFEP-n8EAZmewGDauHxivKIucV4y4jldJv4e-Z7X8oMszUylkVTDRPC9-paQNdbvPs_gNNI7BktKjnmVzslcsrLoI57r6bF2Re_TOZepRBecTUWDgDNhWkxm3bCA4g0WSqqqrlVN68L3pANcwAV1f2Ro9J_wU";
	String state_id;
	String address_id ;
	int city_id;
	int stateid;
	@Test(priority=1)
	public  void Tc1() {
		addHeader("accept", "application/json");
		login("ranjithyuvi512@gmail.com", "Ranjith@3108");
		Response response2 = requestType("POST","https://omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = getStatusCode(response2);
		Assert.assertEquals(statusCode, 200,"Verify the status code");		
		String prettyString = getResBodyAsPrettyString(response2);
		System.out.println(prettyString);			
		Login_Output login = response2.as(Login_Output.class);	
		String message = login.getMessage();
		Assert.assertEquals(message, "Login successfully","verify login sucessfull");
		logtoken = login.getData().getLogtoken();		
	}
	@Test(priority=4)
	public void addUserAdress() {
		List<Header> listheader = new ArrayList<>();
		Header h1 =new Header("accept","application/json");
		Header h2 =new Header("Authorization"," Bearer "+logtoken); 
		Header h3 =new Header("Content-Type","application/json");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers = new Headers(listheader);
		addHeaders(headers);                                    
		AddUserAddress_Input adduser = new AddUserAddress_Input("Yuvraj", "sing", "9789899899", "aj", 33, 100, 60097, "Tamilnadu", "xyz", "abc");
		addBody(adduser);
		Response response = requestType("POST","https://omrbranch.com/api/addUserAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"Verify Status code");
		AddUserAdress_Output output = response.as(AddUserAdress_Output.class);
		String message = output.getMessage();
		int address = output.getAddress_id();
		 address_id = String.valueOf(address);
		Assert.assertEquals(message,"Address added successfully","Verify Address message");
	}
	@Test(priority=5)
	public void updateAddress() {
		    List<Header>listheader = new ArrayList<Header>();
		    Header h1 = new Header("accept","application/json");
		    Header h2 = new Header("Authorization","Bearer "+logtoken); 
		    Header h3 = new  Header("Content-Type","application/json"); 
				  listheader.add(h1); listheader.add(h2); listheader.add(h3); 
				  Headers header =  new Headers(listheader);
				  addHeaders(header);
				  UpdateAddressI input=new UpdateAddressI(address_id,"Mani","Kundra","908478939","bhk",35, city_id,101,"60097","London","UK");
				  addBody(input);
				  Response response2 = requestType("PUT","https://omrbranch.com/api/updateUserAddress");
				  int statusCode = getStatusCode(response2);
				  System.out.println(statusCode);
				  Assert.assertEquals(statusCode, 200,"Verify the status code is 200");
				//  UpdateAddressO as = response2.as(UpdateAddressO.class);
				  //String message = as.getMessage();
				  //System.out.println(message);
				  //Assert.assertEquals(message,"Address updated successfully","Verify The Message");			  
	}
	@Test(priority=2)
	public void getStateList() {	
		addHeader("accept","application/json");
		Response requestType = requestType("GET","https://omrbranch.com/api/stateList");
		int statusCode = getStatusCode(requestType);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"Verify the status code");
		Getstatelist_Output output = requestType.as(Getstatelist_Output.class);
		ArrayList<Getstatelist> data = output.getData();
		for (Getstatelist getstatelist : data) {
			String name = getstatelist.getName();
			if(name.equals("Tamil Nadu")) {
				int id = getstatelist.getId();
				state_id = String.valueOf(id);
				//System.out.println(state_Id);
			}
		}
	}
    @Test(priority=3)
	public void getCitylist() {
		List<Header> listheader = new ArrayList<>();
		Header h1 =new Header("accept","application/json");
		Header h2 =new Header("Content-Type","application/json");
		listheader.add(h1);		listheader.add(h2);
		Headers headers = new Headers(listheader);
		addHeaders(headers);
		GetcitylistInput getcitylist2 = new GetcitylistInput(state_id);
		addBody(getcitylist2);
		Response type = requestType("POST","https://omrbranch.com/api/cityList");
		int code = getStatusCode(type);
		Assert.assertEquals(code,200,"verify the status code is 200");
		System.out.println(code);
		GetcitylistOutput output = type.as(GetcitylistOutput.class);
		ArrayList<Citylist> data = output.getData();
		//System.out.println("Ranjith"+data);
		for (Citylist getcitylist : data) {
			String name = getcitylist.getName();
			if(name.equals("Madurai")) {
				 city_id = getcitylist.getId();			
				System.out.println( city_id);
				break;
			}
		}
	
	}

         @Test(priority=6)
	public void getUserAdress() {
			List<Header>listheader = new ArrayList<Header>();
			Header h1 = new Header("accept","application/json");
			Header h2 = new Header("Authorization","Bearer "+logtoken);
			listheader.add(h1); listheader.add(h2);
			Headers header =  new Headers(listheader);
			addHeaders(header);
			Response requestType = requestType("GET","https://omrbranch.com/api/getUserAddress");
			int statusCode = getStatusCode(requestType);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode,200,"Verify The Status Code is 200");
			GetuserAdressoutput as = requestType.as(GetuserAdressoutput.class);
			String message = as.getMessage();
			Assert.assertEquals(message, "OK","Verify The Message is OK");
	}
         @Test(priority=7)
	public void deleteAddress() {
        	 List<Header>listheader = new ArrayList<Header>();
			  Header h1 = new Header("accept","application/json");
			  Header h2 = new Header("Authorization","Bearer "+logtoken); 
			  Header h3 = new  Header("Content-Type","application/json"); 
			  listheader.add(h1); listheader.add(h2); listheader.add(h3); 
			  Headers header =  new Headers(listheader);
			  addHeaders(header);
			  DeleteuseraddressInput input = new DeleteuseraddressInput(address_id);
			  addBody(input);
			  Response requestType = requestType("DELETE", "https://omrbranch.com/api/deleteAddress"); 
			  int statusCode = getStatusCode(requestType);
			  Assert.assertEquals(statusCode, 200,"Verify the status code is 200");
			  DeleteuserAddressOutput output = requestType.as(DeleteuserAddressOutput.class);
			  String message = output.getMessage();
			  System.out.println(message);
			  Assert.assertEquals(message, "Address deleted successfully","Verify The Address Deleted Succesfully");
	}
         @Test(priority=8)
	public void productSearch() {
		  List<Header>listheader = new ArrayList<Header>();
		  Header h1 = new Header("accept","application/json");
		  Header h2 = new  Header("Content-Type","application/json");
		  listheader.add(h1); listheader.add(h2);
		  Headers header =  new Headers(listheader);
		  addHeaders(header);
		  ProductSearchInput product = new ProductSearchInput("nuts");
		  addBody(product);
		  Response requestType = requestType("POST", "https://omrbranch.com/api/searchProduct");
		  int statusCode = getStatusCode(requestType);
		  System.out.println(statusCode);
		  Assert.assertEquals(statusCode, 200,"Verify the status code is 200");
		  ProductSearchOutput pd = requestType.as(ProductSearchOutput.class);
		  String message = pd.getMessage();
		  Assert.assertEquals(message, "OK","Verify the message is ok");
		  
		  
	}
	
	
	
	
	
	
	
	
	
	
}
