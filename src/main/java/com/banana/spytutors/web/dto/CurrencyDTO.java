package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class CurrencyDTO implements Serializable {

	private static final long serialVersionUID = 6893699867820373792L;
	
	private String countryName;
	
	private String name;
	
	private String currencyCode;
	
	private String symbol;
	
	private String iso4217Code;
	
	public CurrencyDTO(){}
	
	public CurrencyDTO(String currencyCode,String symbol){
		this.currencyCode = currencyCode;
		this.symbol = symbol;
	}
	
	public CurrencyDTO(String countryName,String currencyCode,String name,String symbol){
		this.countryName = countryName;
		this.currencyCode = currencyCode;
		this.name = name;
		this.symbol = symbol;
	}
	
	public CurrencyDTO(String countryName,String currencyCode,String name,String symbol,String iso4217Code){
		this.countryName = countryName;
		this.currencyCode = currencyCode;
		this.name = name;
		this.symbol = symbol;
		this.iso4217Code = iso4217Code;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getIso4217Code() {
		return iso4217Code;
	}

	public void setIso4217Code(String iso4217Code) {
		this.iso4217Code = iso4217Code;
	}
}
