package com.hospitalManagementSystem.demo.Repository;

import com.hospitalManagementSystem.demo.Entity.Nurses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NursesRepository extends JpaRepository<Nurses,Long> {

}
