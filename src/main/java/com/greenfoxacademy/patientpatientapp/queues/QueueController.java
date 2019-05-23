package com.greenfoxacademy.patientpatientapp.queues;

import com.greenfoxacademy.patientpatientapp.utulities.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

  private QueueService queueService;

  @Autowired
  public QueueController(QueueService queueService) {
    this.queueService = queueService;
  }

  @GetMapping("/myqueue")
  public ResponseEntity showUsersQueue (Authentication auth) {
    return ResponseEntity.ok().body(queueService.createDtoFromQueue(auth));
  }
  
  @GetMapping("/queues")
  public ResponseEntity getQueuesOfDoctor (){
    
    return ResponseEntity.ok().body(queueService.getDoctorPatients(queueService.getByDoctorsOfficeId(1)));
    
  }
}
