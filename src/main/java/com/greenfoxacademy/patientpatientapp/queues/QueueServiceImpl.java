package com.greenfoxacademy.patientpatientapp.queues;

import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOfficeRepository;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import com.greenfoxacademy.patientpatientapp.user.UserRepository;
import com.greenfoxacademy.patientpatientapp.utulities.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements QueueService {

  private QueueRepository queueRepository;
  private DoctorsOfficeRepository doctorsOfficeRepository;
  private UserRepository userRepository;

  @Autowired
  public QueueServiceImpl(QueueRepository queueRepository,
                          DoctorsOfficeRepository doctorsOfficeRepository,
                          UserRepository userRepository) {
    this.queueRepository = queueRepository;
    this.doctorsOfficeRepository = doctorsOfficeRepository;
    this.userRepository = userRepository;
  }

  public String getDoctorsNameFromQueueId (Queue queue) {
    return doctorsOfficeRepository.findById(queue.getDoctorsOffice().getId()).getUser().getName();
  }

  public String getDoctorsAddressFromQueueId (Queue queue) {
    return doctorsOfficeRepository.findById(queue.getDoctorsOffice().getId()).getAddress();
  }

  public QueueDTO createDtoFromQueue (Authentication auth) {
   ApplicationUser user = userRepository.findByUsername(getLoggedInUser(auth));
   Queue queue = queueRepository.findByUserId(user.getId());
   return new QueueDTO(queue.getId(), getDoctorsNameFromQueueId(queue),
           getDoctorsAddressFromQueueId(queue), 5, "12:20");
  }

  public String getLoggedInUser(Authentication auth) {
    return userRepository.findByUsername(auth.getPrincipal().toString()).getUsername();
  }
  
  public Queue getByUserId(long id){
    return queueRepository.findByUserId(id);
  }
  
  public Queue changeTime(Queue queue, long minutes){
    queue.setTime(TimeService.changeWithMinutes(queue.getTime(), minutes));
    System.out.println(TimeService.getLeftTime(queue.getTime()));
    return queue;
  }
  
  public String getLeftTimeString(Queue queue){
    return TimeService.getLeftTime(queue.getTime());
  }
  
}
