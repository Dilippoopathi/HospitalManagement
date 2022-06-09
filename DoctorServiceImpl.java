package com.hms.app.HospitalManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.app.HospitalManagement.Entity.Doctor;
import com.hms.app.HospitalManagement.Repository.DoctorRepository;
import com.hms.application.ResourceNotFound.ResourceNotFoundException;


@Service
public class DoctorServiceImpl  implements DoctorService {
@Autowired
	 DoctorRepository doctorRepository;
	 
	 
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
	super();
	this.doctorRepository = doctorRepository;
}




	@Override
	public List<Doctor> listAllDoctor() {
		
		return doctorRepository.findAll();//10
		// employeeRepository.findById(id)/101
		
	}


	

	@Override
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
	}

}