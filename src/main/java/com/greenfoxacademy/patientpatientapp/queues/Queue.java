package com.greenfoxacademy.patientpatientapp.queues;

import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOffice;
import com.greenfoxacademy.patientpatientapp.service.Service;
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

  @ManyToOne
  private Service service;

  @ManyToOne
  private DoctorsOffice doctorsOffice;

  @OneToOne
  private ApplicationUser user;

}
