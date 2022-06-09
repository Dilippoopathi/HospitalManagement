package com.hms.app.HospitalManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.app.HospitalManagement.Entity.AppointmentBooking;
import com.hms.app.HospitalManagement.Repository.AppointmentBookingRepository;
import com.hms.application.ResourceNotFound.ResourceNotFoundException;

@Service
public class AppointmentBookingServiceImpl  implements AppointmentBookingService {
@Autowired
	 AppointmentBookingRepository appointmentbookingRepository;
	 
	 
	
	public AppointmentBookingServiceImpl(AppointmentBookingRepository appointmentbookingRepository) {
	super();
	this.appointmentbookingRepository = appointmentbookingRepository;
}




	@Override
	public List<AppointmentBooking> listAllAppointmentBooking() {
		
		return appointmentbookingRepository.findAll();//10
		// employeeRepository.findById(id)/101
		
	}




	@Override
	public AppointmentBooking getAppointmentBookingById(long id) {
		Optional<AppointmentBooking> appointmentbooking=appointmentbookingRepository.findById(id);
		if(appointmentbooking.isPresent()) {
			return appointmentbooking.get();
			
		}
		else
		{
			return null;
		}
	}




	@Override
	public AppointmentBooking saveAppointmentBooking(AppointmentBooking appointmentbooking) {
		return appointmentbookingRepository.save(appointmentbooking);
	}




	@Override
	public void deleteAppointmentBooking(long id) {
		appointmentbookingRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("AppoinmentBooking","Id",id));
		
		appointmentbookingRepository.deleteById(id);
		
	}




	@Override
	public AppointmentBooking updateAppointmentBooking(Long id, AppointmentBooking appointmentbooking) {
		AppointmentBooking app = new AppointmentBooking();
		 try {
			 //orElseThrow();
			   app = appointmentbookingRepository.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFoundException("AppoimentBooking","Id",id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 Long patientId=appointmentbooking.getPatientId();
		 app.setPatientId(patientId);
		  String patientName = appointmentbooking.getPatientName();
		 app.setPatientName(patientName);
		 app.setDisease(appointmentbooking.getDisease());
		 app.setSpecialization(appointmentbooking.getSpecialization());
		 app.setBookingDate(appointmentbooking.getBookingDate());
		 app.setBookingTime(appointmentbooking.getBookingTime());
		 //emp.setSalary(employee.getSalary());
		 
		 appointmentbookingRepository.save(app);
		return app;
	}


	

	/*@Override
	public Doctor getDoctorById(long id) {
		Optional<Doctor> doctor=doctorRepository.findById(id);
		if(doctor.isPresent()) {
			return doctor.get();
			
		}
		else
		{
			return null;
		}
	}


	

	@Override
	public void deleteDoctor(long id) {
		doctorRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Doctor","Id",id));
		
		doctorRepository.deleteById(id);//13
		
	}


	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Doctor doc = new Doctor();
		 try {
			 //orElseThrow();
			   doc = doctorRepository.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFoundException("Doctor","Id",id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  String doctorName = doctor.getDoctorName();
		 doc.setDoctorName(doctorName);
		 //pat.setPatientName(patient.getPatientName());
		 doc.setSpecialization(doctor.getSpecialization());
		 doc.setContactNo(doctor.getContactNo());
		 //emp.setDesignation(employee.getDesignation());
		 //emp.setSalary(employee.getSalary());
		 
		 doctorRepository.save(doc);
		return doc;
	}


	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}*/

}