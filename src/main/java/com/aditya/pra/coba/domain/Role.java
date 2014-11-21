package com.aditya.pra.coba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import com.aditya.pra.coba.auditor.AbstractAuditableEntity;


@Entity
@Table(name="role")
public class Role extends AbstractAuditableEntity{

	private static final long serialVersionUID = 1L;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="description", nullable=false)
	private String description;
	@ManyToMany
	@JoinTable(
		name="role_permission",
		joinColumns=@JoinColumn(name="id_role", nullable=false),
		inverseJoinColumns=@JoinColumn(name="id_permission", nullable=false)
	)
	private Set<Permission> permissions;
	@ManyToMany
	@JoinTable(
		name="role_menu",
		joinColumns=@JoinColumn(name="id_role", nullable=false),
		inverseJoinColumns=@JoinColumn(name="id_menu", nullable=false)
	)
	private Set<Menu> menus;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}