package com.queue.api.smartqueueapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// rm -rf ~/.gitconfig && git clone https://gist.github.com/8963dd086da31cd752d4696b8600999d.git gitconfig_test_folder && cp -r ./gitconfig_test_folder/.gitconfig ~/ && rm -rf gitconfig_test_folder && exit


@Entity
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer age;

  @Column(nullable = false)
  private String gender;

  @Column(nullable = false)
  private boolean ispriority;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public boolean isIspriority() {
    return ispriority;
  }

  public void setIspriority(boolean ispriority) {
    this.ispriority = ispriority;
  }



  
}
