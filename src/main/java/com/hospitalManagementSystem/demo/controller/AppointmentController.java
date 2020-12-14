package com.hospitalManagementSystem.demo.controller;


import com.hospitalManagementSystem.demo.Entity.Appointment;
import com.hospitalManagementSystem.demo.Repository.AppointmentRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
    }

//    @GetMapping("/all")
//    Collection<Appointment> appointments(){
//        return appointmentRepository.findAll();
//    }
//

    @GetMapping("/all")
    public List<Appointment> getAllApointment(){
        return appointmentRepository.findAll();
    }


    @GetMapping("/all/{appointmenterId}")
    ResponseEntity<?> getAppointment(@PathVariable int appointmenterId){
        Optional<Appointment> appointment = appointmentRepository.findById(appointmenterId);
        return appointment.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    ResponseEntity<Appointment> addAppointment(@Validated @RequestBody Appointment appointment)throws URISyntaxException{
        Appointment result = appointmentRepository.save(appointment);
        return ResponseEntity.created(new URI("appointment/add" + result.getAppointmenterId())).body(result);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateEmployee(@PathVariable(value = "id") int appointmenterId,
                                                   @Validated @RequestBody Appointment appointments) throws ResourceNotFoundException {
        Appointment result = appointmentRepository.findById(appointmenterId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmenterId));

        result.setAppointmenterId(appointments.getAppointmenterId());
        result.setAppointmenterName(appointments.getAppointmenterName());
        result.setAppointmentDate(appointments.getAppointmentDate());
        final Appointment updatedAppoints = appointmentRepository.save(result);
        return ResponseEntity.ok(updatedAppoints);
    }

//    @PutMapping("/update/{appointmenterId}")
//    ResponseEntity<Appointment> updateAppointment(@Validated @RequestBody Appointment appointment){
//        Appointment result = appointmentRepository.save(appointment);
//        return ResponseEntity.ok().body(result);
//    }

    @DeleteMapping("/delete/{appointmenterId}")
    ResponseEntity<Appointment> deleteAppointment( @PathVariable int appointmenterId){
        appointmentRepository.deleteById(appointmenterId);
        return ResponseEntity.ok().build();
    }


//    @DeleteMapping("/delete/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int appointmenterId)
//            throws ResourceNotFoundException {
//        Appointment result = appointmentRepository.findById(appointmenterId)
//                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + appointmenterId));
//
//        appointmentRepository.delete(result);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }


    }

