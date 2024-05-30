package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User is created successfully with id = " + user.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        boolean  isExist = userService.isUserExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            user.setId(id);
            userService.updateUser(user);
            return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable("id") int id) {
        boolean  isExist = userService.isUserExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
        boolean  isExist = userService.isUserExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            userService.deleteUser(id);
            return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
        }
    }
}
