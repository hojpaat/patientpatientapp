package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface DoctorsOfficeService {
  DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice, ApplicationUser user) throws DoctorsOfficeException;
  List<DoctorsOffice> getDoctorsOffices();
  
  List<DoctorDto> getDoctors();
}
