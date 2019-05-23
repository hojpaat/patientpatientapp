package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorsOffice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String address;
  
  @OneToOne
  private ApplicationUser user;
  
}
