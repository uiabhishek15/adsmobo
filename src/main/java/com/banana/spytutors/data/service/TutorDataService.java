package com.banana.spytutors.data.service;

import java.math.BigInteger;
import java.util.List;

import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.entity.User;

/**
 * 
 * @author ANKEM
 *
 */
public interface TutorDataService {

	public void saveTutor(User user);

	public List<Tutor> getAllTutorsByCountry(BigInteger countryId);

	/*public List<Tutor> getAllTutorsByCity(String city);*/

	public List<Tutor> getAllTutorsBySubject(String subject);

	public List<Tutor> getAllTutorsByQualification(String qualification);
	
	public List<Tutor> getRecentlyAddedTutors();

}
