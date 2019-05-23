package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

  private QueueRepository queueRepository;

  @Autowired
  public QueueServiceImpl(QueueRepository queueRepository) {
    this.queueRepository = queueRepository;
  }
  
  public List<Queue> getQueues(){
    return queueRepository.findAll();
  }
  
  public void changeQueueTime(List<Queue> queues, Long timeDifference){
    for(Queue queue : queues) {
      queue.setTime(new Timestamp(System.currentTimeMillis()));
      queueRepository.save(queue);
    }
  }
  
  public boolean deleteQueue(long id){
    queueRepository.delete(queueRepository.findById(id));
    return true;
  }

}
