package com.hms.app.HospitalManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.app.HospitalManagement.Entity.Patient;
import com.hms.app.HospitalManagement.Service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	PatientService patientservice;
	
	public PatientController(PatientService patientservice) {
		super();
		this.patientservice = patientservice;
	}


	@GetMapping
	public  List<Patient> listAllPatient() {
		
		return patientservice.listAllPatient();
		
	}
	
	
	@GetMapping("{id}")
	public  Patient getPatientById(@PathVariable("id") long id) {
		return patientservice.getPatientById(id);
		
	}
	

	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientservice.savePatient(patient), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("{id}")

	public String deletePatient(@PathVariable("id") long id){
		patientservice.deletePatient(id);
		return ("Patient record deleted ");
		
	}

	
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id , @RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientservice.updatePatient( id,  patient), HttpStatus.OK);
		
	}
	
}

