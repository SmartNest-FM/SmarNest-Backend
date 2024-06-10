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

    Feedback createFeedbackWithPhonologicalAwareness(int phonologicalAwarenessId, String feedbackText, String imagePath);
    Feedback createFeedbackWithFluentReading(int fluentReadingId, String feedbackText, String imagePath);

    Feedback createFeedbackWithReadingComprehension(int readingComprehensionId, String feedbackText, String imagePath);

    Feedback createFeedbackWithVocabularyVerb(int vocabularyVerbId, String feedbackText, String imagePath);

    Feedback createFeedbackWithCombinationReadingImages(int combinationReadingImagesId, String feedbackText, String imagePath);

    List<Feedback> getFeedbackByPhonologicalAwareness(int phonologicalAwarenessId);
    List<Feedback> getFeedbackByFluentReading(int fluentReadingId);
    List<Feedback> getFeedbackByVocabularyVerb(int vocabularyVerbId);

    List<Feedback> getFeedbackByReadingComprehension(int readingComprehensionId);
    List<Feedback> getFeedbackByCombinationReadingImages(int combinationReadingImagesId);

}
