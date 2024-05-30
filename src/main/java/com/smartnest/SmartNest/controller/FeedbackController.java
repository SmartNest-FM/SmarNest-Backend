package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.Feedback;
import com.smartnest.SmartNest.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllFeedbacks() {
        return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ResponseEntity<Object> createFeedback(@RequestBody Feedback feedback) {
        feedbackService.createFeedback(feedback);
        return new ResponseEntity<>("Feedback is created successfully with id = " + feedback.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFeedbackById(@PathVariable("id") int id) {
        boolean  isExist = feedbackService.isFeedbackExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            Feedback feedback = feedbackService.getFeedbackById(id);
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFeedback(@PathVariable("id") int id, @RequestBody Feedback feedback) {
        boolean  isExist = feedbackService.isFeedbackExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            feedback.setId(id);
            feedbackService.updateFeedback(feedback);
            return new ResponseEntity<>("Feedback is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFeedback(@PathVariable("id") int id) {
        boolean  isExist = feedbackService.isFeedbackExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            feedbackService.deleteFeedback(id);
            return new ResponseEntity<>("Feedback is deleted successfully", HttpStatus.OK);
        }
    }

}
