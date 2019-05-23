package com.greenfoxacademy.patientpatientapp.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String cathegory;
  private long timeInMinutes;
}
