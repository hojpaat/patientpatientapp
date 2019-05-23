package com.greenfoxacademy.patientpatientapp.queues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueueDTO {

  long id;
  String doctor;
  String address;
  int in_line;
  String remaining_time;
}
