package com.queue.api.smartqueueapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    List<Patient> allPatients = new ArrayList<Patient>(patientRepository.findAll());

    startHeapSort(allPatients);

    return allPatients;
  }

  @PatchMapping
  public @ResponseBody List<Patient> callPatient(@RequestBody Patient patient) {
    System.out.println("Removing: "+patient.getId());

    patientRepository.delete(patient);
    List<Patient> allPatients = new ArrayList<Patient>(patientRepository.findAll());

    startHeapSort(allPatients);
    
    return allPatients;
  }


  private static void startHeapSort(List<Patient> allPatients) {
    List<Patient> normalQueue = new ArrayList<Patient>();
    List<Patient> priorityQueue = new ArrayList<Patient>();

    for (int c = 0; c < allPatients.size(); c++) {
      Patient current = allPatients.get(c);

      if (current.isIspriority()) {
        priorityQueue.add(current);
      } else {
        normalQueue.add(current);
      }
    }

    // Heap sort
    int arrSize = priorityQueue.size();

    for (int i = arrSize/2 - 1; i >= 0 ; i--) {
      heapSort(priorityQueue, arrSize, i);
    }

    for (int j = arrSize-1; j > 0; j--) {
      Patient aux = priorityQueue.get(0);
      priorityQueue.set(0, priorityQueue.get(j));
      priorityQueue.set(j, aux);

      heapSort(priorityQueue, j, 0);
    }

    allPatients.clear();

    allPatients.addAll(priorityQueue);
    allPatients.addAll(normalQueue);
  }

  
  private static void heapSort(List<Patient> priorityQueue, int size, int i) {
    int root = i;
    int left = 2*i+1;
    int right = 2*i+2;

    if (left < size && priorityQueue.get(left).getAge() > priorityQueue.get(root).getAge()) {
      root = left;
    }

    if (right < size && priorityQueue.get(right).getAge() > priorityQueue.get(root).getAge()) {
      root = right;
    }

    if (root != i) {
      Patient aux = priorityQueue.get(i);
      priorityQueue.set(i, priorityQueue.get(root));
      priorityQueue.set(root, aux);

      heapSort(priorityQueue, size, root);
    }
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

  // @DeleteMapping("{userId}")
  // public void deletePatient(@PathVariable Integer userId) {
  //   System.out.println("[remove]: "+patient.getName());

  //   patientRepository.delete(patient);
  // }

  public void printPatients(List<Patient> patients) {
    for (int i = 0; i < patients.size(); i++) {
      System.out.println("{ "+patients.get(i).getName()+", "+patients.get(i).getAge()+" }");
    }

    System.out.println("=-=-=-=-=-=-=-=-=-=-=");
  }
}
