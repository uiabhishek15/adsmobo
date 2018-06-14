package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ANKEM
 *
 */
public class ExperienceDTO implements Serializable {

	private static final long serialVersionUID = 3452747722864980398L;
	
	private List<String> experienceList = new ArrayList<String>(0);
	
	private String selectedExperience;
	
	public ExperienceDTO(){}
	
	public ExperienceDTO(String selectedExperience){
		this.selectedExperience = selectedExperience;
	}	

	public List<String> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<String> experienceList) {
		this.experienceList = experienceList;
	}

	public String getSelectedExperience() {
		return selectedExperience;
	}

	public void setSelectedExperience(String selectedExperience) {
		this.selectedExperience = selectedExperience;
	}
}
