package com.banana.spytutors.web.common;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.validator.ValidatorException;

import com.banana.spytutors.web.dto.UserDTO;

/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name = "phoneNumberValidator")
@ViewScoped
public class PhoneNumberValidator implements Serializable {

	private static final long serialVersionUID = 6791670733840659720L;

	private static final String PHONE_PATTERN = "\\d{10}";

	private static final String PHONE_PATTERN1 = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";

	private static final String PHONE_PATTERN2 = "\\(\\d{3}\\)-\\d{3}-\\d{4}";

	private final static Pattern PHONE_COMPILED_PATTERN = Pattern.compile(PHONE_PATTERN);

	private final static Pattern PHONE_COMPILED_PATTERN1 = Pattern.compile(PHONE_PATTERN1);

	private final static Pattern PHONE_COMPILED_PATTERN2 = Pattern.compile(PHONE_PATTERN2);

	private final static String NO_PHONE_NUMBER = "nophonenumber";

	private final static String INVALID_PHONE_NUMBER = "invalidphonenumber";

	private final static String VALID_PHONE_NUMBER = "validphonenumber";

	private String phoneNumberValidationMessage;

	public String getPhoneNumberValidationMessage() {
		return phoneNumberValidationMessage;
	}

	public void setPhoneNumberValidationMessage(
			String phoneNumberValidationMessage) {
		this.phoneNumberValidationMessage = phoneNumberValidationMessage;
	}

	public void validatePhoneNumber(UserDTO user) throws ValidatorException {

		String phoneNumber = user.getMobile();
		if(null == phoneNumber || "".equals(phoneNumber)){
			setPhoneNumberValidationMessage(NO_PHONE_NUMBER);
		} 
		Matcher phoneMatcher = PHONE_COMPILED_PATTERN.matcher(phoneNumber);
		Matcher phoneMatcher1 = PHONE_COMPILED_PATTERN1.matcher(phoneNumber);
		Matcher phoneMatcher2 = PHONE_COMPILED_PATTERN2.matcher(phoneNumber);
		if(!phoneMatcher.matches() && !phoneMatcher1.matches() && !phoneMatcher2.matches()){
			setPhoneNumberValidationMessage(VALID_PHONE_NUMBER);
		} else {
			setPhoneNumberValidationMessage(INVALID_PHONE_NUMBER);
		}		
	}
}
