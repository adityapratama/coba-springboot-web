package com.aditya.pra.coba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.aditya.pra.coba.auditor.AbstractAuditableEntity;

@Entity
@Table(name="permission")
public class Permission extends AbstractAuditableEntity {
	
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private String label;
	@Column(nullable=false)
	private String value;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}