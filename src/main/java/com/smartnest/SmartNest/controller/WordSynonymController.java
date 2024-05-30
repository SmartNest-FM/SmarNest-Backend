package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.VocabularyVerb;
import com.smartnest.SmartNest.model.WordSynonym;
import com.smartnest.SmartNest.service.VocabularyVerbService;
import com.smartnest.SmartNest.service.WordSynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordSynonymController {
    @Autowired
    WordSynonymService wordSynonymService;

    @RequestMapping(value = "/wordSynonym", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllWordSynonyms() {
        return new ResponseEntity<>(wordSynonymService.getAllWordSynonyms(), HttpStatus.OK);
    }

    @PostMapping(value = "/wordSynonym")
    public ResponseEntity<Object> createWordSynonym(@RequestBody WordSynonym wordSynonym) {
        wordSynonymService.createWordSynonym(wordSynonym);
        return new ResponseEntity<>("wordSynonym is created successfully with id = " + wordSynonym.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getWordSynonymById(@PathVariable("id") int id) {
        boolean isExist = wordSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            WordSynonym wordSynonym = wordSynonymService.getWordSynonymById(id);
            return new ResponseEntity<>(wordSynonym, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWordSynonym(@PathVariable("id") int id, @RequestBody WordSynonym wordSynonym) {
        boolean isExist = wordSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            wordSynonym.setId(id);
            wordSynonymService.updateWordSynonym(wordSynonym);
            return new ResponseEntity<>("wordSynonym is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/wordSynonym/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWordSynonym(@PathVariable("id") int id) {
        boolean isExist = wordSynonymService.isWordSynonymExist(id);
        if (!isExist) {
            throw new UserNotFoundException();
        } else {
            wordSynonymService.deleteWordSynonym(id);
            return new ResponseEntity<>("wordSynonym is deleted successfully", HttpStatus.OK);
        }
    }
}
