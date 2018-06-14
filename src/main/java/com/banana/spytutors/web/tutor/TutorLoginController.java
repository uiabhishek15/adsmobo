package com.banana.spytutors.web.tutor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.banana.spytutors.web.common.LoginController;
import com.banana.spytutors.web.dto.LoginDTO;

/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name="tutorLoginController")
@RequestScoped
public class TutorLoginController extends LoginController {

	private static final long serialVersionUID = 5621531875531475098L;
	
	private LoginDTO tutorLogin = new LoginDTO();	

	public LoginDTO getTutorLogin() {
		return tutorLogin;
	}

	public void setTutorLogin(LoginDTO tutorLogin) {
		this.tutorLogin = tutorLogin;
	}
}
