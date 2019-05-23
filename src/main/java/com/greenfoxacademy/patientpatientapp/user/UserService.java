package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;

public interface UserService {

  ApplicationUser saveUser(ApplicationUser user) throws UserException;

  boolean checkIfValid(ApplicationUser user) throws UserException;
}
