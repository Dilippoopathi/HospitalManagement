package com.hms.app.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.app.HospitalManagement.Entity.AppointmentBooking;

public interface AppointmentBookingRepository extends JpaRepository<AppointmentBooking,Long> {
	
	

}
