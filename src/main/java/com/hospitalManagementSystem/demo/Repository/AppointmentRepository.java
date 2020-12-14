package com.hospitalManagementSystem.demo.Repository;

import com.hospitalManagementSystem.demo.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
