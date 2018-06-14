package com.banana.spytutors.web.tutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banana.spytutors.web.common.FacesMessagesDelegate;
import com.banana.spytutors.web.common.LandingPageController;
import com.banana.spytutors.web.common.MessageKeyConstants;
import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.UserDTO;
import com.banana.spytutors.web.service.TutorService;

@ManagedBean(name = "tutorSignupController")
@ViewScoped
@Component
public class TutorSignupController implements Serializable{

	private static final long serialVersionUID = 7429427158438489822L;

	private static final String USER_NAME = "name";

	private static final String EMAIL = "email";

	private static final String MOBILE = "mobile";

	private static final String PASSWORD = "password";

	private static final String COMPANY = "company";

	private static final String WEBSITE = "website";

	private static final String STATE = "state";

	private static final String CITY = "city";

	private static final Logger LOGGER = Logger.getLogger(TutorSignupController.class);

	private UserDTO tutorSignup = new UserDTO();
	
	private LandingPageController lc = new LandingPageController();

	@Autowired
	private FacesMessagesDelegate messagesDelegate;

	@Autowired
	private TutorService tutorService;
	
	private Boolean valid;

	public UserDTO getTutorSignup() {
		return tutorSignup;
	}

	public void setTutorSignup(UserDTO tutorSignup) {
		this.tutorSignup = tutorSignup;
	}

	/*
	 * @Override
	 * 
	 * @PostConstruct public void init() {
	 * LOGGER.info("Loading tutorsignup information"); loadRefData();
	 * updateAvailableDayAndTime(tutorSignup); }
	 */

	public void createTutorAccount(UserDTO tutorsignup) {
			// tutorsignup.getTutor().setImageMetadataPath(fileUploadBean.getFileMetadataPath());
			tutorService.saveTutor(tutorsignup);
			lc.navigateToIndexPage();
	}

	private void validateCreateTutorAccount(UserDTO tutorsignup) {
		validateTutorSignupMandatoryFields(tutorsignup);
		//return false;
	}

	private void validateTutorSignupMandatoryFields(UserDTO tutorsignup) {
		validateTutorSignup(tutorsignup, USER_NAME, "name");
		validateTutorSignup(tutorsignup, EMAIL, "email");
		validateTutorSignup(tutorsignup, PASSWORD, "password");
		validateTutorSignup(tutorsignup, MOBILE, "mobile");
		validateTutorSignup(tutorsignup, COMPANY, "company");
		validateTutorSignup(tutorsignup, WEBSITE, "website");
		validateTutorSignup(tutorsignup, STATE, "state");
		validateTutorSignup(tutorsignup, CITY, "city");
	}

	public void validateTutorSignup(UserDTO tutorsignup, String type,
			String clientId) {

		switch (type) {
		case USER_NAME:
			String userName = tutorsignup.getFullname();
			if (StringUtils.isBlank(userName)) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_ENTER_NAME, clientId);
			}
			break;
		case EMAIL:
			if (StringUtils.isEmpty(tutorsignup.getEmail())) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_ENTER_EMAIL, clientId);
			}
			break;
		case PASSWORD:
			if (StringUtils.isEmpty(tutorsignup.getPassword())) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_ENTER_PASSWORD, clientId);
			}
			break;
		case MOBILE:
			String mobile = tutorsignup.getMobile();
			if (StringUtils.equalsIgnoreCase(mobile, "(___) ___-____")
					|| StringUtils.isBlank(mobile)) {
				messagesDelegate
						.addInfoFacesMessageByKey(
								MessageKeyConstants.PLEASE_ENTER_PHONE_NUMBER,
								clientId);
			}
			break;
		case COMPANY:
			String company = tutorsignup.getCompany();
			if (StringUtils.isBlank(company)) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_SELECT_COMPANY, clientId);
			}
			break;
		case WEBSITE:
			String website = tutorsignup.getWebsite();
			if (StringUtils.isBlank(website)) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_ENTER_WEBSITE, clientId);
			}
			break;
		case STATE:
			String state = tutorsignup.getState();
			if (StringUtils.isBlank(state)) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_SELECT_STATE, clientId);
			}
			break;
		case CITY:
			String city = tutorsignup.getCity();
			if (StringUtils.isBlank(city)) {
				messagesDelegate.addInfoFacesMessageByKey(
						MessageKeyConstants.PLEASE_SELECT_CITY, clientId);
			}
			break;

		default:
			break;
		}
	}

	public void resetCreateTutorAccount() {
		setTutorSignup(new UserDTO());
	}

	public StreamedContent getTutorImage(String imageMetadataPath)
			throws IOException {
		if (StringUtils.isNotBlank(imageMetadataPath)) {
			String fileName = imageMetadataPath.replace("C:\\images\\", "");
			if (StringUtils.isNotBlank(fileName)) {
				fileName = fileName.trim();
			}
			MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
			String mimeType = mimeTypesMap.getContentType(fileName);
			return new DefaultStreamedContent(new FileInputStream("C:/images/"
					+ fileName), mimeType);
		} else {
			return null;
		}
	}

}
