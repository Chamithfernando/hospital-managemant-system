package com.hospitalManagementSystem.demo.Repository;

import com.hospitalManagementSystem.demo.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
