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
@Document(collection="postalCode")
@TypeAlias("postalCode")
public class PostalCode implements Serializable{

	private static final long serialVersionUID = -3247545481693276104L;
	
	private ObjectId id;
	
    @Field("adminCode2")
	private String adminCode2;
	
	@Field("adminCode3")
    private String adminCode3;
	
	@Field("adminName3")
	private String adminName3;
	
	@Field("adminCode1")
	private String adminCode1;
	
	@Field("adminName2")
	private String adminName2;
	
	@Field("lng")
	private String lng;
	
	@Field("countryCode")
	private String countryCode;
	
	@Field("postalcode")
	private String postalcode;
	
	@Field("adminName1")
	private String adminName1;
	
	@Field("placeName")
	private String placeName;
	
	@Field("lat")
	private String lat;	
	
	public PostalCode(){
		this.id = ObjectId.get();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getAdminCode2() {
		return adminCode2;
	}

	public void setAdminCode2(String adminCode2) {
		this.adminCode2 = adminCode2;
	}

	public String getAdminCode3() {
		return adminCode3;
	}

	public void setAdminCode3(String adminCode3) {
		this.adminCode3 = adminCode3;
	}

	public String getAdminName3() {
		return adminName3;
	}

	public void setAdminName3(String adminName3) {
		this.adminName3 = adminName3;
	}

	public String getAdminCode1() {
		return adminCode1;
	}

	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}

	public String getAdminName2() {
		return adminName2;
	}

	public void setAdminName2(String adminName2) {
		this.adminName2 = adminName2;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getAdminName1() {
		return adminName1;
	}

	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
}
