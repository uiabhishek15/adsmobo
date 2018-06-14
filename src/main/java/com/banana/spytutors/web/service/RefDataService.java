package com.banana.spytutors.web.service;

import java.io.Serializable;
import java.util.List;

import com.banana.spytutors.web.dto.CountryDTO;
import com.banana.spytutors.web.dto.CurrencyDTO;
import com.banana.spytutors.web.dto.PriceRangePerHourDTO;
import com.banana.spytutors.web.dto.CampaignDTO;

/**
 * 
 * @author ANKEM
 *
 */

public interface RefDataService  extends Serializable {
	
	public List<CurrencyDTO> fetchCurrencyList();
	
	public List<CampaignDTO> fecthSubjectList();
	
	public List<PriceRangePerHourDTO> fetchPriceRangePerHourDTOList(CountryDTO country);
	
	public List<String> fetchQualificationList();
	
	public List<String> fetchExperienceList();

	public List<String> fetchEducationList();
}
