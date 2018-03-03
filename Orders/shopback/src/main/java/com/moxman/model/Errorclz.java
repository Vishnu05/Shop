package com.moxman.model;


public class Errorclz {

	private int code;
	private String message;
	
	public Errorclz(int code,String message) {
		super();
		this.code=code;
		this.message=message;
		 
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
