package com.springBoot.HealthCare;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientModel, Integer>{

	PatientModel findByEmail(String username);
	

}
