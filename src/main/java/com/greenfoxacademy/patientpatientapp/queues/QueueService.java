package com.greenfoxacademy.patientpatientapp.queues;

public interface QueueService {

 // Queue getQueueFromUsername (String name);

  String getDoctorsNameFromQueueId (Queue queue);

  String getDoctorsAddressFromQueueId (Queue queue);

  QueueDTO createDtoFromQueue (String name);
}
