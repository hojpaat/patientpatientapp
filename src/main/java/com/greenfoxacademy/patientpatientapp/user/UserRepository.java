package com.greenfoxacademy.patientpatientapp.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

 ApplicationUser findByUsername(String username);
 
 ApplicationUser findByName(String name);
}
