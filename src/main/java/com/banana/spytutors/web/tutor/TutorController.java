package com.banana.spytutors.web.tutor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.entity.User;
import com.banana.spytutors.data.service.TutorDataService;
import com.banana.spytutors.web.common.LandingPageController;
import com.banana.spytutors.web.common.NavigationBean;
import com.banana.spytutors.web.converter.TutorConverter;
import com.banana.spytutors.web.dto.CampaignDTO;
import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.TutorSearchDTO;
import com.banana.spytutors.web.dto.UserDTO;
import com.banana.spytutors.web.service.RefDataService;
import com.banana.spytutors.web.service.TutorService;

/**
 * 
 * @author ANKEM
 *
 */
@ViewScoped
@ManagedBean(name = "tutorController")
@Component
public class TutorController extends LandingPageController implements
		Serializable {

	private static final long serialVersionUID = -4560027943004707457L;

	@Autowired
	private TutorService tutorService;

	private TutorSearchDTO tutorSearch = new TutorSearchDTO();

	private String type;
	
	public CampaignDTO selectedSubject = new CampaignDTO();

	@Autowired
	private RefDataService refDataService;
	
	private String selectedQualification;
	
	@Autowired
	private NavigationBean navBean;
	
	private String hiddenURL;	

	private static final Logger LOGGER = Logger.getLogger(TutorController.class);
	
	@Autowired
	private TutorDataService tutorDataService;
	
	private List<UserDTO> tutors;
	 
	/*public List<UserDTO> getTutors() {
		 List<User> tutorListForShowcase = tutorDataService.getRecentlyAddedTutors();
		 List<UserDTO> tutors = TutorConverter.convertTutorList(tutorListForShowcase);
		return tutors;
	}

	public void setTutors(List<UserDTO> tutors) {
		this.tutors = tutors;
	}*/


	public String getSelectedQualification() {
		return selectedQualification;
	}

	public void setSelectedQualification(String selectedQualification) {
		this.selectedQualification = selectedQualification;
	}

	public String getHiddenURL() {
		return hiddenURL;
	}

	public void setHiddenURL(String hiddenURL) {
		this.hiddenURL = hiddenURL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TutorSearchDTO getTutorSearch() {
		return tutorSearch;
	}

	public void setTutorSearch(TutorSearchDTO tutorSearch) {
		this.tutorSearch = tutorSearch;
	}

	public CampaignDTO getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(CampaignDTO selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

	@PostConstruct
	public void init() {
		LOGGER.info("Loading tutor subjectlist");
		loadRefData();
	}

	private void loadRefData() {
		tutorSearch.setSubjectList(refDataService.fecthSubjectList());
		tutorSearch.setQualificationList(refDataService.fetchQualificationList());
	}
	
/*	public void populateNavigationURL(){
		String hiddenURL = getHiddenURL();		 
		int hashIndex = hiddenURL.indexOf("#");
		String selectedSubject = hiddenURL.substring(hashIndex+1);
		selectTutorBySubject(new CampaignDTO(selectedSubject));		
	}*/

/*	public void updateTutorSearch(TutorSearchDTO tutorSearch) {
		List<TutorDTO> fetchedTutorList = tutorService
				.getAllTutorsByCity(tutorSearch.getSearchedCity());
		tutorSearch.setFetchedTutorList(fetchedTutorList);
		updateTutorType("tutors");
	}

	public void selectTutorBySubject(CampaignDTO selectedSubject) {
		List<TutorDTO> fetchedTutorList = tutorService
				.getAllTutorsBySubject(selectedSubject.getName());
		tutorSearch.setFetchedTutorList(fetchedTutorList);
		setSelectedSubject(selectedSubject);
		updateTutorType("tutors");		
	}*/

	public void updateTutorType(String type) {
		setType(type);
	}

	public void updateTutorCommandLink(TutorDTO selectedTutor, String type) {
		tutorSearch.setSelectedTutor(selectedTutor);
		updateTutorType(type);
	}
	
	
/*	public void selectTutorByQualification(String selectedqualification){
		List<TutorDTO> fetchedTutorList = tutorService.getAllTutorsByQualification(selectedQualification);
		tutorSearch.setFetchedTutorList(fetchedTutorList);
		setSelectedQualification(selectedqualification);
		updateTutorType("tutors");		
	}

	private void populateSelectedSubjectListString(
			List<TutorDTO> fetchedTutorList) {
		StringBuilder selectedSubjectListBuilder = new StringBuilder();
		for (TutorDTO fetchedTutor : fetchedTutorList) {
			List<CampaignDTO> selectedSubjectList = fetchedTutor
					.getSubjectList();
			for (CampaignDTO subject : selectedSubjectList) {
				selectedSubjectListBuilder.append(subject.getName());
				selectedSubjectListBuilder.append(" , ");
			}
			final int builderLength = selectedSubjectListBuilder.length();
			if (builderLength > 0) {
				selectedSubjectListBuilder.deleteCharAt(builderLength - 1);
			}
			fetchedTutor
					.setSelectedSubjectListString(selectedSubjectListBuilder
							.toString());
		}

	}*/
}
