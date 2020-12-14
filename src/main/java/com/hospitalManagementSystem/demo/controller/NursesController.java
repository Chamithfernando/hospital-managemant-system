package com.hospitalManagementSystem.demo.controller;

import com.hospitalManagementSystem.demo.Entity.Nurses;
import com.hospitalManagementSystem.demo.Repository.NursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NursesController {

    @Autowired
    private NursesRepository nursesRepository;

    public NursesController(NursesRepository nursesRepository) {
        this.nursesRepository = nursesRepository;
    }

    @GetMapping("/all")
    Collection<Nurses> getAll(){
        return nursesRepository.findAll();
    }

    @GetMapping("/all/{nursesId}")
    ResponseEntity<Nurses> findById(@PathVariable Long nursesId) {
        Optional<Nurses> result = nursesRepository.findById(nursesId);
        return result.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    ResponseEntity<Nurses> addNewNurses(@Validated @RequestBody Nurses nurses)throws URISyntaxException{
        Nurses savedNurses = nursesRepository.save(nurses);
        return ResponseEntity
                .created(new URI("nurses/add"+ savedNurses.getNursesId())).body(savedNurses);
    }

    @PutMapping("/update/{nursesId}")
    ResponseEntity<Nurses> updateNurses(@Validated @RequestBody Nurses nurses){
        Nurses saveNurses = nursesRepository.save(nurses);
        return ResponseEntity.ok().body(saveNurses);
    }
    }
