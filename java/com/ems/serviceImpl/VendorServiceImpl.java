package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.customexception.BusinessException;
import com.ems.model.Employee;
import com.ems.model.Vendor;
import com.ems.repository.VendorRepository;
import com.ems.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor addVendor(Vendor vendor) {

		if (vendor.getVendorName() == "") {
			throw new BusinessException("Please Enter Name");
		} else if (vendor.getVendorEmail() == "") {
			throw new BusinessException("Please Enter Email");
		} else if (vendor.getVendorUPI() == "") {
			throw new BusinessException("Please Enter UPI");
		} else {
			Vendor isEmail = this.vendorRepository.findByVendorEmail(vendor.getVendorEmail());
			if (isEmail != null) {
				throw new BusinessException("Email already exist");
			}
		}
		return this.vendorRepository.save(vendor);

	}

	@Override
	public List<Vendor> getAllVendors() {
		try {
			List<Vendor> allVendors = this.vendorRepository.findAll();
			return allVendors;
		}catch(Exception e ) {
			throw new BusinessException(e.getMessage());
		}
		
	}

}
