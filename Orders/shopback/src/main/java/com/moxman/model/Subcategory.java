package com.moxman.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Subcategory implements Serializable  {
	
	private static final long serialVersionUID=11L;
	
	@Id
	@GeneratedValue
	int subcatid;
		
	
	@NotNull
	String subcatname;
	
	@NotNull 
	String subcatdescription;
	
	
	int catid;
	
	public Subcategory() {
		super();
	}

	public int getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(int subcatid) {
		this.subcatid = subcatid;
	}

	public String getSubcatname() {
		return subcatname;
	}

	public void setSubcatname(String subcatname) {
		this.subcatname = subcatname;
	}

	public String getSubcatdescription() {
		return subcatdescription;
	}

	public void setSubcatdescription(String subcatdescription) {
		this.subcatdescription = subcatdescription;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	
	
	

}
