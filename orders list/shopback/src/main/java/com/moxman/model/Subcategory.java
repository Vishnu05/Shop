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
public class Subcategory implements Serializable  {
	
	private static final long serialVersionUID=11L;
	
	@Id
	@GeneratedValue
	private int subcatid;
		
	
	@NotNull
	private String subcatname;
	
	@NotNull 
	private String subcatdescription;
	
	private Date subcatdate;
	
	
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

	public Date getSubcatdate() {
		return subcatdate;
	}

	public void setSubcatdate(Date subcatdate) {
		this.subcatdate = subcatdate;
	}

	
	
	

}
