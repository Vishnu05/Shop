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
public class Category implements Serializable  {
	
	private static final long serialVersionUID=101L;
	
	@Id
	@GeneratedValue
	int catid;
	
	String catname;
	
	
	String catdescription;
	
	
	
	public Category()
	{
		super();
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdescription() {
		return catdescription;
	}

	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}



	
	
}