package com.springBoot.HealthCare;

import java.util.List;

public class AppointmentResponse {
	private String msg;
	private DuplicateAppointmentModel model;
	private AppointmentModel data;
	private int i;
	private List<DuplicateAppointmentModel> l;
	private List<AppointmentModel> a;
	public AppointmentResponse(String msg, DuplicateAppointmentModel model, AppointmentModel data, int i,
			List<DuplicateAppointmentModel> l, List<AppointmentModel> a) {
		super();
		this.msg = msg;
		this.model = model;
		this.data = data;
		this.i = i;
		this.l = l;
		this.a = a;
	}
	public AppointmentResponse() {
		super();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public DuplicateAppointmentModel getModel() {
		return model;
	}
	public void setModel(DuplicateAppointmentModel model) {
		this.model = model;
	}
	public AppointmentModel getData() {
		return data;
	}
	public void setData(AppointmentModel data) {
		this.data = data;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public List<DuplicateAppointmentModel> getL() {
		return l;
	}
	public void setL(List<DuplicateAppointmentModel> l) {
		this.l = l;
	}
	public List<AppointmentModel> getA() {
		return a;
	}
	public void setA(List<AppointmentModel> a) {
		this.a = a;
	}
	
}
