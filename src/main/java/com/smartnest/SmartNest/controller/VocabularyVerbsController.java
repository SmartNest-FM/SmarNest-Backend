package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.VocabularyVerb;
import com.smartnest.SmartNest.service.VocabularyVerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VocabularyVerbsController {
    @Autowired
    VocabularyVerbService vocabularyVerbService;

    @RequestMapping(value = "/vocabularyVerb", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllVocabularyVerbs() {
        return new ResponseEntity<>(vocabularyVerbService.getAllVocabularyVerbs(), HttpStatus.OK);
    }

    @PostMapping(value = "/vocabularyVerb")
public ResponseEntity<Object> createVocabularyVerb(@RequestBody VocabularyVerb vocabularyVerb) {
        vocabularyVerbService.createVocabularyVerb(vocabularyVerb);
        return new ResponseEntity<>("vocabularyVerb is created successfully with id = " + vocabularyVerb.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/vocabularyVerb/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getVocabularyVerbById(@PathVariable("id") int id) {
        boolean  isExist = vocabularyVerbService.isVocabularyVerbExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            VocabularyVerb vocabularyVerb = vocabularyVerbService.getVocabularyVerbById(id);
            return new ResponseEntity<>(vocabularyVerb, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/vocabularyVerb/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateVocabularyVerb(@PathVariable("id") int id, @RequestBody VocabularyVerb vocabularyVerb) {
        boolean  isExist = vocabularyVerbService.isVocabularyVerbExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            vocabularyVerb.setId(id);
            vocabularyVerbService.updateVocabularyVerb(vocabularyVerb);
            return new ResponseEntity<>("vocabularyVerb is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/vocabularyVerb/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteVocabularyVerb(@PathVariable("id") int id) {
        boolean  isExist = vocabularyVerbService.isVocabularyVerbExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            vocabularyVerbService.deleteVocabularyVerb(id);
            return new ResponseEntity<>("vocabularyVerb is deleted successfully", HttpStatus.OK);
        }
    }

}
