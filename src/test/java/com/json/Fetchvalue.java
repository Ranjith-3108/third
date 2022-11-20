package com.json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Fetchvalue {

	public static void main(String[] args) throws IOException, Exception {
		//Mention the path of the json file
		FileReader file = new FileReader("C:\\Users\\91978\\eclipse-workspace\\API1\\src\\test\\resources\\fetchvalue.json");
		
		//create the object for json parser class
		JSONParser json = new JSONParser();
		
		//Pass the method &fetch the values
		Object object = json.parse(file);
		
		// convert to json object(Type class conversion)
		JSONObject js = (JSONObject)object;
		//System.out.println(js);// fetch the whole file
		
		//if we want inside the object"data"
		Object object2 = js.get("data");
		//System.out.println(object2);
		
		// if we want the "support" data
		Object object3 = js.get("support");
		//System.out.println(object3);
		
		//If we want inside the data object -paticular object(like -id)
		// we have to again inside the curly braces .so once again
		// we have convert JSON class ..then only we can get
		
		//    "data"
		JSONObject json2=(JSONObject)object2;
		Object object4 = json2.get("id");
		System.out.println(object4);
		
		//   "support"
		JSONObject json3 =(JSONObject)object3;
		Object object5 = json3.get("url");
		System.out.println(object5);
			
	}
}
