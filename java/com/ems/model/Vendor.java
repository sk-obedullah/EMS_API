package com.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Vendor {
//	(name, email, upi)
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String vendorName;
	@Column(unique=true)
	private String vendorEmail;
//	@Column(unique=true)
	private String vendorUPI;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorUPI() {
		return vendorUPI;
	}
	public void setVendorUPI(String vendorUPI) {
		this.vendorUPI = vendorUPI;
	}
	public Vendor(String vendorName, String vendorEmail, String vendorUPI) {
		super();
		this.vendorName = vendorName;
		this.vendorEmail = vendorEmail;
		this.vendorUPI = vendorUPI;
	}
	@Override
	public String toString() {
		return "Vendor [vendorName=" + vendorName + ", vendorEmail=" + vendorEmail + ", vendorUPI=" + vendorUPI + "]";
	}
	
	public Vendor() {
		
	}
	
	

}
