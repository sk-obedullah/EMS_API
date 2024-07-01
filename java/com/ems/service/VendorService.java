package com.ems.service;

import java.util.List;

import com.ems.model.Vendor;

public interface VendorService {
	
	public Vendor addVendor(Vendor vendor );
	public List<Vendor> getAllVendors();

}
