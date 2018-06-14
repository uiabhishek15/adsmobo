package com.banana.spytutors.data.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author ANKEM
 *
 */
@Document(collection="campaign")
@TypeAlias("campaign")
public class Campaign implements Serializable {
	
	private static final long serialVersionUID = 6129993381348539087L;
	
	private ObjectId id = new ObjectId();
	
	@Field("campaignName")
	private String campaignName;
	
	@Field("campaignBudget")
	private String campaignBudget;
	
	@Field("costperClick")
	private String costperClick;
	
	@Field("adTitle")
	private String adTitle;
	
	@Field("adDescription")
	private String adDescription;
	
	@Field("adLandingUrl")
	private String adLandingUrl;
	
	@Field("adImageUrl")
	private String adImageUrl;	
	
	public Campaign(){
		this.id = ObjectId.get();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignBudget() {
		return campaignBudget;
	}

	public void setCampaignBudget(String campaignBudget) {
		this.campaignBudget = campaignBudget;
	}

	public String getCostperClick() {
		return costperClick;
	}

	public void setCostperClick(String costperClick) {
		this.costperClick = costperClick;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdDescription() {
		return adDescription;
	}

	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
	}

	public String getAdLandingUrl() {
		return adLandingUrl;
	}

	public void setAdLandingUrl(String adLandingUrl) {
		this.adLandingUrl = adLandingUrl;
	}

	public String getAdImageUrl() {
		return adImageUrl;
	}

	public void setAdImageUrl(String adImageUrl) {
		this.adImageUrl = adImageUrl;
	}

}
