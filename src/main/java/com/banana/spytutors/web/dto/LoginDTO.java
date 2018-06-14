package com.banana.spytutors.web.dto;

import java.io.Serializable;


/**
 * 
 * @author ANKEM
 *
 */
public class LoginDTO implements Serializable{

	private static final long serialVersionUID = -6650116255818363568L;
	
	private String email;
	
	private String password;
	
	private String oldpassword;
	
	private String newpassword;
	
	private String confirmpassword;
	
	private UserDTO fetchedTutor = new UserDTO();

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

	public UserDTO getFetchedTutor() {
		return fetchedTutor;
	}

	public void setFetchedTutor(UserDTO fetchedTutor) {
		this.fetchedTutor = fetchedTutor;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
