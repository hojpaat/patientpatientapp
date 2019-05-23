package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;

public interface UserService {

  ApplicationUserDto saveUser(ApplicationUser user) throws UserException;

  boolean checkIfValid(ApplicationUser user) throws UserException;

  ApplicationUserDto mapUserToDto(ApplicationUser applicationUser);
}
