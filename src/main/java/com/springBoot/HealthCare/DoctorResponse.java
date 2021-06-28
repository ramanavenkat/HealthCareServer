package com.springBoot.HealthCare;

public class DoctorResponse {
	
	private String jwt;
	private DoctorModel dModel;
	private CredentialModel model;
	private String msg;
	
	public DoctorResponse() {
		super();
	}

	public DoctorResponse(String jwt,DoctorModel dModel, CredentialModel model, String msg) {
		super();
		this.jwt = jwt;
		this.dModel=dModel;
		this.model = model;
		this.msg = msg;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public CredentialModel getModel() {
		return model;
	}

	public void setModel(CredentialModel model) {
		this.model = model;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DoctorModel getdModel() {
		return dModel;
	}

	public void setdModel(DoctorModel dModel) {
		this.dModel = dModel;
	}

	
	
	
	

}
