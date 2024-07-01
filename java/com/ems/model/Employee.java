package com.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	//(name, designation, CTC, and email)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	private String name;
	@Column(unique=true)
	private String email;
	private String designation;
	private double ctc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getCtc() {
		return ctc;
	}
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", designation=" + designation + ", ctc=" + ctc + "]";
	}
	
	public Employee() {
		
	}
	
	
}
