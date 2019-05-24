package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import com.greenfoxacademy.patientpatientapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorsOfficeServiceImpl implements DoctorsOfficeService {
  
  DoctorsOfficeRepository doctorsOfficeRepository;
  
  @Autowired
  public DoctorsOfficeServiceImpl(DoctorsOfficeRepository doctorsOfficeRepository, UserService userService) {
    this.doctorsOfficeRepository = doctorsOfficeRepository;
  }
  
  public boolean isDoctorOfficeUnregistered(DoctorsOffice doctorsOffice){
    return doctorsOfficeRepository.findByAddress(doctorsOffice.getAddress()) == null ? true : false;
  }
  
  public DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice, ApplicationUser user) throws DoctorsOfficeException {
    if(isDoctorOfficeUnregistered(doctorsOffice)){
      doctorsOffice.setUser(user);
      return doctorsOfficeRepository.save(doctorsOffice);
    }
    throw new DoctorsOfficeException("Doctor's Office already registered!");
  }
  
  public List<DoctorsOffice> getDoctorsOffices(){
    return doctorsOfficeRepository.findAll();
  }
  
  public List<DoctorDto> getDoctors(){
    List<DoctorDto> doctors = new ArrayList<>();
    getDoctorsOffices().forEach(doctorsOffice -> {
      doctors.add(createDoctorDto(doctorsOffice));
    });
    return doctors;
  }
  
  public DoctorDto createDoctorDto(DoctorsOffice doctorsOffice){
    return new DoctorDto(doctorsOffice.getUser().getName());
  }
}
