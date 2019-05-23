package com.greenfoxacademy.patientpatientapp.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOffice;
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

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String name;
  String password;
  String role;
  String email;

  @JsonIgnore
  @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private DoctorsOffice doctorsOffice;

  public ApplicationUser(String name, String password, String role, String email) {
    this.name = name;
    this.password = password;
    this.role = role;
    this.email = email;
  }
}
