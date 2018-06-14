package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author ANKEM
 *
 */
public class TutorDTO implements Serializable {

	private static final long serialVersionUID = 2723350636660588255L;
	
	private int id;
   
	private UserDTO tutor = new UserDTO();
	
	private List<CampaignDTO> campaignList = new ArrayList<CampaignDTO>(0);
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getTutor() {
		return tutor;
	}

	public void setTutor(UserDTO tutor) {
		this.tutor = tutor;
	}

	public List<CampaignDTO> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<CampaignDTO> campaignList) {
		this.campaignList = campaignList;
	}    

}
