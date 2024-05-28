package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.ReadingComprehension;
import com.smartnest.SmartNest.service.ReadingComprehensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReadingComprehensionController {
    @Autowired
    ReadingComprehensionService readingComprehensionService;

    @RequestMapping(value = "/readingComprehension", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllReadingComprehension() {
        return new ResponseEntity<>(readingComprehensionService.getAllReadingComprehensions(), HttpStatus.OK);
    }

    @PostMapping(value = "/readingComprehension")
    public ResponseEntity<Object> createLevel(@RequestBody ReadingComprehension readingComprehension) {
        readingComprehensionService.createReadingComprehension(readingComprehension);
        return new ResponseEntity<>("ReadingComprehension is created successfully with id = " + readingComprehension.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/readingComprehension/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getReadingComprehensionById(@PathVariable("id") int id) {
        boolean  isExist = readingComprehensionService.isReadingComprehensionExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            ReadingComprehension readingComprehension = readingComprehensionService.getReadingComprehensionById(id);
            return new ResponseEntity<>(readingComprehension, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/readingComprehension/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateReadingComprehension(@PathVariable("id") int id, @RequestBody ReadingComprehension readingComprehension) {
        boolean  isExist = readingComprehensionService.isReadingComprehensionExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            readingComprehension.setId(id);
            readingComprehensionService.updateReadingComprehension(readingComprehension);
            return new ResponseEntity<>("ReadingComprehension is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/readingComprehension/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReadingComprehension(@PathVariable("id") int id) {
        boolean  isExist = readingComprehensionService.isReadingComprehensionExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            readingComprehensionService.deleteReadingComprehension(id);
            return new ResponseEntity<>("ReadingComprehension is deleted successfully", HttpStatus.OK);
        }
    }


}
