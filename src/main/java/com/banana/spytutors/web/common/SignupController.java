package com.banana.spytutors.web.common;

import java.io.Serializable;

import javax.annotation.PostConstruct;

/**
 * 
 * @author ANKEM
 *
 */

public abstract class SignupController implements Serializable {

	private static final long serialVersionUID = -7303637233616051982L;	
		
	//public abstract void updateSubRegionList(String geonameId,String type);	
	
	@PostConstruct
	public abstract void init();
}
