package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.PhonologicalAwareness;
import com.smartnest.SmartNest.service.PhonologicalAwarenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhonologicalAwarenessController {
    @Autowired
    private PhonologicalAwarenessService phonologicalAwarenessService;

    @RequestMapping(value = "/phonologicalAwareness", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPhonologicalAwareness() {
        return new ResponseEntity<>(phonologicalAwarenessService.getAllPhonologicalAwareness(), HttpStatus.OK);
    }

    @RequestMapping(value = "/phonologicalAwareness", method = RequestMethod.POST)
    public ResponseEntity<Object> createLevel(@RequestBody PhonologicalAwareness phonologicalAwareness) {
        phonologicalAwarenessService.createPhonologicalAwareness(phonologicalAwareness);
        return new ResponseEntity<>("PhonologicalAwareness is created successfully with id = " + phonologicalAwareness.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/phonologicalAwareness/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPhonologicalAwarenessById(@PathVariable("id") int id) {
        boolean  isExist = phonologicalAwarenessService.isPhonologicalAwarenessExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            PhonologicalAwareness phonologicalAwareness = phonologicalAwarenessService.getPhonologicalAwarenessById(id);
            return new ResponseEntity<>(phonologicalAwareness, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/phonologicalAwareness/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePhonologicalAwareness(@PathVariable("id") int id, @RequestBody PhonologicalAwareness phonologicalAwareness) {
        boolean  isExist = phonologicalAwarenessService.isPhonologicalAwarenessExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            phonologicalAwareness.setId(id);
            phonologicalAwarenessService.updatePhonologicalAwareness(phonologicalAwareness);
            return new ResponseEntity<>("PhonologicalAwareness is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/phonologicalAwareness/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePhonologicalAwareness(@PathVariable("id") int id) {
        boolean  isExist = phonologicalAwarenessService.isPhonologicalAwarenessExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            phonologicalAwarenessService.deletePhonologicalAwareness(id);
            return new ResponseEntity<>("PhonologicalAwareness is deleted successfully", HttpStatus.OK);
        }
    }

}
