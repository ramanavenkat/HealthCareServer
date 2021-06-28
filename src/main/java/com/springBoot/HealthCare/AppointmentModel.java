package com.springBoot.HealthCare;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.type.DateType;

@Entity
public class AppointmentModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int doctorId;
	private int patientId;
	private String patientName;
	private String date;
	private String doctorName;
	private boolean slot1;
	private boolean slot2;
	private boolean slot3;
	private boolean slot4;
	private String status=null;
	public AppointmentModel(DuplicateAppointmentModel model) {
		this.doctorId = model.getDoctorId();
		this.patientId = model.getPatientId();
		this.patientName = model.getPatientName();
		this.date = model.getDate();
		this.doctorName=model.getDoctorName();
		this.slot1 = model.isSlot1();
		this.slot2 = model.isSlot2();
		this.slot3 = model.isSlot3();
		this.slot4 = model.isSlot4();
		this.status = model.getStatus();
	}
	public AppointmentModel(int id, int doctorId, int patientId, String patientName, String date,String doctorName, boolean slot1,
			boolean slot2, boolean slot3, boolean slot4, String status) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.date = date;
		this.doctorName=doctorName;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.slot4 = slot4;
		this.status = status;
	}
	
	public AppointmentModel() {
		super();
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isSlot1() {
		return slot1;
	}
	public void setSlot1(boolean slot1) {
		this.slot1 = slot1;
	}
	public boolean isSlot2() {
		return slot2;
	}
	public void setSlot2(boolean slot2) {
		this.slot2 = slot2;
	}
	public boolean isSlot3() {
		return slot3;
	}
	public void setSlot3(boolean slot3) {
		this.slot3 = slot3;
	}
	public boolean isSlot4() {
		return slot4;
	}
	public void setSlot4(boolean slot4) {
		this.slot4 = slot4;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	@Override
	public String toString() {
		return "AppointmentModel [id=" + id + ", doctorId=" + doctorId + ", patientId=" + patientId + ", patientName="
				+ patientName + ", date=" + date + ", doctorName=" + doctorName + ", slot1=" + slot1 + ", slot2="
				+ slot2 + ", slot3=" + slot3 + ", slot4=" + slot4 + ", status=" + status + "]";
	}
	
	
	
}
