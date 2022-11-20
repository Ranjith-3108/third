package com.mapperwrite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File file = new File("C:\\Users\\91978\\eclipse-workspace\\API1\\src\\test\\resources\\write5.json");
		
		ObjectMapper map = new ObjectMapper();
		
		List<String> courses = new ArrayList<String>();
		courses.add("java");
		courses.add("sql");		
		Pojo1 pj1 = new Pojo1("ranjith","ranjith@gmail.com",9789076557l,courses );
		map.writeValue(file, pj1);	
	}	
}