package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity showUsersQueue (String username) {
    return ResponseEntity.ok().body(queueService.createDtoFromQueue(username));
  }
}
