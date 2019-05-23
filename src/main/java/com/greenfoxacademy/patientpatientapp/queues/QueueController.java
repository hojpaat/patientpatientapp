package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueueController {

  private QueueService queueService;

  @Autowired
  public QueueController(QueueService queueService) {
    this.queueService = queueService;
  }

  @DeleteMapping("/myqueue")
  public ResponseEntity deleteQueue(@RequestBody Queue queue){
    queueService.deleteQueue(queue.getId());
    return ResponseEntity.status(200).body("Changes done");
  }
}
