package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class PostalCodeDTO implements Serializable{

	private static final long serialVersionUID = 7551792556509093281L;
	
	private BigInteger id;
	
	private String adminCode2;
	
	private String adminCode3;
	
	private String adminName3;
	
	private String adminCode1;
	
	private String adminName2;
	
	private String lng;
	
	private String countryCode;
	
	private String postalcode;
	
	private String adminName1;
	
	private String placeName;
	
	private String lat;	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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
