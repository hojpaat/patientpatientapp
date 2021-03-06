package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsOfficeRepository extends CrudRepository<DoctorsOffice, Long> {
  DoctorsOffice findById(long id);

  DoctorsOffice findByAddress(String address);

  List<DoctorsOffice> findAll();
  
  DoctorsOffice findByUser(ApplicationUser user);
}
