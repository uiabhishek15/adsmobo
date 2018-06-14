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
@ManagedBean(name = "emailValidator")
@ViewScoped
public class EmailValidator implements Serializable {

	private static final long serialVersionUID = 6850383255266191514L;

	FacesMessagesDelegate messagesDelegate = new FacesMessagesDelegate();

	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private final static Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(EMAIL_PATTERN);
	
	private final static String NO_EMAIL = "noemail";
	
	private final static String INVALID_EMAIL = "invalidemail";
	
	private final static String VALID_EMAIL = "validemail";
	
	
	private String emailValidationMessage;
	
	public String getEmailValidationMessage() {
		return emailValidationMessage;
	}

	public void setEmailValidationMessage(String emailValidationMessage) {
		this.emailValidationMessage = emailValidationMessage;
	}

	public void validateEmail(UserDTO user) throws ValidatorException {		
		String email = user.getEmail();		
		if (email == null || "".equals(email)) {
			setEmailValidationMessage(NO_EMAIL);
		} else {
			// The email matcher			
			Matcher matcher = EMAIL_COMPILED_PATTERN.matcher(email);

			if (!matcher.matches()) { // Email doesn't match
				setEmailValidationMessage(INVALID_EMAIL);		
			} else {
				setEmailValidationMessage(VALID_EMAIL);
			}
		}		
	}
}
