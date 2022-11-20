package com.Pojo;

import java.util.ArrayList;

public class ProductSearchOutput {
	private int status;
    private String message;
    private ArrayList<ProductSearch> data;
    private int getStatus() {
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
	public ArrayList<ProductSearch> getData() {
		return data;
	}
	public void setData(ArrayList<ProductSearch> data) {
		this.data = data;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String currency;

}
