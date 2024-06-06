package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.VerbSynonym;
import com.smartnest.SmartNest.service.VerbSynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerbSynonymController {
    @Autowired
    VerbSynonymService verbSynonymService;

    @RequestMapping(value = "/wordSynonym", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllWordSynonyms() {
        return new ResponseEntity<>(verbSynonymService.getAllWordSynonyms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/wordSynonym", method = RequestMethod.POST)
    public ResponseEntity<Object> createWordSynonym(@RequestBody VerbSynonym verbSynonym) {
        verbSynonymService.createWordSynonym(verbSynonym);
        return new ResponseEntity<>("wordSynonym is created successfully with id = " + verbSynonym.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getWordSynonymById(@PathVariable("id") int id) {
        boolean isExist = verbSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            VerbSynonym verbSynonym = verbSynonymService.getWordSynonymById(id);
            return new ResponseEntity<>(verbSynonym, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWordSynonym(@PathVariable("id") int id, @RequestBody VerbSynonym verbSynonym) {
        boolean isExist = verbSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            verbSynonym.setId(id);
            verbSynonymService.updateWordSynonym(verbSynonym);
            return new ResponseEntity<>("wordSynonym is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWordSynonym(@PathVariable("id") int id) {
        boolean isExist = verbSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            verbSynonymService.deleteWordSynonym(id);
            return new ResponseEntity<>("wordSynonym is deleted successfully", HttpStatus.OK);
        }
    }
}
