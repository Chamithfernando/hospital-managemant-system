package com.hospitalManagementSystem.demo.Repository;

import com.hospitalManagementSystem.demo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
