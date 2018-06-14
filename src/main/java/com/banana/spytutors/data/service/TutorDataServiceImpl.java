package com.banana.spytutors.data.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.banana.spytutors.data.entity.Subject;
import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.entity.User;
import com.banana.spytutors.web.app.config.MongoDBContextOperations;
import com.banana.spytutors.web.dto.TutorSearchDTO;

/**
 * 
 * @author ANKEM
 *
 */
public class TutorDataServiceImpl implements TutorDataService {

	TutorSearchDTO tutorSearch = new TutorSearchDTO();

	@Override
	public void saveTutor(User tutor) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		mongoOperations.save(tutor);
	}

	@Override
	public List<Tutor> getAllTutorsByCountry(BigInteger countryId) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<Tutor> getAllTutorsByCity(String city) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		List<Tutor> allTutorList = mongoOperations.findAll(Tutor.class);
		List<Tutor> tutorListForCity = new ArrayList<Tutor>(0);
		for (Tutor tutor : allTutorList) {
			String cityFromDB = tutor.getAddress().getCity().getName();
			if (StringUtils.equalsIgnoreCase(city, cityFromDB)) {
				tutorListForCity.add(tutor);
			}
		}
		return tutorListForCity;
	}
*/
	@Override
	public List<Tutor> getAllTutorsBySubject(String subject) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		List<Tutor> allTutorList = mongoOperations.findAll(Tutor.class);
		List<Tutor> tutorListForSubject = new ArrayList<Tutor>(0);
		for (Tutor tutor : allTutorList) {
			List<Subject> subjectListFromDB = tutor.getSubjectList();
			for (Subject subjectName : subjectListFromDB) {
				String subjectFromDB = subjectName.getName();
				if (StringUtils.equalsIgnoreCase(subject, subjectFromDB)) {
					tutorListForSubject.add(tutor);
				}
			}
		}
		return tutorListForSubject;
	}

	@Override
	public List<Tutor> getAllTutorsByQualification(String qualification) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		List<Tutor> allTutorList = mongoOperations.findAll(Tutor.class);
		List<Tutor> tutorListForQualification = new ArrayList<Tutor>(0);
		for (Tutor tutor : allTutorList) {
			String qualificationFromDB = tutor.getQualification();
			if (StringUtils
					.equalsIgnoreCase(qualification, qualificationFromDB)) {
				tutorListForQualification.add(tutor);

			}

		}
		return tutorListForQualification;
	}

	@Override
	public List<Tutor> getRecentlyAddedTutors() {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		Query query = new Query();
		query.limit(15);
		query.with(new Sort(Sort.Direction.DESC, "createdDate"));
		List<Tutor> allTutorList = mongoOperations.find(query, Tutor.class);
		List<Tutor> tutorsShowcase = new ArrayList<Tutor>(0);
		for (Tutor tutor : allTutorList) {
			tutorsShowcase.add(tutor);
		}
		return tutorsShowcase;
	}

}
