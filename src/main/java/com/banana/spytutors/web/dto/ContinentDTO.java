package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class ContinentDTO implements Serializable {

	private static final long serialVersionUID = 8322591381158168613L; 
	
	private String name;
	
	private String code;
	
	private String geonameId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}	
}
