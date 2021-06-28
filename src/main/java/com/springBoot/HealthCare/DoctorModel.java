package com.springBoot.HealthCare;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String doctorName;
	private String email;
	private String mobileNumber;
	private String specialization;
	private String qualification;
	private int experience;
	private String password="Doctor@123";
	private boolean active=true;
	private String roles="ROLE_DOCTOR";
	
	public DoctorModel(int id, String doctorName, String email, String mobileNumber, String specialization,
			String qualification, int experience,String password, boolean active, String roles) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.specialization = specialization;
		this.qualification = qualification;
		this.experience = experience;
		this.password=password;
		this.active = active;
		this.roles = roles;
	}
	public DoctorModel() {
		super();
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
