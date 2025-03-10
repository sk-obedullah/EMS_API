package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.Email;

@Repository
public interface EmailRespository extends JpaRepository<Email, Integer>{

}
