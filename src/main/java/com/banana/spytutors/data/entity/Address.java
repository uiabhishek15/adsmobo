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
@Document(collection="address")
@TypeAlias("address")
public class Address implements Serializable {

	private static final long serialVersionUID = -1158974299486087173L;
	
	private ObjectId id;

	@Field("country")
	private Country country = new Country();
	
	@Field("subRegion")
	private Campaign subRegion = new Campaign();
	
	@Field("state")
	private Campaign state = new Campaign();
	
	@Field("city")
	private Campaign city = new Campaign();
	
	@Field("postalCode")
	private PostalCode postalCode = new PostalCode();
	
	@Field("landmark")
	private String landmark;
	
	@Field("address")
	private String address;	
	
	public Address(){
		this.id = ObjectId.get();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Campaign getSubRegion() {
		return subRegion;
	}

	public void setSubRegion(Campaign subRegion) {
		this.subRegion = subRegion;
	}

	public Campaign getState() {
		return state;
	}

	public void setState(Campaign state) {
		this.state = state;
	}

	public Campaign getCity() {
		return city;
	}

	public void setCity(Campaign city) {
		this.city = city;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
