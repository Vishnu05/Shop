package com.moxman.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Coupons {

	@Id
	@GeneratedValue
	private int id;
	
	private String couponid;
	
	private String expirydate;
	
	private Date coupondate;
	
	private String percent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouponid() {
		return couponid;
	}

	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public Date getCoupondate() {
		return coupondate;
	}

	public void setCoupondate(Date coupondate) {
		this.coupondate = coupondate;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	 
}