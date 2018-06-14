package com.banana.spytutors.data.entity;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

public abstract class AuditTrail  implements Serializable {

	private static final long serialVersionUID = -2815164269361012635L;	
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private DateTime createdDate;
	
	@LastModifiedBy
	private String updatedBy;
	
	@LastModifiedDate
	private DateTime updatedDate;
	
	@Version
	private Long version;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}	

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
