package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class CampaignDTO implements Serializable {

	private static final long serialVersionUID = 3279504932714518692L;
	
	private BigInteger id;
		
	private String campaignname;
	
	private String campaignbudget;
	
	//private String costperclick;
	
	private String adtitle;
	
	private String addescription;

	private String adlandingurl;

	//private String adimageurl;
	
	public CampaignDTO(){}
	
	public CampaignDTO(String campaignname){
		this.campaignname = campaignname;
	}
	
	public CampaignDTO(String campaignname,String campaignbudget){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
	}
	
	/*public CampaignDTO(String campaignname,String campaignbudget,String costperclick){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
		//this.costperclick = costperclick;
	}*/
	
	public CampaignDTO(String campaignname,String campaignbudget,String adtitle){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
		//this.costperclick = costperclick;
		this.adtitle = adtitle;
	}	
	
	public CampaignDTO(String campaignname,String campaignbudget,String adtitle,String addescription){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
		//this.costperclick = costperclick;
		this.adtitle = adtitle;
		this.addescription = addescription;
	}
	
	public CampaignDTO(String campaignname,String campaignbudget,String adtitle,String addescription,String adlandingurl){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
		//this.costperclick = costperclick;
		this.adtitle = adtitle;
		this.addescription = addescription;
		this.adlandingurl = adlandingurl;
	}
	
/*	public CampaignDTO(String campaignname,String campaignbudget,String adtitle,String addescription,String adlandingurl,String adimageurl){
		this.campaignname = campaignname;
		this.campaignbudget = campaignbudget;
		//this.costperclick = costperclick;
		this.adtitle = adtitle;
		this.addescription = addescription;
		this.adlandingurl = adlandingurl;
		this.adimageurl = adimageurl;
	}*/

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCampaignname() {
		return campaignname;
	}

	public void setCampaignname(String campaignname) {
		this.campaignname = campaignname;
	}

	public String getCampaignbudget() {
		return campaignbudget;
	}

	public void setCampaignbudget(String campaignbudget) {
		this.campaignbudget = campaignbudget;
	}

/*	public String getCostperclick() {
		return costperclick;
	}

	public void setCostperclick(String costperclick) {
		this.costperclick = costperclick;
	}*/

	public String getAdtitle() {
		return adtitle;
	}

	public void setAdtitle(String adtitle) {
		this.adtitle = adtitle;
	}

	public String getAddescription() {
		return addescription;
	}

	public void setAddescription(String addescription) {
		this.addescription = addescription;
	}

	public String getAdlandingurl() {
		return adlandingurl;
	}

	public void setAdlandingurl(String adlandingurl) {
		this.adlandingurl = adlandingurl;
	}

	/*public String getAdimageurl() {
		return adimageurl;
	}

	public void setAdimageurl(String adimageurl) {
		this.adimageurl = adimageurl;
	}*/

}