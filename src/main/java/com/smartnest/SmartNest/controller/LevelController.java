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

    @PostMapping(value = "/level")
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
}
