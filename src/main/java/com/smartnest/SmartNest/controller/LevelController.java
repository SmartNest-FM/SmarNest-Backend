package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.Level;
import com.smartnest.SmartNest.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LevelController {
    @Autowired
    private LevelService levelService;

    @RequestMapping(value = "/level", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllLevels() {
        return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);
    }

    @RequestMapping(value = "/level", method = RequestMethod.POST)
    public ResponseEntity<Object> createLevel(@RequestBody Level level) {
        levelService.createLevel(level);
        return new ResponseEntity<>("Level is created successfully with id = " + level.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/level/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getLevelById(@PathVariable("id") int id) {
        boolean  isExist = levelService.isLevelExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            Level level = levelService.getLevelById(id);
            return new ResponseEntity<>(level, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/level/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateLevel(@PathVariable("id") int id, @RequestBody Level level) {
        boolean  isExist = levelService.isLevelExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            level.setId(id);
            levelService.updateLevel(level);
            return new ResponseEntity<>("Level is updated successfully", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/level/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLevel(@PathVariable("id") int id) {
        boolean  isExist = levelService.isLevelExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            levelService.deleteLevel(id);
            return new ResponseEntity<>("Level is deleted successfully", HttpStatus.OK);
        }
    }
}
