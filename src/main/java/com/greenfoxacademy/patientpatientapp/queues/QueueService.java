package com.greenfoxacademy.patientpatientapp.queues;

import java.util.List;

public interface QueueService {
  
  List<Queue> getQueues();
  
  void changeQueueTime(List<Queue> queues, Long timeDifference);
  
  boolean deleteQueue(long id);
}
