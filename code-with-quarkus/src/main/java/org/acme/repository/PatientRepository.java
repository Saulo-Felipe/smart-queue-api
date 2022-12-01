package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.Patient;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped // mostra ao quarkus que essa classe faz parte do sistema
public class PatientRepository implements PanacheRepository<Patient> {

}
