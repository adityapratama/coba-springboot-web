package com.aditya.pra.coba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aditya.pra.coba.auditor.AbstractAuditableEntity;

@Entity
@Table(name="menu")
public class Menu extends AbstractAuditableEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "label", nullable = false)
    private String label;
	@Column(nullable=false)
    private String action;
    @Column(name = "level", nullable = false)
    private Integer level = 0;
    @Column(name = "menu_order", nullable = false)
    private Integer order = 0;
    @Column(name = "options")
    private String options;
    @ManyToOne
    @JoinColumn(name="id_parent")
    private Menu parent;
	

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
}
