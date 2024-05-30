package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.Feedback;
import com.smartnest.SmartNest.repository.FeedbackRepository;
import com.smartnest.SmartNest.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    @Override
    public Feedback updateFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    @Override
    public Feedback getFeedbackById(int id) {
        return feedbackRepository.findById(id).get();
    }
    @Override
    public List<Feedback> getAllFeedbacks() {
        return (List<Feedback>) feedbackRepository.findAll();
    }
    @Override
    public void deleteFeedback(int id) {
        feedbackRepository.deleteById(id);
    }
    @Override
    public boolean isFeedbackExist(int id) {
        return feedbackRepository.existsById(id);
    }
}
