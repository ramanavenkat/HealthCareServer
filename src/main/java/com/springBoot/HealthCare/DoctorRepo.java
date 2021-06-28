package com.springBoot.HealthCare;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<DoctorModel, Integer>{

	DoctorModel findByEmail(String email);

	List<DoctorModel> findBySpecialization(String str);

}
