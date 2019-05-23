package com.greenfoxacademy.patientpatientapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
  ServiceRepository serviceRepository;
  
  @Autowired
  public ServiceServiceImpl(ServiceRepository serviceRepository){
    this.serviceRepository = serviceRepository;
  }
}
