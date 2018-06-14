package com.banana.spytutors.web.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ANKEM
 *
 */
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1253162755681947428L;	
	
	private BigInteger id;

	private ContinentDTO continent = new ContinentDTO();
	
	private CountryDTO selectedCountry = new CountryDTO();	
	
	private SubRegionDTO state = new SubRegionDTO();
	
    private SubRegionDTO city = new SubRegionDTO(); 
    
    private SubRegionDTO subRegion = new SubRegionDTO();
    
    private PostalCodeDTO postalCode = new PostalCodeDTO();
    
    private String address;
    
    private String landmark;
    
    private List<ContinentDTO> continentList = new ArrayList<ContinentDTO>(0);
	
	private List<SubRegionDTO> statesList = new ArrayList<SubRegionDTO>(0);
	
	private List<SubRegionDTO> cityList = new ArrayList<SubRegionDTO>(0);
	
	private List<SubRegionDTO> subRegionList = new ArrayList<SubRegionDTO>(0);		

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public PostalCodeDTO getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCodeDTO postalCode) {
		this.postalCode = postalCode;
	}	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public ContinentDTO getContinent() {
		return continent;
	}

	public void setContinent(ContinentDTO continent) {
		this.continent = continent;
	}
	
	public SubRegionDTO getSubRegion() {
		return subRegion;
	}

	public void setSubRegion(SubRegionDTO subRegion) {
		this.subRegion = subRegion;
	}

	public List<SubRegionDTO> getSubRegionList() {
		return subRegionList;
	}

	public void setSubRegionList(List<SubRegionDTO> subRegionList) {
		this.subRegionList = subRegionList;
	}	

	public SubRegionDTO getCity() {
		return city;
	}

	public void setCity(SubRegionDTO city) {
		this.city = city;
	}

	public List<SubRegionDTO> getCityList() {
		return cityList;
	}

	public void setCityList(List<SubRegionDTO> cityList) {
		this.cityList = cityList;
	}	
	
	public CountryDTO getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(CountryDTO selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public SubRegionDTO getState() {
		return state;
	}

	public void setState(SubRegionDTO state) {
		this.state = state;
	}

	public List<SubRegionDTO> getStatesList() {
		return statesList;
	}

	public void setStatesList(List<SubRegionDTO> statesList) {
		this.statesList = statesList;
	}

	public List<ContinentDTO> getContinentList() {
		return continentList;
	}

	public void setContinentList(List<ContinentDTO> continentList) {
		this.continentList = continentList;
	}
}
