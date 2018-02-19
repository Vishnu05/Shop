package com.moxman.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

 
@Entity
@Table
public class User implements Serializable {
	 
	 private static final long serialVersionUID=11L;
	
	@Id
	private String email;
	private String password;
	private String confirmpassword;
	private String phonenumber;
	private String fullname;
	private String role="Role_User";
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	 
	
	