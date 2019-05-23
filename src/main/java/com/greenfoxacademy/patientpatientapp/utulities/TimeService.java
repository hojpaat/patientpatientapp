package com.greenfoxacademy.patientpatientapp.utulities;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TimeService {
  
  public static LocalDateTime addLocalTime(Timestamp timestamp){
    return timestamp.toLocalDateTime();
  }
  
  public static Timestamp changeWithMinutes(Timestamp timestamp, long minutes){
    timestamp.setTime(timestamp.getTime() + ( minutes * 60000 ));
    return timestamp;
  }
  
  public static String createStringFromLong(long millis){
    int minutes = (int) ((millis / (1000*60)) % 60);
    int hours   = (int) ((millis / (1000*60*60)) % 24);
    
    return hours + ":" + minutes + ":0";
  }
  
  public static String getLeftTime(Timestamp timestamp){
    return createStringFromLong(timestamp.getTime() - System.currentTimeMillis());
  }
}
