package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.FluentReading;
import com.smartnest.SmartNest.service.FluentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FluentReadingController {
    @Autowired
    FluentReadingService fluentReadingService;

    @RequestMapping(value = "/fluentReading", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllReadingComprehension() {
        return new ResponseEntity<>(fluentReadingService.getAllFluentReadings(), HttpStatus.OK);
    }

   @PostMapping(value = "/fluentReading")
    public ResponseEntity<Object> createLevel(@RequestBody FluentReading fluentReading) {
        fluentReadingService.createFluentReading(fluentReading);
        return new ResponseEntity<>("FluentReading is created successfully with id = " + fluentReading.getId(), HttpStatus.CREATED);
    }





    @RequestMapping(value = "/fluentReading/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFluentReadingById(@PathVariable("id") int id) {
        boolean  isExist = fluentReadingService.isFluentReadingExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            FluentReading fluentReading = fluentReadingService.getFluentReadingById(id);
            return new ResponseEntity<>(fluentReading, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/fluentReading/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFluentReading(@PathVariable("id") int id, @RequestBody FluentReading fluentReading) {
        boolean  isExist = fluentReadingService.isFluentReadingExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            fluentReading.setId(id);
            fluentReadingService.updateFluentReading(fluentReading);
            return new ResponseEntity<>("FluentReading is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/fluentReading/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFluentReading(@PathVariable("id") int id) {
        boolean  isExist = fluentReadingService.isFluentReadingExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            fluentReadingService.deleteFluentReading(id);
            return new ResponseEntity<>("FluentReading is deleted successfully", HttpStatus.OK);
        }
    }
}
