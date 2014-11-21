package com.aditya.pra.coba.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aditya.pra.coba.auditor.AbstractAuditableEntity;

@Entity
@Table(name="product")
public class Product extends AbstractAuditableEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private String code;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false,precision=10)
	private BigDecimal price;
	@Column(nullable=false)
	private boolean inStock = true;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}