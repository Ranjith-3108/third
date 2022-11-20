package com.objectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	public static void main(String[] args) throws IOException {
		
	
	File file = new File("C:\\Users\\91978\\eclipse-workspace\\API1\\src\\test\\resources\\objectmapper.json");
	
	ObjectMapper m= new ObjectMapper();
	
	Pojo1 read = m.readValue(file,Pojo1.class);
	
	int page = read.getPage();
	System.out.println(page);
	int per_page = read.getPer_page();
	System.out.println(per_page);
	int total = read.getTotal();
	System.out.println(total);
	int total_pages = read.getTotal_pages();
	System.out.println(total_pages);
	
	Support support = read.getSupport();
	String url = support.getUrl();
	System.out.println(url);
	String text = support.getText();
	System.out.println(text);
		
		
	ArrayList<Pojo2> list = read.getData();
	for (Pojo2 pojo2 : list) {
		System.out.println(pojo2.getId());
		System.out.println(pojo2.getFirst_name());
		System.out.println(pojo2.getLast_name());
		System.out.println(pojo2.getAvatar());
		System.out.println(pojo2.getEmail());
		
	}
	}
	}


