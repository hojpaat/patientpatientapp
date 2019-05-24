package com.greenfoxacademy.patientpatientapp.queues;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOffice;
import com.greenfoxacademy.patientpatientapp.service.ApplicationService;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Queue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long timeInMinutes;
  private Timestamp time = new Timestamp(System.currentTimeMillis());

  @JsonIgnore
  @ManyToOne
  private ApplicationService service;

  @JsonIgnore
  @ManyToOne
  private DoctorsOffice doctorsOffice;

  @JsonIgnore
  @OneToOne
  private ApplicationUser user;
}
