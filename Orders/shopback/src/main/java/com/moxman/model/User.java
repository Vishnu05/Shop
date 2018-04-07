package com.moxman.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

 
@Entity
@Table
public class User implements Serializable {
	 
	 private static final long serialVersionUID=11L;
	
	@Id
	private String email;
	@NotBlank(message="Fill up")
	private String password;
	//@NotBlank(message="get")
  //	private String confirmpassword;
	private String phonenumber;
	private String firstname;
	private String lastname;
	private String role="Role_User";
	boolean enabled=true;
	private Date userdate;
	
	@OneToOne
	private Cart cartdetails;
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
 
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	 
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getUserdate() {
		return userdate;
	}
	public void setUserdate(Date userdate) {
		this.userdate = userdate;
	}
	public Cart getCartdetails() {
		return cartdetails;
	}
	public void setCartdetails(Cart cartdetails) {
		this.cartdetails = cartdetails;
	}
	 
	
	 
 
	
}
	 
	
	