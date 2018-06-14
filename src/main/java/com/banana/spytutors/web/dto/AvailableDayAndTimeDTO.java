package com.banana.spytutors.web.dto;

import java.io.Serializable;

/**
 * 
 * @author ANKEM
 *
 */
public class AvailableDayAndTimeDTO implements Serializable {

	private static final long serialVersionUID = -5716244337882487489L;		
	
	private String day;	
	
	private String hour;
	
	private String minute;
	
	private String meridian;

    private String savedAvailableDayAndTime;
    
    public AvailableDayAndTimeDTO(){}
    
    public AvailableDayAndTimeDTO(String savedAvailableDayAndTime){
    	this.savedAvailableDayAndTime = savedAvailableDayAndTime;
    }
    
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}	

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getMeridian() {
		return meridian;
	}

	public void setMeridian(String meridian) {
		this.meridian = meridian;
	}
	
	public String getAvailableDayAndTime(){
		return day+"  "+hour+":"+minute+" "+meridian;
	}

	public String getSavedAvailableDayAndTime() {
		return savedAvailableDayAndTime;
	}

	public void setSavedAvailableDayAndTime(String savedAvailableDayAndTime) {
		this.savedAvailableDayAndTime = savedAvailableDayAndTime;
	}
}
