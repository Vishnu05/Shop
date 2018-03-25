package com.moxman.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	@NotBlank(message="get")
  //	private String confirmpassword;
	private String phonenumber;
	private String firstname;
	private String lastname;
	private String role="Role_User";
	boolean enabled=true;
	private Date userdate;
	
	
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
 
//	public String getConfirmpassword() {
//		return confirmpassword;
//	}
//	public void setConfirmpassword(String confirmpassword) {
//		this.confirmpassword = confirmpassword;
//	}
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
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public Date getUserdate() {
		return userdate;
	}
	public void setUserdate(Date userdate) {
		this.userdate = userdate;
	}
	 
	
	 
/**	String username;
	String password; 
	String firstname; 
	String lastname;
	String role="Role_User";
	boolean enabled=true;
	String email;
	String gender;
	String address;
	String mobile;
*/
	
}
	 
	
	