package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class GenderDTO implements Serializable {

	private static final long serialVersionUID = -7015225587112661296L;
	
	private String name;
	
	private Boolean selected;
	
	private String genderStyle = "width:80px;height:23px;";
	
	public GenderDTO(){}
	
	public GenderDTO(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getGenderStyle() {
		return genderStyle;
	}

	public void setGenderStyle(String genderStyle) {
		this.genderStyle = genderStyle;
	}	
}
