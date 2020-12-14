package com.hospitalManagementSystem.demo.controller;


import com.hospitalManagementSystem.demo.Entity.Doctor;
import com.hospitalManagementSystem.demo.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/all")
    Collection<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/all/{doctorid}")
    ResponseEntity<?> getDoctorById( @PathVariable Long doctorid){
        Optional<Doctor> doctorResult = doctorRepository.findById(doctorid);
        return doctorResult.map(response ->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    ResponseEntity<Doctor> addDoctorList(@Validated @RequestBody Doctor doctor)
            throws URISyntaxException{
        Doctor savedRepo = doctorRepository.save(doctor);
        return ResponseEntity.created(new URI("doctor/add" + savedRepo.getDoctorid())).body(savedRepo);
    }


    @DeleteMapping("/delete/{doctorid}")
    ResponseEntity<Doctor> deleteDoctor(@PathVariable Long doctorid){
        doctorRepository.deleteById(doctorid);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{doctorid}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "doctorid") Long doctorid,
                                                   @Validated @RequestBody Doctor doctor) throws ResourceNotFoundException {
        Doctor doctor1 = doctorRepository.findById(doctorid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + doctorid));

        doctor1.setDoctorid(doctor.getDoctorid());
        doctor1.setDoctorName(doctor.getDoctorName());
        doctor1.setRegNo(doctor.getRegNo());
        doctor1.setWardNumber(doctor.getWardNumber());
        final Doctor updatedEmployee = doctorRepository.save(doctor1);
        return ResponseEntity.ok(updatedEmployee);
    }

    //    @PutMapping("/update/{doctorid}")
    //    ResponseEntity<Doctor> UpdateDoctor(@Validated @RequestBody Doctor doctor){
    //        Doctor UpdatedDoctor = doctorRepository.save(doctor);
    //        return ResponseEntity.ok().body(UpdatedDoctor);
    //    }


    //    @PostMapping("/update/{doctorid}")
    //    public ModelAndView updateDoctor(Doctor doctor){
    //        ModelAndView mdview = new ModelAndView();
    //        doctorRepository.save(doctor);
    //        mdview.addObject("successMessage", "Stock has been updated successfully");
    //        return mdview;
    //    }
}

