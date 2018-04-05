package com.moxman.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table
public class Category implements Serializable  {
	
	private static final long serialVersionUID=101L;
	
	@Id
	@GeneratedValue
	private int catid;
	
	@NotNull
	private String catname;
	
	@NotNull
	private String catdescription;
	
	private Date catdate;
	
	
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

	public Date getCatdate() {
		return catdate;
	}

	public void setCatdate(Date catdate) {
		this.catdate = catdate;
	}



	
	
}