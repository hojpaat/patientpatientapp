package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;

public interface DoctorsOfficeService {
  DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice) throws DoctorsOfficeException;
}
