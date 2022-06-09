package com.hms.app.HospitalManagement.Entity;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class AppointmentBooking {
	
	@Id
	private long AppointmentId; 
	@Column
	private long patientId;
	@Column
	private String patientName;
	@Column
	private String Disease;
	@Column
	private String specialization;
	@Column
	private Date bookingDate;
	@Column
	private Time bookingTime;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	
	private List<Doctor> doctor;
	public long getAppointmentId() {
		return AppointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		AppointmentId = appointmentId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Time getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	public AppointmentBooking(long appointmentId, long patientId, String patientName, String disease,
			String specialization, Date bookingDate, Time bookingTime, List<Doctor> doctor) {
		super();
		AppointmentId = appointmentId;
		this.patientId = patientId;
		this.patientName = patientName;
		Disease = disease;
		this.specialization = specialization;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.doctor = doctor;
	}
	public AppointmentBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AppointmentBooking [AppointmentId=" + AppointmentId + ", patientId=" + patientId + ", patientName="
				+ patientName + ", Disease=" + Disease + ", specialization=" + specialization + ", bookingDate="
				+ bookingDate + ", bookingTime=" + bookingTime + ", doctor=" + doctor + "]";
	}
	
	
	

}

