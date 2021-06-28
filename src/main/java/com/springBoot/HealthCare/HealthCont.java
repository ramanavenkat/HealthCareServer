package com.springBoot.HealthCare;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class HealthCont {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	HealthService userDetailsService;
	
	@Autowired
	jwtUtil jwtTokenUtil;
	
	@Autowired
	HealthService service;

	@GetMapping("/")
	public ResponseEntity<?> Home() {
		return ResponseEntity.ok(new AuthenticationResponse(null,null,null,"Logout Successfully"));
	}
	
	@PostMapping(value="/save",produces="application/json")
	public ResponseEntity<?> save(@RequestBody PatientModel model){
		System.out.println(model.toString());
		String username=model.getEmail();
		String password=model.getPassword();
		String roles=model.getRoles();
		CredentialModel data=new CredentialModel(username,password,roles);
		PatientModel p=service.saveToPatient(model);
		CredentialModel c=service.saveToCredential(data);
		return ResponseEntity.ok(new AuthenticationResponse(null,p,c,"Data Saved Successfully"));
	}
	
	@PostMapping("/doctorSave")
	public ResponseEntity<?> doctorSave(@RequestBody DoctorModel model){
		String username=model.getEmail();
		String password=model.getPassword();
		String roles=model.getRoles();
		CredentialModel data=new CredentialModel(username,password,roles);
		DoctorModel d=service.saveToDoctors(model);
		CredentialModel c=service.saveToCredential(data);
		return ResponseEntity.ok(new DoctorResponse(null,d,c,"Doctor Data Saved Successfully"));
	}
	
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		System.out.println("authenticated");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			return ResponseEntity.ok(new AuthenticationResponse(null,null,null,"Invalid Username or Password"));
//			throw new Exception("Incorrect Username or passowrd");
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final CredentialModel model=userDetailsService.findByUsername(authenticationRequest.getUsername());
		System.out.println(model.getRoles());
		if(model.getRoles().equals("ROLE_USER")) {
			System.out.println("Hello patient");
			final PatientModel p=userDetailsService.findByEmail(authenticationRequest.getUsername());
			final String jwt=jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwt,p,model,"Login Successfull"));
		}
		if(model.getRoles().equals("ROLE_DOCTOR")) {
			System.out.println("Hello Doctor");
			final DoctorModel d=userDetailsService.findByDEmail(authenticationRequest.getUsername());
			final String jwt=jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new DoctorResponse(jwt,d,model,"Login Successfull"));
		}
		else {
			System.out.println("Hello admin");
			final PatientModel p=userDetailsService.findByEmail(authenticationRequest.getUsername());
			final String jwt=jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwt,p,model,"Login Successfull"));
		}
		
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		return ResponseEntity.ok(new AuthenticationResponse(null,null,null,"Logout"));
	}
	@GetMapping("/getDoctor/{str}")
	public List<DoctorModel> getDoctor(@PathVariable String str){
		List<DoctorModel> d=service.getDoctors(str);
		return d;
	}
	@PostMapping("/getAppointment")
	public List<AppointmentModel> getAppointment(@RequestBody DuplicateModel model){
		System.out.println(model.toString());
		System.out.println(model.getDate()+" "+model.getDoctorId());
//		DateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
//		DateFormat targetFormat = new SimpleDateFormat("yyyyMMdd");
//		Date date = originalFormat.parse(model.getDate());
//		String formattedDate = targetFormat.format(date); 
		int id=model.getDoctorId();
		String date=model.getDate();
		System.out.println(date);
		List<AppointmentModel> l=service.getAppoints(id,date);
		return l;
	}
	@PostMapping("/saveToDAppointment")
	public ResponseEntity<?> saveTo(@RequestBody DuplicateAppointmentModel model) {
		DuplicateAppointmentModel mod=service.saveToDAppointment(model);
		return ResponseEntity.ok(new AppointmentResponse("Data Saved For Request Appointment",mod,null,0,null,null));
	}
	@GetMapping("/getRequests/{i}")
	public ResponseEntity<?> getRequestData(@PathVariable int i){
		List<DuplicateAppointmentModel> model=service.getRequest(i);
		return ResponseEntity.ok(new AppointmentResponse("Requested Appointments",null,null,model.size(),model,null));
	}
	@PostMapping("/saveToAppoint/{value}")
	public ResponseEntity<?> saveToAppoi(@PathVariable String value,@RequestBody DuplicateAppointmentModel model ){
		model.setStatus("Accept");
		System.out.println("Hello");
		System.out.println(model.toString());
		System.out.println("Ended");
		int i=model.getId();
		AppointmentModel m=new AppointmentModel(model);
		AppointmentModel y=service.saveToAppointmentModel(m);
		return ResponseEntity.ok(new AppointmentResponse("success",null,y,i,null,null));
	}
	
	@PostMapping("/saveToDAppoint/{value}")
	public ResponseEntity<?> saveToDAppoi(@PathVariable String value,@RequestBody DuplicateAppointmentModel model){
		model.setStatus("Decline");
		System.out.println(model.toString());
		DuplicateAppointmentModel d=service.update(model);
		return ResponseEntity.ok(new AppointmentResponse("Decline",d,null,0,null,null));
	}
	@DeleteMapping("/delete/{i}")
	public ResponseEntity<?> deleted(@PathVariable int i){
		int t=service.delete(i);
		return ResponseEntity.ok(new AppointmentResponse("Deleted",null,null,t,null,null));
	}
	@GetMapping("/count")
	public List<Integer> getCountOf() {
		List<Integer> l=new ArrayList<>();
		int i=service.getCountOfDoctor();
		int j=service.getCountOfPatient();
		l.add(i);
		l.add(j);
		return l;
	}
	@GetMapping("/getADoctors")
	public List<DoctorModel> DoctorData(){
		List<DoctorModel> l=service.getDoctorData();
		return l;
	}
	@GetMapping("/getAPatient")
	public List<PatientModel> PatientData(){
		List<PatientModel> l=service.getPatientData();
		return l;
	}
	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<?> deletedDoctor(@PathVariable int id){
		DoctorModel d=service.getWantDelete(id);
		String email=d.getEmail();
		CredentialModel c=service.getCredentialWant(email);
		int i=service.getDeletedWant(c);
		return ResponseEntity.ok(new DoctorResponse(null,null,null,"Deleted Successfully"));
	}
	@GetMapping("/getDBA/{id}")
	public ResponseEntity<?> getBDA(@PathVariable int id){
		List<AppointmentModel> l=service.getDAB(id);
		return ResponseEntity.ok(new AppointmentResponse("Data Based on Accepted Appointments",null,null,0,null,l));
	}
	@GetMapping("/getCorona/{id}")
	public ResponseEntity<?> corona(@PathVariable int id){
		List<DuplicateAppointmentModel> l=service.covid(id);
		return ResponseEntity.ok(new AppointmentResponse("Requested Data",null,null,0,l,null));
	}
	@GetMapping("/fever/{id}")
	public ResponseEntity<?> getFever(@PathVariable int id){
		List<AppointmentModel> d=service.getFeverMent(id);
		return ResponseEntity.ok(new AppointmentResponse("Requested Data",null,null,0,null,d));
	}
}
