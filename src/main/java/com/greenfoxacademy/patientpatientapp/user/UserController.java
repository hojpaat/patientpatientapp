package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOffice;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOfficeService;
import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import com.greenfoxacademy.patientpatientapp.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
  UserService userService;
  DoctorsOfficeService doctorsOfficeService;

  @Autowired
  public UserController(UserService userService, DoctorsOfficeService doctorsOfficeService) {
    this.userService = userService;
    this.doctorsOfficeService = doctorsOfficeService;
  }

  @PostMapping("/doctorsoffice")
  public ResponseEntity saveDoctorsOffice(@RequestBody DoctorsOffice doctorsOffice, Authentication auth)
          throws DoctorsOfficeException {
    return ResponseEntity.status(200).body(doctorsOfficeService.saveDoctorsOffice(doctorsOffice, userService.getLoggedInUser(auth)));
  }

  @PostMapping("/register")
  public ResponseEntity addUser(@RequestBody ApplicationUser user)
          throws UserException {
    return ResponseEntity.ok().body(userService.saveUser(user));
  }

  @GetMapping("/doctors")
  public ResponseEntity getDoctors() {
    return ResponseEntity.status(200).body(doctorsOfficeService.getDoctors());
  }
}
