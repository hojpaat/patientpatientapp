package com.greenfoxacademy.patientpatientapp.queues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueuePatientDto {
  
  private String name;
  private String time;
  private String category;
}
