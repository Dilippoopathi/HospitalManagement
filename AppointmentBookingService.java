package com.hms.app.HospitalManagement.Service;

import java.util.List;

import com.hms.app.HospitalManagement.Entity.AppointmentBooking;

public interface AppointmentBookingService {

	List<AppointmentBooking> listAllAppointmentBooking();

	AppointmentBooking getAppointmentBookingById(long id);

	AppointmentBooking saveAppointmentBooking(AppointmentBooking appointmentbooking);

	void deleteAppointmentBooking(long id);

	AppointmentBooking updateAppointmentBooking(Long id, AppointmentBooking appointmentbooking);

}
