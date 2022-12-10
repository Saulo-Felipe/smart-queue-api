package com.queue.api.smartqueueapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queue.api.smartqueueapi.entity.Patient;
import com.queue.api.smartqueueapi.repositories.PatientRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/patient")
public class PatientREST {

  @Autowired
  private PatientRepository patientRepository;

  @GetMapping
  public List<Patient> listPatients() {
    printPatients(patientRepository.findAll());
    return patientRepository.findAll();
  }

  @PatchMapping
  public List<Patient> callPatient(@RequestBody Patient patient) {
    System.out.println("Removing: "+patient.getId());

    patientRepository.delete(patient);

    //  Organize here to send
    
    return patientRepository.findAll();
  }

  @PostMapping
  public void createPatient(@RequestBody Patient patient) {
    System.out.println("[create]: , "+patient.isIspriority());
    patientRepository.save(patient);
  }

  @PutMapping
  public void updatePatient(@RequestBody Patient patient) {

    if (patient.getId() > 0) {
      System.out.println("[update]: , "+patient.getName());

      patientRepository.save(patient); // save or alter
    }
  }

  @DeleteMapping
  public void deletePatient(@RequestBody Patient patient) {
    System.out.println("[remove]: "+patient.getName());
    patientRepository.delete(patient);
  }


  public void arrangePatientList(Patient[] patients) {

  }

  public void printPatients(List<Patient> patients) {
    for (int i = 0; i < patients.size(); i++) {
      System.out.println("{ "+patients.get(i).getName()+", "+patients.get(i).getAge()+" }");
    }
    System.out.println("=-=-=-=-=-=-=-=-=-=-=");
  }
}
