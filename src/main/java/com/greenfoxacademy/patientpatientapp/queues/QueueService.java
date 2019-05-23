package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.security.core.Authentication;

public interface QueueService {

  String getDoctorsNameFromQueueId (Queue queue);

  String getDoctorsAddressFromQueueId (Queue queue);

  QueueDTO createDtoFromQueue (Authentication auth);
  
  Queue getByUserId(long id);
}
