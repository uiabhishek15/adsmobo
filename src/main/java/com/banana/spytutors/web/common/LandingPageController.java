package com.banana.spytutors.web.common;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.banana.spytutors.web.dto.LandingPageDTO;
import com.banana.spytutors.web.utils.SpyTutorsConstants;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name = "landingPageController")
@ViewScoped
@URLMappings(mappings = {
		@URLMapping(id = "home", viewId = "/index.xhtml", pattern = "/home"),
		@URLMapping(id = "howitworks", viewId = "/views/hiw.xhtml", pattern = "/howitworks"),
		@URLMapping(id = "plans", viewId = "/views/plans.xhtml", pattern = "/plans"),
		@URLMapping(id = "benefits", viewId = "/views/benefits.xhtml", pattern = "/benefits"),
		@URLMapping(id = "tutorsignup", viewId = "/views/user/tutorsignup.xhtml", pattern = "/tutorsignup"),
		@URLMapping(id = "tutorlogin", viewId = "/views/userlogin/tutorlogin.xhtml", pattern = "/tutorlogin"),
		@URLMapping(id = "aboutus", viewId = "/views/aboutus.xhtml", pattern = "/aboutus"),
		@URLMapping(id = "contactus", viewId = "/views/contactus.xhtml", pattern = "/contactus")})
public class LandingPageController implements Serializable {

	private static final long serialVersionUID = -1220905062909736014L;

	private static final String TUTOR_SIGNUP_OUTCOME = "goToTutorSignup";

	private static final String STUDENT_SIGNUP_OUTCOME = "goToStudentSignup";

	private static final String LANDING_PAGE_OUTCOME = "goToLandingPage";

	private static final String LOGIN_PAGE_OUTCOME = "goToLoginPage";

	private static final String HOME_PAGE_OUTCOME = "goToHomePage";
	
	private static final String INDEX_PAGE_OUTCOME = "goToIndex";

	private LandingPageDTO landingPage = new LandingPageDTO();

	public LandingPageDTO getLandingPage() {
		return landingPage;
	}

	public void setLandingPage(LandingPageDTO landingPage) {
		this.landingPage = landingPage;
	}

	public void updateNavigationPage(String navigationPage) {
		getLandingPage().setNavigationPage(navigationPage);
	}

	public void navigateToTutorLogin() {
		handlePageNavigation(SpyTutorsConstants.TUTOR_LOGIN_OUTCOME);
	}

	public void navigateToStudentLogin() {
		handlePageNavigation(SpyTutorsConstants.STUDENT_LOGIN_OUTCOME);
	}

	public String navigateToTutorSignup() {
		/* handlePageNavigation(TUTOR_SIGNUP_OUTCOME); */
		return "pretty:tutorsignup";
	}

	public String navigateToStudentSignup() {
		/*handlePageNavigation(STUDENT_SIGNUP_OUTCOME);*/
		return "pretty:studentsignup";
	}

	/*public String navigateToLandingPage() {
		 handlePageNavigation(LANDING_PAGE_OUTCOME); 
		return "pretty:selectedcountry";
	}*/

	public void navigateToLoginPage() {
		handlePageNavigation(LOGIN_PAGE_OUTCOME);
	}

	public void navigateToHomePage() {
		handlePageNavigation(HOME_PAGE_OUTCOME);
		/*return "pretty:selectedcountry";*/
	}
	
	public void navigateToIndexPage() {
		handlePageNavigation(INDEX_PAGE_OUTCOME);
		/*return "pretty:selectedcountry";*/
	}
	
	public void redirect() throws IOException {
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect("http://stackoverflow.com");
	}

	private void handlePageNavigation(String outcome) {
		NavigationHandler h = FacesContext.getCurrentInstance()
				.getApplication().getNavigationHandler();
		h.handleNavigation(FacesContext.getCurrentInstance(), null, outcome);
	}
}
