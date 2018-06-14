package com.banana.spytutors.web.common;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.banana.spytutors.data.entity.Tutor;
import com.banana.spytutors.data.entity.User;
import com.banana.spytutors.web.app.config.MongoDBContextOperations;
import com.banana.spytutors.web.converter.TutorConverter;
import com.banana.spytutors.web.dto.LoginDTO;
import com.banana.spytutors.web.dto.TutorDTO;
import com.banana.spytutors.web.dto.UserDTO;
import com.banana.spytutors.web.service.TutorService;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name = "loginController")
@SessionScoped
/*@URLMappings(mappings = {
		@URLMapping(id = "home", viewId = "/index.xhtml", pattern = "/home")})*/
public class LoginController implements Serializable {

	private static final long serialVersionUID = 8107286828686582987L;

	@Autowired
	private TutorService tutorService;

	protected final Log logger = LogFactory.getLog(getClass());
	
	private String userName;

	private LoginDTO userlogin = new LoginDTO();
	
	private UserDTO tutor = new UserDTO();

	private String virtualCheck;

	private UserDTO tutorSignup = new UserDTO();
	
	private static final String INDEX_PAGE_OUTCOME = "goToIndex";

	private boolean remember = false;

	private String type;

	private LandingPageController landingpagecontroller = new LandingPageController();
	
	private int currentLevel = 1;

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public UserDTO getTutorSignup() {
		return tutorSignup;
	}

	public void setTutorSignup(UserDTO tutorSignup) {
		this.tutorSignup = tutorSignup;
	}

	public LoginDTO getUserlogin() {
		return userlogin;
	}

	public void setUserlogin(LoginDTO userlogin) {
		this.userlogin = userlogin;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String getVirtualCheck() {
		return virtualCheck;
	}

	public void setVirtualCheck(String virtualCheck) {
		this.virtualCheck = virtualCheck;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginController() {
		isChecked();
	}

	public void isChecked() {
		FacesContext fc = FacesContext.getCurrentInstance();
		// Cookie[] cookiesArr =
		// ((HttpServletRequest)(fc.getExternalContext().getRequest())).getCookies();
		// Cookie[] cookie = fc.getExternalContext().getRequest()
		Cookie[] cookiesArr = Util.getRequest().getCookies();
		if (cookiesArr != null && cookiesArr.length > 0)
			for (int i = 0; i < cookiesArr.length; i++) {
				String cName = cookiesArr[i].getName();
				String cValue = cookiesArr[i].getValue();
				// System.out.println("***cValue***" + cValue);
				if (cName.equals("cUserId")) {
					userlogin.setEmail(cValue);
				} else if (cName.equals("cPassword")) {
					userlogin.setPassword(cValue);
				} else if (cName.equals("cVirtualCheck")) {
					setVirtualCheck(cValue);
					if (getVirtualCheck().equals("false")) {
						setRemember(false);
						userlogin.setEmail(null);
						userlogin.setPassword(null);
					} else if (getVirtualCheck().equals("true")) {
						// System.out.println("Here in validateTutorLogin() line 99");
						setRemember(true);
					}
				}
			}

	}

	/*
	 * public String validateTutorLogin() { MongoOperations mongoOperations =
	 * MongoDBContextOperations .getMongoOperations(); List<Tutor> allTutorList
	 * = mongoOperations.findAll(Tutor.class); for (Tutor tutor : allTutorList)
	 * { if (userlogin.getUsername().equals(tutor.getUser().getUserName()) ||
	 * userlogin.getUsername().equals( tutor.getUser().getEmail())) { if
	 * (BCrypt.checkpw(userlogin.getPassword(), tutor.getUser() .getPassword()))
	 * { FacesContext fc = FacesContext.getCurrentInstance(); if (remember ==
	 * true) { virtualCheck = "true"; Cookie cUserId = new Cookie("cUserId",
	 * userlogin.getUsername()); Cookie cPassword = new Cookie("cPassword",
	 * userlogin.getPassword()); Cookie cVirtualCheck = new
	 * Cookie("cVirtualCheck", virtualCheck); cUserId.setMaxAge(3600);
	 * cPassword.setMaxAge(3600); cVirtualCheck.setMaxAge(3600);
	 * ((HttpServletResponse) (fc.getExternalContext()
	 * .getResponse())).addCookie(cUserId); ((HttpServletResponse)
	 * (fc.getExternalContext() .getResponse())).addCookie(cPassword);
	 * ((HttpServletResponse) (fc.getExternalContext()
	 * .getResponse())).addCookie(cVirtualCheck); } else { virtualCheck =
	 * "false"; Cookie cVirtualCheck = new Cookie("cVirtualCheck",
	 * virtualCheck); ((HttpServletResponse) (fc.getExternalContext()
	 * .getResponse())).addCookie(cVirtualCheck); }
	 * 
	 * } } } return "pretty:tutorsignup"; }
	 */

	public void validateTutorLogin(LoginDTO userlogin) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		List<User> allTutorList = mongoOperations.findAll(User.class);
		boolean isValidateTutor = false;
		for (User tutor : allTutorList) {
			if (userlogin.getEmail().equals(tutor.getEmail())) {
				if (BCrypt.checkpw(userlogin.getPassword(), tutor.getPassword())) {
					isValidateTutor = true;
					setUserName(tutor.getFullName());
					/*DataTable db = new DataTable();
					db.setInView(true);*/
					break;
				}
			}
		}
		if (isValidateTutor) {
			HttpSession hs = Util.getSession();
			hs.setAttribute(userlogin.getEmail(), userlogin.getEmail());
			if (remember) {
				Cookie ckUserName = new Cookie("email",
						userlogin.getEmail());
				ckUserName.setMaxAge(3600);
				Util.getResponse().addCookie(ckUserName);
				Cookie ckPassword = new Cookie("password",
						userlogin.getPassword());
				ckPassword.setMaxAge(3600);
				Util.getResponse().addCookie(ckPassword);
				landingpagecontroller.navigateToHomePage();
			} else {
				landingpagecontroller.navigateToHomePage();
			}
		}

	}

	public void logout() {
		HttpServletResponse resp = Util.getResponse();
		HttpServletRequest req = Util.getRequest();
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0);
				resp.addCookie(cookies[i]);
			}
		//landingpagecontroller.navigateToIndexPage();
		handlePageNavigation(INDEX_PAGE_OUTCOME);
	}
	
	private void handlePageNavigation(String outcome) {
		NavigationHandler h = FacesContext.getCurrentInstance()
				.getApplication().getNavigationHandler();
		h.handleNavigation(FacesContext.getCurrentInstance(), null, outcome);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void updateButtonType(String type) {
		setType(type);
	}

	/*
	 * public void updateTutorCommandLink(TutorDTO selectedTutor, String type) {
	 * userlogin.setUsername(selectedTutor.getTutor().getUserName());
	 * tutorSearch.setSelectedTutor(selectedTutor); updateTutorType(type); }
	 */

	public void updateTutorSearch(LoginDTO userlogin, String type) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		Query query = Query.query(Criteria.where("email").is(
				userlogin.getEmail()));
		User fetchedTutor = mongoOperations.findOne(query, User.class);
		userlogin.setFetchedTutor(TutorConverter.convertTutorfor(fetchedTutor));
		updateButtonType("dashboard");
	}

	/*
	 * private LoginDTO checkCookie() { String username = ""; String password =
	 * ""; Cookie[] cookies = Util.getRequest().getCookies(); if (null !=
	 * cookies) { for (Cookie ck : cookies) { if (ck.getName().equals(username))
	 * { username = ck.getValue(); } if (ck.getName().equals(password)) {
	 * password = ck.getValue(); } } } if (!username.isEmpty() &&
	 * !password.isEmpty()) userlogin = new LoginDTO(username, password); return
	 * userlogin;
	 * 
	 * }
	 */

	public void updateTutorAccount(LoginDTO userlogin) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();		
		User tutor = TutorConverter.transferFetchedTutor(userlogin);				
		mongoOperations.save(tutor);
	}

	public void changePassword(LoginDTO userlogin) {
		MongoOperations mongoOperations = MongoDBContextOperations
				.getMongoOperations();
		Query query = Query.query(Criteria.where("email").is(
				userlogin.getEmail()));
		User tutor = mongoOperations.findOne(query, User.class);
		/*userlogin.setOldpassword("1234");
		userlogin.setNewpassword("abhi");
		userlogin.setConfirmpassword("abhi");*/
		if (BCrypt.checkpw(userlogin.getOldpassword(), tutor.getPassword())) {
			if (userlogin.getNewpassword().equals(
					userlogin.getConfirmpassword())) {
				tutor.setPassword(
						BCrypt.hashpw(userlogin.getNewpassword(),
								BCrypt.gensalt(12)));
				mongoOperations.save(tutor);
				updateTutorSearch(userlogin, "dashboard");
			}
		}
	}

	public UserDTO getTutor() {
		return tutor;
	}

	public void setTutor(UserDTO tutor) {
		this.tutor = tutor;
	}

}
