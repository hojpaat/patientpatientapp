package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<Queue, Long> {
  
  List<Queue> findAll();
  Queue findById(long id);

}
