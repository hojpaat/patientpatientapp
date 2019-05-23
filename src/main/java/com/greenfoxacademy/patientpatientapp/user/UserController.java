package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity addUser(@RequestBody ApplicationUser user)
          throws UserException {
    return ResponseEntity.ok().body(userService.saveUser(user));
  }
}
