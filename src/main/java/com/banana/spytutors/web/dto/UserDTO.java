package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class UserDTO implements Serializable {

	private static final long serialVersionUID = 8814942894613526246L;	
	
	private int id;
		
	private String fullname;
	
    private String email;
	
    private String password;
    
    private String mobile;
    
    private String company;
    
    private String website;
    
    private String state;
    
    private String city;
    
    private List<CampaignDTO> campaignList = new ArrayList<CampaignDTO>(0);
    
    private CampaignDTO campaignDTO = new CampaignDTO();

	public int  getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CampaignDTO getCampaignDTO() {
		return campaignDTO;
	}

	public void setCampaignDTO(CampaignDTO campaignDTO) {
		this.campaignDTO = campaignDTO;
	}

	public List<CampaignDTO> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<CampaignDTO> campaignList) {
		this.campaignList = campaignList;
	}

}
