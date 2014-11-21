package com.aditya.pra.coba.auditor;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity extends AbstractPersistable<Long> implements Auditable<String, Long>{

	private static final long serialVersionUID = 1L;
	@LastModifiedDate
	@NotNull
	private Date lastModifiedDate;
	@LastModifiedBy
	@NotNull
    private String lastModifiedBy;
	@CreatedDate
	@NotNull
    private Date createdDate;
	@CreatedBy
	@NotNull
    private String createdBy;
    
	public String getCreatedBy() {

		return createdBy;
	}

	public void setCreatedBy(final String createdBy) {

		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {

		return null == createdDate ? null : new DateTime(createdDate);
	}

	public void setCreatedDate(final DateTime createdDate) {

		this.createdDate = null == createdDate ? null : createdDate.toDate();
	}

	public String getLastModifiedBy() {

		return lastModifiedBy;
	}

	public void setLastModifiedBy(final String lastModifiedBy) {

		this.lastModifiedBy = lastModifiedBy;
	}

	public DateTime getLastModifiedDate() {

		return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
	}

	public void setLastModifiedDate(final DateTime lastModifiedDate) {

		this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
	}
	
	@JsonIgnore
	public boolean isNew() {

		return null == getId();
	}
	
}
