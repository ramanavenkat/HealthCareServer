package com.springBoot.HealthCare;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HealthService implements UserDetailsService {
	
	@Autowired
	HealthRepo repo;
	@Autowired
	PatientRepo repop;
	@Autowired
	DoctorRepo repod;
	@Autowired
	AppointmentRepo repoa;
	@Autowired
	DuplicateAppointmentRepo repoad;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CredentialModel model = repo.findByUsername(username);
		if(model==null) {
			throw new UsernameNotFoundException("Not Found...");
		}
		return new HealthGetDetails(model);
	}

	public PatientModel saveToPatient(PatientModel model) {
		model.setPassword(passwordEncoder.encode(model.getPassword()));
		PatientModel p=repop.save(model);
		return p;
	}
	public CredentialModel saveToCredential(CredentialModel model) {
		model.setPassword(passwordEncoder.encode(model.getPassword()));
		CredentialModel data=repo.save(model);
		return data;
	}

	public CredentialModel findByUsername(String username) {
		CredentialModel model=repo.findByUsername(username);
		return model;
	}

	public PatientModel findByEmail(String username) {
		PatientModel p=repop.findByEmail(username);
		return p;
	}
	public DoctorModel findByDEmail(String email) {
		DoctorModel d=repod.findByEmail(email);
		return d;
	}

	public DoctorModel saveToDoctors(DoctorModel model) {
		model.setPassword(passwordEncoder.encode(model.getPassword()));
		DoctorModel d=repod.save(model);
		return d;
	}
	
	public List<DoctorModel> getDoctors(String str) {
		List<DoctorModel> model=repod.findBySpecialization(str);
		return model;
	}
	public List<AppointmentModel> getAppoints(int id,String date){
		List<AppointmentModel> l=repoa.findByDoctorIdAndDate(id,date);
		System.out.println(l);
		return l;
	}

	public DuplicateAppointmentModel saveToDAppointment(DuplicateAppointmentModel model) {
		DuplicateAppointmentModel m=repoad.save(model);
		return m;
	}
	public List<DuplicateAppointmentModel> getRequest(int i){
		List<DuplicateAppointmentModel> l=repoad.findByDoctorId(i);
		return l;
	}
	
	public AppointmentModel saveToAppointmentModel(AppointmentModel model) {
		AppointmentModel m=repoa.save(model);
		return m;
	}
	public DuplicateAppointmentModel update(DuplicateAppointmentModel model) {
		DuplicateAppointmentModel d=repoad.save(model);
		return d;
	}
	public int delete(int i) {
		repoad.deleteById(i);
		return 1;
	}
	public int getCountOfDoctor() {
		List<DoctorModel> l=repod.findAll();
		int i=l.size();
		return i;
	}
	public int getCountOfPatient() {
		List<PatientModel> p=repop.findAll();
		int j=p.size();
		return j;
	}
	public List<DoctorModel> getDoctorData(){
		List<DoctorModel> l=repod.findAll();
		return l;
	}
	public List<PatientModel> getPatientData(){
		List<PatientModel> p=repop.findAll();
		return p;
	}
	public DoctorModel getWantDelete(int id) {
		DoctorModel m=repod.getById(id);
		repod.delete(m);
		return m;
	}
	public CredentialModel getCredentialWant(String username) {
		CredentialModel c=repo.findByUsername(username);
		return c;
	}
	public int getDeletedWant(CredentialModel c) {
		repo.delete(c);
		return 1;
	}
	public List<AppointmentModel> getDAB(int id){
		List<AppointmentModel> m=repoa.findByDoctorId(id);
		return m;
	}
	public List<DuplicateAppointmentModel> covid(int id){
		List<DuplicateAppointmentModel> p=repoad.findByPatientId(id);
		return p;
	}
	public List<AppointmentModel> getFeverMent(int id) {
		List<AppointmentModel> m=repoa.findByPatientId(id);
		return m;
	}
	
}
