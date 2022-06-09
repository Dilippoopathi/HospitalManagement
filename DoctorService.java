package com.hms.app.HospitalManagement.Service;

import java.util.List;

import com.hms.app.HospitalManagement.Entity.Doctor;


public interface DoctorService {

	List<Doctor> listAllDoctor();

	Doctor getDoctorById(long id);

	void deleteDoctor(long id);

	Doctor updateDoctor(Long id, Doctor doctor);
	
	Doctor saveDoctor(Doctor doctor);

}
