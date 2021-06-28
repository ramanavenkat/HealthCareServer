package com.springBoot.HealthCare;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String mobileNumber;
	private String name;
	private String email;
	private String password;
	private String guardianName;
	private String state;
	private String district;
	private String city;
	private String pincode;
	private boolean active=true;
	private String roles="ROLE_USER";
	public PatientModel() {
		super();
	}
	public PatientModel(int id, String mobileNumber, String name,String email,String password, String guardianName, String state, String district,
			String city, String pincode,boolean active,String roles) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.email=email;
		this.password=password;
		this.guardianName = guardianName;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.active=active;
		this.roles=roles;
		
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "PatientModel [id=" + id + ", mobileNumber=" + mobileNumber + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", guardianName=" + guardianName + ", state=" + state + ", district="
				+ district + ", city=" + city + ", pincode=" + pincode + ", active=" + active + ", roles=" + roles
				+ "]";
	}
	
	
	
	
}
