package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.model.UserProgress;
import com.smartnest.SmartNest.service.UserProgressService;
import com.smartnest.SmartNest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProgressController {

    @Autowired
    private UserProgressService userProgressService;

    @RequestMapping(value = "/userProgress", method = RequestMethod.POST)
    public ResponseEntity<Object> createUserProgress(@RequestBody UserProgress userProgress){
        userProgressService.createUserProgress(userProgress);
        return new ResponseEntity<>("UserProgress is created successfully with id = " + userProgress.getId(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/userProgress/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUserProgress(@PathVariable("id") int id, @RequestBody UserProgress userProgress) {
        boolean  isExist = userProgressService.isUserProgressExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            userProgress.setId(id);
            userProgressService.updateUserProgress(userProgress);
            return new ResponseEntity<>("UserProgress is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/userProgress/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserProgressById(@PathVariable("id") int id) {
        boolean  isExist = userProgressService.isUserProgressExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            UserProgress userProgress = userProgressService.getUserProgressById(id);
            return new ResponseEntity<>(userProgress, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/userProgress", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUserProgresses() {
        return new ResponseEntity<>(userProgressService.getAllUserProgresses(), HttpStatus.OK);
    }


    @RequestMapping(value = "/userProgress/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserProgress(@PathVariable("id") int id) {
        boolean  isExist = userProgressService.isUserProgressExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            userProgressService.deleteUserProgress(id);
            return new ResponseEntity<>("UserProgress is deleted successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/userProgress/by-uid/{uid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserProgressByUid(@PathVariable("uid") String uid) {
        List<UserProgress> userProgressList = userProgressService.findByUser_Uid(uid);
        if (userProgressList == null) {
            throw new UserNotFoundException();
        }
        return new ResponseEntity<>(userProgressList, HttpStatus.OK);
    }



}
