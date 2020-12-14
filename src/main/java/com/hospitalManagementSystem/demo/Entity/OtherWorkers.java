package com.hospitalManagementSystem.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
public class OtherWorkers {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long otherWorkersId;
   private String otherWorkersName;
   private int BasicSalary;
   private int Promotions;

}
