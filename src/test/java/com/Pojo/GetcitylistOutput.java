package com.Pojo;

import java.util.ArrayList;

public class GetcitylistOutput {
	 public int status;
	    public String message;
	    public ArrayList<Citylist> data;
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public ArrayList<Citylist> getData() {
			return data;
		}
		public void setData(ArrayList<Citylist> data) {
			this.data = data;
		}
}
