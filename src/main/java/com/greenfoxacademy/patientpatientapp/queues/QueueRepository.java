package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<Queue, Long> {
  Queue findByUserId(long id);
  List<Queue> findByDoctorsOffice_Id(long id);
}
