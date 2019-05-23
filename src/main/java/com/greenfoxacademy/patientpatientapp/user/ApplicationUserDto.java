package com.greenfoxacademy.patientpatientapp.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUserDto {

  private String username;
  private String name;

  public ApplicationUserDto() {
  }

  public ApplicationUserDto(String username, String name) {
    this.username = username;
    this.name = name;
  }
}
