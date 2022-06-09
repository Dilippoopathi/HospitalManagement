package com.hms.app.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.app.HospitalManagement.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	

}
