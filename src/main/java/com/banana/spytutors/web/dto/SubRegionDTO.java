package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 * @author ANKEM
 *
 */
public class SubRegionDTO implements Serializable {

	private static final long serialVersionUID = 7298755882362493799L;
	
	private BigInteger id;
	
    private String adminCode1;
	
	private String lng;
	
	private String geonameId;
	
	private String toponymName;
	
	private String countryId;
	
	private String fcl;
	
	private String population;
	
	private String numberOfChildren;
	
	private String countryCode;
	
	private String name;
	
	private String fclName;
	
	private String countryName;
	
	private String fcodeName;
	
	private String adminName1;
	
	private String lat;
	
	private String fcode;	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getAdminCode1() {
		return adminCode1;
	}

	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}

	public String getToponymName() {
		return toponymName;
	}

	public void setToponymName(String toponymName) {
		this.toponymName = toponymName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getFcl() {
		return fcl;
	}

	public void setFcl(String fcl) {
		this.fcl = fcl;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFclName() {
		return fclName;
	}

	public void setFclName(String fclName) {
		this.fclName = fclName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getFcodeName() {
		return fcodeName;
	}

	public void setFcodeName(String fcodeName) {
		this.fcodeName = fcodeName;
	}

	public String getAdminName1() {
		return adminName1;
	}

	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}	

}
