package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EducationDTO implements Serializable{

	private static final long serialVersionUID = 6525628644248122726L;

	private List<String> educationList = new ArrayList<String>(0);
	
	private String selectedEducation;

	public EducationDTO() {}
	
	public EducationDTO(String selectedEducation){
		this.setSelectedEducation(selectedEducation);
	}

	public List<String> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<String> educationList) {
		this.educationList = educationList;
	}

	public String getSelectedEducation() {
		return selectedEducation;
	}

	public void setSelectedEducation(String selectedEducation) {
		this.selectedEducation = selectedEducation;
	}
}
