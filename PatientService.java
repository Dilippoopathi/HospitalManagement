package com.hms.app.HospitalManagement.Service;


import java.util.List;

import com.hms.app.HospitalManagement.Entity.Patient;


public interface PatientService {

	List<Patient> listAllPatient();

	Patient getPatientById(long id);

	Patient savePatient(Patient patient);

	void deletePatient(long id);

	//Patient updateEmployee(Long id, Patient patient);

	Patient updatePatient(Long id, Patient patient);

	//List<Doctor> listAllDoctor();

}

