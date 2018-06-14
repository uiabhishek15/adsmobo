package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class SubjectTypeDTO implements Serializable{

	private static final long serialVersionUID = -1339895387864855619L;

	private String name;
	
	private String specialization;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}	
}
