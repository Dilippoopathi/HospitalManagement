package com.hms.app.HospitalManagement.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
public class Patient {
	
	@Id
	private long patientId;
	@Column
	private String patientName;
	@Column
	private String Disease;
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
	private long phoneNumber;
	@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="Doctor_Patient",joinColumns= {@oinColumn(name="doctorId")},inverseJoinColumns=@joincolumn(name="patientId"))
	private List<Doctor> doctor;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	public Patient(long patientId, String patientName, String disease, String email, String password, long phoneNumber,
			List<Doctor> doctor) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		Disease = disease;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.doctor = doctor;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", Disease=" + Disease + ", email="
				+ email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", doctor=" + doctor + "]";
	}
	
	

}