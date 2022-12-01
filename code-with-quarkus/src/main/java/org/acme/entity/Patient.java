package org.acme.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // mostra que a classe representa uma tabela
@Data // Evita ter q escrever o contructor e os gets e sets
@NoArgsConstructor
public class Patient {

  @Id // primary key
  @GeneratedValue // automatic generate ids
  private Long id;

  private String name;

  private Integer age;

  private String sexo;
}