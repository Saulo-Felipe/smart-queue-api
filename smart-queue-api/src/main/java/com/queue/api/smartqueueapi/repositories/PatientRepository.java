package com.queue.api.smartqueueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queue.api.smartqueueapi.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  // O spring fornece um código pronto para realização de um CRUD básico
}
