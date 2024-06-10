package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.Feedback;
import com.smartnest.SmartNest.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/phonological", method = RequestMethod.POST)
    public ResponseEntity<Feedback> createFeedbackWithPhonologicalAwareness(@RequestParam int phonologicalAwarenessId, @RequestParam String feedbackText, @RequestParam String imagePath) {
        Feedback feedback = feedbackService.createFeedbackWithPhonologicalAwareness(phonologicalAwarenessId, feedbackText, imagePath);
        return ResponseEntity.ok(feedback);
    }

    @RequestMapping(value = "/fluent", method = RequestMethod.POST)
    public ResponseEntity<Feedback> createFeedbackWithFluentReading(@RequestParam int fluentReadingId, @RequestParam String feedbackText, @RequestParam String imagePath) {
        Feedback feedback = feedbackService.createFeedbackWithFluentReading(fluentReadingId, feedbackText, imagePath);
        return ResponseEntity.ok(feedback);
    }

    @RequestMapping(value = "/reading", method = RequestMethod.POST)
    public ResponseEntity<Feedback> createFeedbackWithReadingComprehension(@RequestParam int readingComprehensionId, @RequestParam String feedbackText, @RequestParam String imagePath) {
        Feedback feedback = feedbackService.createFeedbackWithReadingComprehension(readingComprehensionId, feedbackText, imagePath);
        return ResponseEntity.ok(feedback);
    }

    @RequestMapping(value = "/vocabulary", method = RequestMethod.POST)
    public ResponseEntity<Feedback> createFeedbackWithVocabularyVerb(@RequestParam int vocabularyVerbId, @RequestParam String feedbackText, @RequestParam String imagePath) {
        Feedback feedback = feedbackService.createFeedbackWithVocabularyVerb(vocabularyVerbId, feedbackText, imagePath);
        return ResponseEntity.ok(feedback);
    }

    @RequestMapping(value = "/combination", method = RequestMethod.POST)
    public ResponseEntity<Feedback> createFeedbackWithCombinationReadingImages(@RequestParam int combinationReadingImagesId, @RequestParam String feedbackText, @RequestParam String imagePath) {
        Feedback feedback = feedbackService.createFeedbackWithCombinationReadingImages(combinationReadingImagesId, feedbackText, imagePath);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping("/phonological/{id}")
    public ResponseEntity<List<Feedback>> getFeedbackByPhonologicalAwareness(@PathVariable int id) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByPhonologicalAwareness(id);
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/fluent/{id}")
    public ResponseEntity<List<Feedback>> getFeedbackByFluentReading(@PathVariable int id) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByFluentReading(id);
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/vocabulary/{id}")
    public ResponseEntity<List<Feedback>> getFeedbackByVocabularyVerb(@PathVariable int id) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByVocabularyVerb(id);
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/reading/{id}")
    public ResponseEntity<List<Feedback>> getFeedbackByReadingComprehension(@PathVariable int id) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByReadingComprehension(id);
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/combination/{id}")
    public ResponseEntity<List<Feedback>> getFeedbackByCombinationReadingImages(@PathVariable int id) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByCombinationReadingImages(id);
        return ResponseEntity.ok(feedbackList);
    }

}
