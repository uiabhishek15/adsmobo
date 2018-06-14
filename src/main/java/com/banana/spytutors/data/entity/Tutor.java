package com.banana.spytutors.data.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author ANKEM
 *
 */
@Document(collection="tutors")
@TypeAlias("tutor")
public class Tutor extends AuditTrail {
	
	private static final long serialVersionUID = -7823225398591728685L;
	
	@Id
	private ObjectId id;
	
	public Tutor(){
		this.id = ObjectId.get();
	}
	
	@Field("user")
	private User user;
	
	@Field("priceRangePerHour")
	private String priceRangePerHour;
	
	@Field("subjectList")
	private List<Subject> subjectList;
	
	@Field("experience")
	private String experience;
	
	@Field("qualification")
	private String qualification;
	
	@Field("availableDayAndTimeList")
	private List<String> availableDayAndTimeList;
	
	@Field("address")
	private Address address = new Address();	

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPriceRangePerHour() {
		return priceRangePerHour;
	}

	public void setPriceRangePerHour(String priceRangePerHour) {
		this.priceRangePerHour = priceRangePerHour;
	}		

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}	

	public List<String> getAvailableDayAndTimeList() {
		return availableDayAndTimeList;
	}

	public void setAvailableDayAndTimeList(List<String> availableDayAndTimeList) {
		this.availableDayAndTimeList = availableDayAndTimeList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	} 
}
