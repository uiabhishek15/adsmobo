package com.banana.spytutors.web.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ANKEM
 *
 */
public class PriceRangePerHourDTO implements Serializable{
	
	private static final long serialVersionUID = -7857769840177098087L;

	private String minPrice;
	
	private String maxPrice;	
	
	private CurrencyDTO currency = new CurrencyDTO();
	
	private String savedPriceRange;
	
	public PriceRangePerHourDTO(){}
	
	public PriceRangePerHourDTO(String minPrice,String maxPrice,CurrencyDTO currency){
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.currency = currency;
	}
	
	public PriceRangePerHourDTO(String savedPriceRange){
		this.savedPriceRange = savedPriceRange;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}    	
	
	public CurrencyDTO getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyDTO currency) {
		this.currency = currency;
	}	

	public String getSavedPriceRange() {
		return savedPriceRange;
	}

	public void setSavedPriceRange(String savedPriceRange) {
		this.savedPriceRange = savedPriceRange;
	}

	public String getPriceRange(){
		if(StringUtils.isBlank(minPrice) && StringUtils.isNotBlank(maxPrice)){
			return currency.getSymbol()+" "+maxPrice+" and above";
		}
		return currency.getSymbol()+" "+minPrice+" - "+currency.getSymbol()+" "+maxPrice;		
	}
}
