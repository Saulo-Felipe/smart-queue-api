package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.Patient;
import org.acme.repository.PatientRepository;

import com.oracle.svm.core.annotate.Inject;

@ApplicationScoped
public class PatientService {
  
  @Inject
  PatientRepository patientRepository;

  public List<Patient> findAllPatients() {
    return patientRepository.findAll().list();
  }

  public void addPatient(Patient patient) {
    patientRepository.persist(patient);
  }

}
