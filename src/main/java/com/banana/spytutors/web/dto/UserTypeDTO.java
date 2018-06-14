package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class UserTypeDTO implements Serializable {

	private static final long serialVersionUID = -8772596838914018293L;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
