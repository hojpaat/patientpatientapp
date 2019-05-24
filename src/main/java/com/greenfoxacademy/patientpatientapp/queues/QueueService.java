package com.greenfoxacademy.patientpatientapp.queues;

import org.springframework.security.core.Authentication;

import java.util.List;

public interface QueueService {

  String getDoctorsNameFromQueueId (Queue queue);

  String getDoctorsAddressFromQueueId (Queue queue);

  QueueDTO createDtoFromQueue (Authentication auth);
  
  Queue getByUserId(long id);
  
  List<Queue> getByDoctorsOfficeId(long id);
  
  Queue getLastQueueFromList(List<Queue> queues);
  
  List<QueuePatientDto> getDoctorPatients(List<Queue> queues);
  
  List<QueuePatientDto> listDoctorsPatients(Authentication auth);
  
  Queue createNewQueue(Authentication auth, String doctorName);
}
