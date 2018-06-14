package com.banana.spytutors.data.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author ANKEM
 *
 */
@Document(collection="advertiser")
@TypeAlias("advertiser")
public class User extends AuditTrail {

	private static final long serialVersionUID = -3198585917688846837L;
	
	private ObjectId id;
	
	public User(){
		this.id = ObjectId.get();
	}
		
	@Field("fullName")
	private String fullName;
	
	@Field("email")
	private String email;
	
	@Field("password")
	private String password;	
	
	@Field("mobile")
	private String mobile;
	
	@Field("company")
	private String company;	
	
	@Field("website")
	private String website;
	
	@Field("state")
	private String state;	
	
	@Field("city")
	private String city;
	
	@Field("campaignList")
	private List<Campaign> campaignList;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}

}
