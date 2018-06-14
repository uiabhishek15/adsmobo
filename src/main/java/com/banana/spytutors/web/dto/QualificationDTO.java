package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ANKEM
 *
 */
public class QualificationDTO implements Serializable {

	private static final long serialVersionUID = 7816041485558457046L;
	
	private List<String> qualificationList = new ArrayList<String>(0);
	
	private String selectedQualification;
	
	public QualificationDTO(){}
	
	public QualificationDTO(String selectedQualification){
		this.selectedQualification = selectedQualification;
	}

	public List<String> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(List<String> qualificationList) {
		this.qualificationList = qualificationList;
	}

	public String getSelectedQualification() {
		return selectedQualification;
	}

	public void setSelectedQualification(String selectedQualification) {
		this.selectedQualification = selectedQualification;
	}	
}
