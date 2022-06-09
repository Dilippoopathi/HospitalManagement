package com.hms.app.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.app.HospitalManagement.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	
	

}

