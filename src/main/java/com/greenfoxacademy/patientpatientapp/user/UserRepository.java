package com.greenfoxacademy.patientpatientapp.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

 ApplicationUser findByName(String name);
}
