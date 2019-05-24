package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;
import org.springframework.security.core.Authentication;

public interface UserService {

  ApplicationUserDto saveUser(ApplicationUser user) throws UserException;

  boolean checkIfValid(ApplicationUser user) throws UserException;

  ApplicationUserDto mapUserToDto(ApplicationUser applicationUser);
  
  ApplicationUser getLoggedInUser(Authentication auth);
  
  ApplicationUser getUserByName(String name);
}
