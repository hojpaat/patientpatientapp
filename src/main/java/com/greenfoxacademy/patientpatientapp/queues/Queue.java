package com.greenfoxacademy.patientpatientapp.queues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Queue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long time;
 /* private Service service;
  private DoctorsOffice doctorsOffice;
  private User userId;
*/




}
