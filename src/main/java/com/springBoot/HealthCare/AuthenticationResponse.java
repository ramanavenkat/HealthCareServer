package com.springBoot.HealthCare;

public class AuthenticationResponse {
	
	private String jwt;
	private PatientModel pModel;
	private CredentialModel model;
	private String msg;
	
	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String jwt,PatientModel pModel, CredentialModel model, String msg) {
		super();
		this.jwt = jwt;
		this.pModel=pModel;
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

	public PatientModel getpModel() {
		return pModel;
	}

	public void setpModel(PatientModel pModel) {
		this.pModel = pModel;
	}
	
	
	

}
