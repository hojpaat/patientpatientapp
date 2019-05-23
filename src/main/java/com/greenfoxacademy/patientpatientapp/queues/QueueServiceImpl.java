package com.greenfoxacademy.patientpatientapp.queues;

import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOfficeRepository;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import com.greenfoxacademy.patientpatientapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

  private QueueRepository queueRepository;
  private DoctorsOfficeRepository doctorsOfficeRepository;
  private UserRepository userRepository;

  @Autowired
  public QueueServiceImpl(QueueRepository queueRepository, DoctorsOfficeRepository doctorsOfficeRepository, UserRepository userRepository) {
    this.queueRepository = queueRepository;
    this.doctorsOfficeRepository = doctorsOfficeRepository;
    this.userRepository = userRepository;
  }

 /* public Queue getQueueFromUsername (String name) {
    ApplicationUser user = userRepository.findByName(name);
    return queueRepository.findByUserId(user.getId());
  } */

  public String getDoctorsNameFromQueueId (Queue queue) {
    return doctorsOfficeRepository.findById(queue.getId()).getUser().getUsername();
  }

  public String getDoctorsAddressFromQueueId (Queue queue) {
    return doctorsOfficeRepository.findById(queue.getId()).getAddress();
  }

  public QueueDTO createDtoFromQueue (String userName) {
   ApplicationUser user = userRepository.findByUsername(userName);
   Queue queue = queueRepository.findByUserId(user.getId());
   return new QueueDTO(queue.getId(), getDoctorsNameFromQueueId(queue), getDoctorsAddressFromQueueId(queue), 5, "12:20");
  }
}
