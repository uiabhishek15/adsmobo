package com.banana.spytutors.web.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name = "captchaBean")
@ViewScoped
@Component
public class CaptchaBean implements Serializable {

	private static final long serialVersionUID = -5562078509370022791L;
	
	private String captchaFromGenerated;
	
	private String captchaFromInput;

	public String getCaptchaFromGenerated() {
		return captchaFromGenerated;
	}

	public void setCaptchaFromGenerated(String captchaFromGenerated) {
		this.captchaFromGenerated = captchaFromGenerated;
	}

	public String getCaptchaFromInput() {
		return captchaFromInput;
	}

	public void setCaptchaFromInput(String captchaFromInput) {
		this.captchaFromInput = captchaFromInput;
	}
	
	public boolean validateCaptcha(){
		if(StringUtils.equals(captchaFromGenerated, captchaFromInput)){
			return true;
		} else {
			setCaptchaFromGenerated(generateCaptchaString(6));
			setCaptchaFromInput(StringUtils.EMPTY);
		}
		return false;
	}
	
	public static String generateCaptchaString(int captchaLength) {
		 
		String saltChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer captchaStrBuffer = new StringBuffer();
		java.util.Random rnd = new java.util.Random();
 
		// build a random captchaLength chars salt
		while (captchaStrBuffer.length() < captchaLength) {
			int index = (int) (rnd.nextFloat() * saltChars.length());
			captchaStrBuffer.append(saltChars.substring(index, index + 1));
		}
 
		return captchaStrBuffer.toString();
 
	}
	
	public void populateCaptchaString(){
		String newCaptchaString = generateCaptchaString(6);
		setCaptchaFromGenerated(newCaptchaString);
		setCaptchaFromInput(StringUtils.EMPTY);
	}
}
