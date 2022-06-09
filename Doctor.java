package com.hms.app.HospitalManagement.Entity;

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
public class Doctor {
	
	@Id
	private long doctorId;
	@Column
	private String doctorName;
	@Column
	private String email;
	@Column
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column
	private String specialization;
	@Column
	private long contactNo;
	@ManyToMany(fetch=FetchType.LAZY)
	
	private List<Patient> patient;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	//@JoinTable(name="doctor_appoiment",joinColumns= {@joincolumn(name="doctorId")},inverseJoinColumns=@joincolumn(name="AppointmentId"))
	private List<AppointmentBooking> appointmentbooking;
	
	public List<AppointmentBooking> getAppointmentbooking() {
		return appointmentbooking;
	}
	public void setAppointmentbooking(List<AppointmentBooking> appointmentbooking) {
		this.appointmentbooking = appointmentbooking;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public Doctor(long doctorId, String doctorName, String email, String password, String specialization,
			long contactNo, List<Patient> patient, List<AppointmentBooking> appointmentbooking) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.email = email;
		this.password = password;
		this.specialization = specialization;
		this.contactNo = contactNo;
		this.patient = patient;
		this.appointmentbooking = appointmentbooking;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", email=" + email + ", password="
				+ password + ", specialization=" + specialization + ", contactNo=" + contactNo + ", patient=" + patient
				+ ", appointmentbooking=" + appointmentbooking + "]";
	}
	
	
	

}
