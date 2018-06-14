package com.banana.spytutors.web.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.service.TutorDataService;
import com.banana.spytutors.web.converter.TutorConverter;
import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.UserDTO;

/**
 * 
 * @author ANKEM
 *
 */
public class TutorServiceImpl implements TutorService {

	@Autowired
	private TutorDataService tutorDataService;

	@Override
	public void saveTutor(UserDTO user) {
		// TODO Auto-generated method stub
		tutorDataService.saveTutor(TutorConverter.transferTutorDTO(user));
	}

/*	@Override
	public List<TutorDTO> getAllTutorsByCountry(BigInteger countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TutorDTO> getAllTutorsByCity(String city) {
		List<Tutor> tutorList = tutorDataService.getAllTutorsByCity(city);
		return TutorConverter.convertTutorList(tutorList);
	}

	@Override
	public List<TutorDTO> getAllTutorsBySubject(String subject) {
		List<Tutor> tutorListBySubject = tutorDataService
				.getAllTutorsBySubject(subject);
		return TutorConverter.convertTutorList(tutorListBySubject);
	}

	@Override
	public List<TutorDTO> getAllTutorsByQualification(String qualification) {
		List<Tutor> tutorListByQualification = tutorDataService
				.getAllTutorsByQualification(qualification);
		return TutorConverter.convertTutorList(tutorListByQualification);
	}

	@Override
	public List<TutorDTO> getRecentlyAddedTutors() {
		List<Tutor> tutorListForShowcase = tutorDataService
				.getRecentlyAddedTutors();
		return TutorConverter.convertTutorList(tutorListForShowcase);
	}*/

}
