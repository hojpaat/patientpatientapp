package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorsOfficeServiceImpl {
  
  DoctorsOfficeRepository doctorsOfficeRepository;
  
  @Autowired
  public DoctorsOfficeServiceImpl(DoctorsOfficeRepository doctorsOfficeRepository) {
    this.doctorsOfficeRepository = doctorsOfficeRepository;
  }
}
