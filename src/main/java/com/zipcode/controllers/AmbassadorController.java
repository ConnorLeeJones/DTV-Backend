package com.zipcode.controllers;


import com.zipcode.exceptions.AmbassadorNotFoundException;
import com.zipcode.models.Ambassador;
import com.zipcode.services.AmbassadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AmbassadorController {


    private AmbassadorService ambassadorService;

    @Autowired
    public AmbassadorController(AmbassadorService ambassadorService) {
        this.ambassadorService = ambassadorService;
    }

    @PostMapping("/ambassador/create")
    public ResponseEntity<Boolean> newAmbassador(@RequestBody Ambassador ambassador) {
        ambassadorService.newAmbassador(ambassador);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/ambassador/delete/{id}")
    public ResponseEntity<Boolean> deleteAmbassador(@PathVariable Long id) {
        if (!ambassadorService.ambassadorExists(id)) {
            throw new AmbassadorNotFoundException();
        }
        ambassadorService.deleteAmbassador(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/ambassador/update/{id}")
    public ResponseEntity<Boolean> updateAmbassador(@PathVariable Long id, @RequestBody Ambassador ambassador) {
        if (!ambassadorService.ambassadorExists(id)) {
            throw new AmbassadorNotFoundException();
        }
        ambassadorService.updateAmbassador(id, ambassador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ambassador/{id}")
    public ResponseEntity<Ambassador> findById(@PathVariable Long id) {
        if (!ambassadorService.ambassadorExists(id)) {
            throw new AmbassadorNotFoundException();
        }
        return new ResponseEntity<>(ambassadorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/ambassadors")
    public ResponseEntity<Iterable<Ambassador>> findAll() {
        return new ResponseEntity<>(ambassadorService.findAllAmbassadors(), HttpStatus.OK);
    }

    @GetMapping("/ambassadors/name/{firstName}")
    public ResponseEntity<Iterable<Ambassador>> findAllByFirstName(@PathVariable String firstName) {
        Iterable<Ambassador> ambassadors = ambassadorService.findAllAmbassadorsByFirstName(firstName);
        if (ambassadors == null) {
            throw new AmbassadorNotFoundException();
        }
        return new ResponseEntity<>(ambassadors, HttpStatus.OK);
    }

    @GetMapping("ambassadors/last/{lastName}")
    public ResponseEntity<Iterable<Ambassador>> findAllByLastName(@PathVariable String lastName) {
        Iterable<Ambassador> ambassadors = ambassadorService.findAllAmbassadorsByLastName(lastName);
        if (ambassadors == null) {
            throw new AmbassadorNotFoundException();
        }
        return new ResponseEntity<>(ambassadors, HttpStatus.OK);
    }


}
