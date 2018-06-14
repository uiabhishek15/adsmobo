package com.banana.spytutors.web.service;

import java.math.BigInteger;
import java.util.List;

import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.UserDTO;

/**
 * 
 * @author ANKEM
 *
 */
public interface TutorService {
	
	public void saveTutor(UserDTO user);
	
	/*public List<TutorDTO> getAllTutorsByCountry(BigInteger countryId);
	
	public List<TutorDTO> getAllTutorsByCity(String city);
	
	public List<TutorDTO> getAllTutorsBySubject(String subject);
	
	public List<TutorDTO> getAllTutorsByQualification(String qualification);

	public List<TutorDTO> getRecentlyAddedTutors();*/
	
}
