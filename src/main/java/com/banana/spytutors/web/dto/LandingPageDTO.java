package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class LandingPageDTO implements Serializable {

	private static final long serialVersionUID = 1267479799147720957L;
	
    private String navigationPage;

	public String getNavigationPage() {
		return navigationPage;
	}

	public void setNavigationPage(String navigationPage) {
		this.navigationPage = navigationPage;
	}    
}
