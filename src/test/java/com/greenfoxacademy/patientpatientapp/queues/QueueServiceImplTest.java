package com.greenfoxacademy.patientpatientapp.queues;

import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QueueServiceImplTest {

  private ApplicationUser testDoctor;
  private List<QueuePatientDto> patientDtos;
  private QueuePatientDto testPatient1;
  private QueuePatientDto testPatient2;

  @Mock
  private QueueRepository queueRepository;

  private QueueServiceImpl queueServiceImpl;

  @Before
  public void init() {
    testDoctor = new ApplicationUser();
    testDoctor.setName("Dr.Bubo");
    testPatient1 = new QueuePatientDto("Jane", "10:00", "prescription");
    testPatient2 = new QueuePatientDto("Joe", "12:00", "consultation");
    patientDtos.add(testPatient1);
    patientDtos.add(testPatient2);
  }
}
