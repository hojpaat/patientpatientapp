package com.greenfoxacademy.patientpatientapp.service;

import com.greenfoxacademy.patientpatientapp.queues.Queue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String category;
  private long timeInMinutes;

  @OneToMany(mappedBy = "service", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  private List<Queue> queues;
}
