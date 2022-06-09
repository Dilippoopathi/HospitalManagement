package com.hms.app.HospitalManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hms.app.HospitalManagement.Entity.Patient;
import com.hms.app.HospitalManagement.Repository.PatientRepository;
import com.hms.application.ResourceNotFound.ResourceNotFoundException;

@Service
public class PatientServiceImpl  implements PatientService {

	 PatientRepository patientRepository;
	 
	 
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}


	@Override
	public List<Patient> listAllPatient() {
		
		return patientRepository.findAll();//10
		// employeeRepository.findById(id)/101
		
	}


	@Override
	public Patient getPatientById(long id) {
		Optional<Patient> employee=patientRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
			
		}
		else
		{
			return null;
		}
	}


	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}


	@Override
	public void deletePatient(long id) {
		// TODO Auto-generated method stub
		patientRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
		
		patientRepository.deleteById(id);//13
		
	}


	@Override
	public Patient updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		Patient pat = new Patient();
		 try {
			 //orElseThrow();
			   pat = patientRepository.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFoundException("Patient","Id",id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  String patientName = patient.getPatientName();
		 pat.setPatientName(patientName);
		 //pat.setPatientName(patient.getPatientName());
		 pat.setDisease(patient.getDisease());
		 pat.setPhoneNumber(patient.getPhoneNumber());
		 //emp.setDesignation(employee.getDesignation());
		 //emp.setSalary(employee.getSalary());
		 
		 patientRepository.save(pat);
		return pat;
	}


	/*@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

@Override
public Employee getEmployeeById(long id)
{
	Optional<Employee> employee=employeeRepository.findById(id);
if(employee.isPresent()) {
	return employee.get();
	
}
else
{
	return null;
}
}

@Override
public void deleteEmployee(long id) {
	employeeRepository.findById(id).orElseThrow(
			()->new ResourceNotFoundException("Employee","Id",id));
	
	employeeRepository.deleteById(id);//13
	
}


@Override
public Employee updateEmployee(Long id, Employee employee) {
	Employee emp = new Employee();
	 try {
		 //orElseThrow();
		   emp = employeeRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFoundException("Employee","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  String fname = employee.getFirstName();
	 emp.setFirstName(fname);
	 emp.setLastName(employee.getLastName());
	 emp.setContactNo(employee.getContactNo());
	 emp.setEmail(employee.getEmail());
	 emp.setDesignation(employee.getDesignation());
	 emp.setSalary(employee.getSalary());
	 
	 employeeRepository.save(emp);
	return emp;
	}


@Override
public List<Employee> getByFirstName(String firstName) {
	return employeeRepository.getByFirstName(firstName);
}  */

}