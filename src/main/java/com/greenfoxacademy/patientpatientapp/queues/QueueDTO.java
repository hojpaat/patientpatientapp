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

  private long id;
  private String doctor;
  private String address;
  private int in_line;
  private String remaining_time;
  private String category;
  
  public QueueDTO(long id, String doctor, String address, int in_line, String remaining_time) {
    this.id = id;
    this.doctor = doctor;
    this.address = address;
    this.in_line = in_line;
    this.remaining_time = remaining_time;
  }
  
  public QueueDTO(String doctor, String category){
    this.doctor = doctor;
    this.category =category;
  }
  
}
