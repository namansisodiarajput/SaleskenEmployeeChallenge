package com.example.salesken.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"email_id"})})
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@Column(name = "first_name")	
	private String firstName;
	
	@Column(name = "last_name")	
	private String lastName;
	
	@Column(name = "email_id", nullable = false)	
	private String emailId;

	public Long getId() {
		return id;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
