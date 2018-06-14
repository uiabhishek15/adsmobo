package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ANKEM
 *
 */
public class TutorSearchDTO implements Serializable {

	private static final long serialVersionUID = -6122759329775868313L;
	
	private List<TutorDTO> fetchedTutorList = new ArrayList<TutorDTO>(0);
	
	private TutorDTO selectedTutor = new TutorDTO();
	
	private String searchedCity;
	
	private String searchedSubject;  
	
	private List<CampaignDTO> subjectList = new ArrayList<CampaignDTO>(0);
	
	private String selectedQualification;
	
	private List<String> qualificationList = new ArrayList<String>(0);
	
	public List<TutorDTO> getFetchedTutorList() {
		return fetchedTutorList;
	}

	public void setFetchedTutorList(List<TutorDTO> fetchedTutorList) {
		this.fetchedTutorList = fetchedTutorList;
	}

	public TutorDTO getSelectedTutor() {
		return selectedTutor;
	}

	public void setSelectedTutor(TutorDTO selectedTutor) {
		this.selectedTutor = selectedTutor;
	}

	public String getSearchedCity() {
		return searchedCity;
	}

	public void setSearchedCity(String searchedCity) {
		this.searchedCity = searchedCity;
	}

	public String getSearchedSubject() {
		return searchedSubject;
	}

	public void setSearchedSubject(String searchedSubject) {
		this.searchedSubject = searchedSubject;
	}

	public List<CampaignDTO> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<CampaignDTO> subjectList) {
		this.subjectList = subjectList;
	}

	public String getSelectedQualification() {
		return selectedQualification;
	}

	public void setSelectedQualification(String selectedQualification) {
		this.selectedQualification = selectedQualification;
	}

	public List<String> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(List<String> qualificationList) {
		this.qualificationList = qualificationList;
	}
	
}
