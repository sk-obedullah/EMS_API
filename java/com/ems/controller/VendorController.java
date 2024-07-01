package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.customexception.BusinessException;
import com.ems.customexception.ControllerException;
import com.ems.model.Employee;
import com.ems.model.Vendor;
import com.ems.service.VendorService;
import com.ems.serviceImpl.VendorServiceImpl;

@RestController
@RequestMapping("/vendor")
@CrossOrigin(origins = "*")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@PostMapping("/add")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vendor) {
		try {
			Vendor vendorDetails = this.vendorService.addVendor(vendor);
			return new ResponseEntity<Vendor>(vendorDetails, HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllVendors() {
		try {
			List<Vendor> vendorDetails = this.vendorService.getAllVendors();
			return new ResponseEntity<>(vendorDetails,HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

		}
	}
}
