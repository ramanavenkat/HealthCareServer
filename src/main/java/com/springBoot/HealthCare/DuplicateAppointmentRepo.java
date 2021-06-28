package com.springBoot.HealthCare;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DuplicateAppointmentRepo extends JpaRepository<DuplicateAppointmentModel, Integer> {

	List<DuplicateAppointmentModel> findByDoctorId(int id);

	List<DuplicateAppointmentModel> findByPatientId(int id);

	
}
