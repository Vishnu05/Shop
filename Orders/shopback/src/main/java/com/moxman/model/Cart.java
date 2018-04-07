package com.moxman.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
//import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Cart  {

	@Id
	@GeneratedValue
	private int citemid;
	 
	 
	private int cartid;
  
 
	private int proid;
 
	//@NotNull(message="Mininum 1 quantity")
	private String prodname;
 
	private String quantity;
	 
	 
	private String price;
	 
	 
	private String email;
	
	private Date cartdate;
	
	@Transient
	MultipartFile pimage;
	

	
	
	public int getCitemid() {
		return citemid;
	}

	public void setCitemid(int citemid) {
		this.citemid = citemid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}
  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getCartdate() {
		return cartdate;
	}

	public void setCartdate(Date cartdate) {
		this.cartdate = cartdate;
	}

	 

 
}