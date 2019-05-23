package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;

import java.util.List;

public interface DoctorsOfficeService {
  DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice) throws DoctorsOfficeException;
  List<DoctorsOffice> getDoctors();
}
