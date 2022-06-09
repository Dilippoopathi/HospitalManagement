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

import com.hms.app.HospitalManagement.Entity.AppointmentBooking;
import com.hms.app.HospitalManagement.Service.AppointmentBookingService;





@RestController
@RequestMapping("/api/appointmentbooking")
public class AppointmentBookingController {
@Autowired
	AppointmentBookingService appointmentbookingservice;
	
	public AppointmentBookingController(AppointmentBookingService appointmentbookingservice) {
		super();
		this.appointmentbookingservice = appointmentbookingservice;
	}


	@GetMapping
	public  List<AppointmentBooking> listAllAppointmentBooking() {
		
		return appointmentbookingservice.listAllAppointmentBooking();
		
	}
	
	
	@GetMapping("{id}")
	public  AppointmentBooking getAppointmentBookingById(@PathVariable("id") long id) {
		return appointmentbookingservice.getAppointmentBookingById(id);
		
	}
	

	@PostMapping
	public ResponseEntity<AppointmentBooking> saveAppointmentBooking(@RequestBody AppointmentBooking appointmentbooking){
		return new ResponseEntity<AppointmentBooking>(appointmentbookingservice.saveAppointmentBooking(appointmentbooking), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("{id}")

	public String deleteAppointmentBooking(@PathVariable("id") long id){
		appointmentbookingservice.deleteAppointmentBooking(id);
		return ("AppointmentBooking record deleted ");
		
	}

	
	@PutMapping("{id}")
	public ResponseEntity<AppointmentBooking> updateAppointmentBooking(@PathVariable("id") Long id , @RequestBody AppointmentBooking appointmentbooking) {
		return new ResponseEntity<AppointmentBooking>(appointmentbookingservice.updateAppointmentBooking( id,  appointmentbooking), HttpStatus.OK);
		
	}
	
}

