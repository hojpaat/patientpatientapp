package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsOfficeRepository extends CrudRepository<DoctorsOffice, Long> {
  DoctorsOffice findById(long id);
}
