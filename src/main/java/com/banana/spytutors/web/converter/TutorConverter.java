package com.banana.spytutors.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.banana.spytutors.data.entity.Address;
import com.banana.spytutors.data.entity.PostalCode;
import com.banana.spytutors.data.entity.Campaign;
import com.banana.spytutors.data.entity.Subject;
import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.entity.User;
import com.banana.spytutors.web.app.config.MongoDBContextOperations;
import com.banana.spytutors.web.common.BCrypt;
import com.banana.spytutors.web.dto.AddressDTO;
import com.banana.spytutors.web.dto.AvailableDayAndTimeDTO;
import com.banana.spytutors.web.dto.ExperienceDTO;
import com.banana.spytutors.web.dto.GenderDTO;
import com.banana.spytutors.web.dto.LoginDTO;
import com.banana.spytutors.web.dto.PostalCodeDTO;
import com.banana.spytutors.web.dto.PriceRangePerHourDTO;
import com.banana.spytutors.web.dto.QualificationDTO;
import com.banana.spytutors.web.dto.SubRegionDTO;
import com.banana.spytutors.web.dto.CampaignDTO;
import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.UserDTO;

/**
 * 
 * @author ANKEM
 *
 */
public class TutorConverter {	
	
	public static User transferTutorDTO(UserDTO userDTO){
		User tutor = new User();		
		copyTutorDTOProperties(userDTO, tutor);		
		return tutor;
	}
	
	public static User transferFetchedTutor(LoginDTO userlogin){
		User tutor = new User();	
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		//Query query = Query.query(Criteria.where("user.userName").is(userlogin.getUsername()));
		Query query = Query.query(Criteria.where("email").is(userlogin.getEmail()));
		tutor = mongoOperations.findOne(query, User.class);
		copyFetchedTutorDTOProperties(tutor,userlogin);		
		return tutor;
	}
	
	private static void copyFetchedTutorDTOProperties(User user,LoginDTO userlogin) {	
		UserDTO userDTO = userlogin.getFetchedTutor();	
	
		//UserDTO userDTO = userDTO.get;
		//User user = new User();	
		
		user.setFullName(userDTO.getFullname());
		user.setEmail(userDTO.getEmail());
		//if(userDTO.getPassword().equals(user.getPassword())){
			user.setPassword(userDTO.getPassword());
		/*}else{
			user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12)));
		}*/
		user.setMobile(userDTO.getMobile());
		user.setCompany(userDTO.getState());
		user.setWebsite(userDTO.getWebsite());
		user.setState(userDTO.getState());
		user.setCity(userDTO.getCity());
		//user.setCampaignList(campaignList);
		//tutor.setUser(user);
		
		
		/*for (CampaignDTO campaignDTO : userDTO.getCampaignList()) {
			Campaign campaign = new Campaign();
			BeanUtils.copyProperties(campaignDTO, campaign);
			//campaign.setCampaignName("");
			campaignList.add(campaign);
		}*/
		List<Campaign> campaignList = new ArrayList<Campaign>(0);
		Campaign campaign = new Campaign();
		campaign.setCampaignName(userDTO.getCampaignDTO().getCampaignname());
		campaign.setCampaignBudget(userDTO.getCampaignDTO().getCampaignbudget());
		campaign.setCostperClick("0.50");
		campaign.setAdTitle(userDTO.getCampaignDTO().getAdtitle());
		campaign.setAdDescription(userDTO.getCampaignDTO().getAddescription());
		campaign.setAdLandingUrl(userDTO.getCampaignDTO().getAdlandingurl());
		campaignList.add(campaign);
		user.setCampaignList(campaignList);
		
		//Audit Trail population
		user.setCreatedBy(userDTO.getFullname());
		//tutor.setUpdatedBy(userDTO.getFullname());
		user.setCreatedDate(DateTime.now());
		//tutor.setUpdatedDate(DateTime.now());
		
	}

	public static List<User> transferTutorDTOList(List<UserDTO> tutorDTOList){
		List<User> tutorList = new ArrayList<User>(0);
		for (UserDTO tutorDTO : tutorDTOList) {
			tutorList.add(transferTutorDTO(tutorDTO));
		}
		return tutorList;
	}
	
	public static UserDTO convertTutor(User tutor,int tutorId){
		UserDTO tutorDTO = new UserDTO();
		tutorDTO.setId(tutorId);
		copyTutorProperties(tutor, tutorDTO);
		return tutorDTO;
	}
	
	public static UserDTO convertTutorfor(User tutor){
		UserDTO tutorDTO = new UserDTO();
		copyTutorProperties(tutor, tutorDTO);
		return tutorDTO;
	}
	
	public static List<UserDTO> convertTutorList(List<User> tutorList){
		List<UserDTO> tutorDTOList = new ArrayList<UserDTO>(0);
		int tutorId = 1;
		for (User tutor : tutorList) {
			tutorDTOList.add(convertTutor(tutor,tutorId));
			tutorId++;
		}
		return tutorDTOList;
	}
	
	/**
	 * Copy TutorDTO properties to Tutor entity to save in to database
	 * @param tutorDTO
	 * @param tutor
	 */
	private static void copyTutorDTOProperties(UserDTO userDTO,User user){

		user.setFullName(userDTO.getFullname());
		user.setEmail(userDTO.getEmail());
		user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12)));
		user.setMobile(userDTO.getMobile());
		user.setCompany(userDTO.getState());
		user.setWebsite(userDTO.getWebsite());
		user.setState(userDTO.getState());
		user.setCity(userDTO.getCity());	
		/*List<Subject> subjectList = new ArrayList<Subject>(0);
		for (CampaignDTO subjectDTO : tutorDTO.getSelectedSubjectList()) {
			Subject subject = new Subject();
			BeanUtils.copyProperties(subjectDTO, subject);
			subjectList.add(subject);
		}
		tutor.setSubjectList(subjectList);	*/	
		//Audit Trail population
		user.setCreatedBy(userDTO.getFullname());
		//tutor.setUpdatedBy(userDTO.getUserName());
		user.setCreatedDate(DateTime.now());
		//tutor.setUpdatedDate(DateTime.now());
	}
	
	/**
	 * Copy Tutor entity properties to TutorDTO to show in view
	 * @param tutor
	 * @param tutorDTO
	 */
	private static void copyTutorProperties(User user,UserDTO userDTO){		
	
		userDTO.setFullname(user.getFullName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setMobile(user.getMobile());
		userDTO.setCompany(user.getCompany());
		userDTO.setWebsite(user.getWebsite());
		userDTO.setState(user.getState());
		userDTO.setCity(user.getCity());
		//userDTO.setImageMetadataPath(tutor.getUser().getImageMetadataPath());

		/*List<CampaignDTO> subjectDTOList = new ArrayList<CampaignDTO>(0);
		for (Subject subject : tutor.getSubjectList()) {
			CampaignDTO subjectDTO = new CampaignDTO();
			BeanUtils.copyProperties(subject, subjectDTO);
			subjectDTOList.add(subjectDTO);
		}
		tutorDTO.setSubjectList(subjectDTOList);*/			
	}
}
