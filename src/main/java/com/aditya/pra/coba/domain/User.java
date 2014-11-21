package com.aditya.pra.coba.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.aditya.pra.coba.auditor.AbstractAuditableEntity;


@Entity
@Table(name="user")
public class User extends AbstractAuditableEntity{
	
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;*/
	@Column(nullable=false,length=50)
	private String firstName;
	@Column(nullable=false,length=50)
	private String lastName;
	@Column(nullable=false,length=50)
	private String userName;
	@Column(nullable=false,length=50)
	private String password;
	@Column(nullable=false,length=150)
	private String email;
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}