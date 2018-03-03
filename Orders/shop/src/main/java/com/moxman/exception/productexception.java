package com.moxman.exception;

import java.io.Serializable;

public class productexception extends Exception implements Serializable{

	 
	private static final long serialVersionUID = 1L;

	private String message;
	
	public productexception() {
	this("Not available");
	}
	
	
	public productexception(String message) {
		
		this.message=System.currentTimeMillis()+":"+message;
	}


	public String getMessage() {
		return message;
	}


 
}
