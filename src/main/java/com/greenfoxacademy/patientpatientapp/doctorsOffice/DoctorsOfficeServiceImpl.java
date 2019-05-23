package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorsOfficeServiceImpl implements DoctorsOfficeService {
  
  DoctorsOfficeRepository doctorsOfficeRepository;
  
  @Autowired
  public DoctorsOfficeServiceImpl(DoctorsOfficeRepository doctorsOfficeRepository) {
    this.doctorsOfficeRepository = doctorsOfficeRepository;
  }
  
  public boolean isDoctorOfficeUnregistered(DoctorsOffice doctorsOffice){
    return doctorsOfficeRepository.findByAddress(doctorsOffice.getAddress()) == null ? true : false;
  }
  
  public DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice) throws DoctorsOfficeException {
    if(isDoctorOfficeUnregistered(doctorsOffice)){
      return doctorsOfficeRepository.save(doctorsOffice);
    }
    throw new DoctorsOfficeException("Doctor's Office already registered!");
  }
  
  public List<DoctorsOffice> getDoctors(){
    return doctorsOfficeRepository.findAll();
  }
}
