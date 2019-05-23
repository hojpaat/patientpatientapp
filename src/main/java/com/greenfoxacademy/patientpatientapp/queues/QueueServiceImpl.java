package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

  private QueueRepository queueRepository;

  @Autowired
  public QueueServiceImpl(QueueRepository queueRepository) {
    this.queueRepository = queueRepository;
  }

}
