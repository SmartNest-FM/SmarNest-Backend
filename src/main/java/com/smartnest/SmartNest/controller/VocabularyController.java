package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.Vocabulary;
import com.smartnest.SmartNest.service.UserService;
import com.smartnest.SmartNest.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VocabularyController {
    @Autowired
    private VocabularyService vocabularyService;

    @RequestMapping(value = "/vocabulary",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllVocabulary(){
        return new ResponseEntity<>(vocabularyService.getAllVocabulary(), HttpStatus.OK);
    }
    @PostMapping(value = "/vocabulary")
    public ResponseEntity<Object> createVocabulary(@RequestBody Vocabulary vocabulary){
        vocabularyService.createVocabulary(vocabulary);
        return new ResponseEntity<>("Vocabulary is created successfully with id = " + vocabulary.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vocabulary/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateVocabulary(@PathVariable("id") int id, @RequestBody Vocabulary vocabulary) {
        boolean  isExist = vocabularyService.isVocabularyExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            vocabulary.setId(id);
            vocabularyService.updateVocabulary(vocabulary);
            return new ResponseEntity<>("Vocabulary is updated successfully", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/vocabulary/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteVocabulary(@PathVariable("id") int id) {
        boolean  isExist = vocabularyService.isVocabularyExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            vocabularyService.deleteVocabulary(id);
            return new ResponseEntity<>("Vocabulary is deleted successfully", HttpStatus.OK);
        }
    }

}
