package com.springBoot.HealthCare;

import java.util.Date;

import org.hibernate.type.DateType;

public class DuplicateModel {
	
	private int doctorId;
	private String date;
	public DuplicateModel(int doctorId, String date) {
		super();
		this.doctorId = doctorId;
		this.date = date;
	}
	public DuplicateModel() {
		super();
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DuplicateModel [doctorId=" + doctorId + ", date=" + date + "]";
	}
	

}
