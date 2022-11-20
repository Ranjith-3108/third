package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonarray {

	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader("C:\\Users\\91978\\eclipse-workspace\\API1\\src\\test\\resources\\Jsonarray.json");
		JSONParser json = new JSONParser();
		Object parse = json.parse(file);
		
		JSONObject json2 = (JSONObject) parse;
	//	System.out.println(json2);
		Object object = json2.get("page");
		//System.out.println(object);
		Object object2 = json2.get("per_page");
		//System.out.println(object2);
		Object object3 = json2.get("data");
		JSONArray array=(JSONArray)object3;
		Object object4 = array.get(2);
		//System.out.println(object4);
		for (int i = 0; i < array.size(); i++) {
			Object object5 = array.get(i);	
		//System.out.println(object5);
		}
		JSONObject json3 = (JSONObject)object4;
		Object object6 = json3.get("id");
		
		System.out.println(object6);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
