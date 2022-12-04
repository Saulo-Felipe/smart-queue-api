package org.acme.controller;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.acme.entity.Patient;
import org.acme.service.PatientService;

import com.oracle.svm.core.annotate.Inject;

@Path("/api/patient")
public class PatientController {
  
  @Inject
  PatientService patientService;

  @GET
  public List<Patient> retrieverPatient() {

    List<Patient> patient = new ArrayList<>();

    try {
      patient = patientService.findAllPatients();
    } catch(Exception e) {
      e.printStackTrace();
    }

    return patient;
  }

  @POST
  @Transactional // Edição no banco de dados CREATE/DELETE/UPDATE
  public void createPatient(Patient patient) {
    patientService.addPatient(patient);
  }
}
