package com.banana.spytutors.data.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author ANKEM
 *
 */
@Document(collection="subject")
@TypeAlias("subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = 4512832247592441569L;
	
	private ObjectId id;
	
	public Subject(){
		this.id = ObjectId.get();
	}
	
	private String name;
	
	private String level;
	
	private String specialization;
	
	private String country;			

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
