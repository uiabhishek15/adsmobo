package com.banana.spytutors.data.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class EsTutor {
	@Id
	private ObjectId id;
	
	private User user;
	
	private String priceRangePerHour;
	
	private List<Subject> subjectList;
	
	private String experience;
	
	private String qualification;
	
	private List<String> availableDayAndTimeList;
	
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
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
