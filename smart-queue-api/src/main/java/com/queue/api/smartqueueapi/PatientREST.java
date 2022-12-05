package com.queue.api.smartqueueapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queue.api.smartqueueapi.entity.Patient;
import com.queue.api.smartqueueapi.repositories.PatientRepository;


@RestController
@RequestMapping("/api/patient")
public class PatientREST {

  @Autowired
  private PatientRepository patientRepository;

  @GetMapping
  public List<Patient> listPatients() {
    return patientRepository.findAll();
  }

  @PostMapping
  public void createPatient(@RequestBody Patient patient) {
    System.out.println("Received: "+patient);
    patientRepository.save(patient);
  }

  @PutMapping
  public void updatePatient(@RequestBody Patient patient) {
    if (patient.getId() > 0) {
      patientRepository.save(patient); // save or alter
    }
  }

  @DeleteMapping
  public void deletePatient(@RequestBody Patient patient) {
    patientRepository.delete(patient);
  }
}
