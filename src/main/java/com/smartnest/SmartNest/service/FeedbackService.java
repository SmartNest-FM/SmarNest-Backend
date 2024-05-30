package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);
    Feedback updateFeedback(Feedback feedback);
    Feedback getFeedbackById(int id);
    List<Feedback> getAllFeedbacks();
    void deleteFeedback(int id);
    boolean isFeedbackExist(int id);
}
