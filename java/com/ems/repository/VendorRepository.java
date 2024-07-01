package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.Vendor;


@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	Vendor findByVendorEmail(String vendorEmail);

}
