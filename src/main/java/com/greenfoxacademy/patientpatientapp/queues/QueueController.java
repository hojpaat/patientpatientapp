package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

  private QueueServiceImpl queueServiceImpl;

  @Autowired
  public QueueController(QueueServiceImpl queueServiceImpl) {
    this.queueServiceImpl = queueServiceImpl;
  }

  @GetMapping("/myqueue")
  public Queue getQueue(String name) {
   // return queueServiceImpl.getUsersQueue(name);
  }
}
