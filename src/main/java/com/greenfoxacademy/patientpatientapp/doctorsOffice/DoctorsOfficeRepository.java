package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsOfficeRepository extends CrudRepository<DoctorsOffice, Long> {
  DoctorsOffice findById(long id);
  DoctorsOffice findByAddress(String address);
}
