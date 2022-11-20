package com.mapperwrite;

import java.util.ArrayList;
import java.util.List;

public class Pojo1 {
	
	private String name;
	private String email;
    private long phone;
   // private Pojoo2 address;
    private List<String> courses;
	
	public ArrayList<String> getCourses() {
		return (ArrayList<String>) courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	//public Pojoo2 getAddress() {
		//return address;
	//}
	//public void setAddress(Pojoo2 address) {
		//this.address = address;
	//}
	

	public Pojo1(String name, String email, long phone,List<String> courses  ) {// Pojoo2 pj2
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email= email;
		this.phone = phone;
		//this.address = pj2;
		this.courses= courses;
		
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}