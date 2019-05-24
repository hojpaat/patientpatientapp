package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorsOfficeServiceImpl implements DoctorsOfficeService {
  
  DoctorsOfficeRepository doctorsOfficeRepository;
  
  @Autowired
  public DoctorsOfficeServiceImpl(DoctorsOfficeRepository doctorsOfficeRepository) {
    this.doctorsOfficeRepository = doctorsOfficeRepository;
  }
  
  public boolean isDoctorOfficeUnregistered(DoctorsOffice doctorsOffice){
    return doctorsOfficeRepository.findByAddress(doctorsOffice.getAddress()) == null;
  }
  
  public DoctorsOffice saveDoctorsOffice(DoctorsOffice doctorsOffice) throws DoctorsOfficeException {
    if(isDoctorOfficeUnregistered(doctorsOffice)){
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
