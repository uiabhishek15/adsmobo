package com.banana.spytutors.data.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author ANKEM
 *
 */
@Document(collection="country")
@TypeAlias("country")
public class Country {	
	
	@Id
	private ObjectId id;	
	
	@Field("continent")
	private String continent;
	
	@Field("capital")
	private String capital;
	
	@Field("languages")
	private String languages;
	
	@Field("geonameId")
	private String geonameId;
	
	@Field("south")
	private String south;
	
	@Field("isoAlpha3")
	private String isoAlpha3;
	
	@Field("north")
	private String north;
	
	@Field("fipsCode")
	private String fipsCode;
	
	@Field("population")
	private String population;
	
	@Field("east")
	private String east;
	
	@Field("isoNumeric")
	private String isoNumeric;
	
	@Field("areaInSqKm")
	private String areaInSqKm;
	
	@Field("countryCode")
	private String countryCode;
	
	@Field("west")
	private String west;
	
	@Field("countryName")
	private String countryName;
	
	@Field("continentName")
	private String continentName;
	
	@Field("currencyCode")
	private String currencyCode;	
	
	public Country(){
		this.id = ObjectId.get();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public String getIsoAlpha3() {
		return isoAlpha3;
	}

	public void setIsoAlpha3(String isoAlpha3) {
		this.isoAlpha3 = isoAlpha3;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getFipsCode() {
		return fipsCode;
	}

	public void setFipsCode(String fipsCode) {
		this.fipsCode = fipsCode;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getIsoNumeric() {
		return isoNumeric;
	}

	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}

	public String getAreaInSqKm() {
		return areaInSqKm;
	}

	public void setAreaInSqKm(String areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}	
}
