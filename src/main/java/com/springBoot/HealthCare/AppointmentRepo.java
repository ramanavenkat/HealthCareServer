package com.springBoot.HealthCare;

import java.util.Date;
import java.util.List;

import org.hibernate.type.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentModel, Integer> {

//	List<AppointmentModel> findByDIdAndDate(int id, Date date);
	List<AppointmentModel> findByDoctorIdAndDate(int id,String date);

	List<AppointmentModel> findByDoctorId(int id);

	List<AppointmentModel> findByPatientId(int id);
	
}
