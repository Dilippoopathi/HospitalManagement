package com.hms.app.HospitalManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hms.app.HospitalManagement.Entity.Doctor;
import com.hms.app.HospitalManagement.Service.DoctorService;

@RestController
@RequestMapping("/api/admin")
public class AdminController
{

	@Autowired
	DoctorService doctorservice;
	
	public AdminController(DoctorService doctorservice) {
		super();
		this.doctorservice = doctorservice;
	}


	@GetMapping
	public  List<Doctor> listAllDoctor() {
		
		return doctorservice.listAllDoctor();
		
	}
	
	
	@GetMapping("{id}")
	public  Doctor getDoctorById(@PathVariable("id") long id) {
		return doctorservice.getDoctorById(id);
		
	}
	

	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorservice.saveDoctor(doctor), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("{id}")

	public String deleteDoctor(@PathVariable("id") long id){
		doctorservice.deleteDoctor(id);
		return ("Doctor record deleted ");
		
	}

	
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") Long id , @RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorservice.updateDoctor( id,  doctor), HttpStatus.OK);
		
	}
	
	
}