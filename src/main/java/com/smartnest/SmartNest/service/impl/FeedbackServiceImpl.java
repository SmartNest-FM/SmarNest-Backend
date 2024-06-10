package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.*;
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

    @Override
    public Feedback createFeedbackWithPhonologicalAwareness(int phonologicalAwarenessId, String feedbackText, String imagePath) {
        PhonologicalAwareness pa = new PhonologicalAwareness();
        pa.setId(phonologicalAwarenessId);

        Feedback feedback = new Feedback();
        feedback.setFeedback(feedbackText);
        feedback.setImage(imagePath);
        feedback.setPhonologicalAwareness(pa);

        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback createFeedbackWithFluentReading(int fluentReadingId, String feedbackText, String imagePath) {
        FluentReading fr = new FluentReading();
        fr.setId(fluentReadingId);

        Feedback feedback = new Feedback();
        feedback.setFeedback(feedbackText);
        feedback.setImage(imagePath);
        feedback.setFluentReading(fr);

        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback createFeedbackWithReadingComprehension(int readingComprehensionId, String feedbackText, String imagePath) {
        ReadingComprehension rc = new ReadingComprehension();
        rc.setId(readingComprehensionId);

        Feedback feedback = new Feedback();
        feedback.setFeedback(feedbackText);
        feedback.setImage(imagePath);
        feedback.setReadingComprehension(rc);

        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback createFeedbackWithVocabularyVerb(int vocabularyVerbId, String feedbackText, String imagePath) {
        VocabularyVerb vv = new VocabularyVerb();
        vv.setId(vocabularyVerbId);

        Feedback feedback = new Feedback();
        feedback.setFeedback(feedbackText);
        feedback.setImage(imagePath);
        feedback.setVocabularyVerb(vv);

        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback createFeedbackWithCombinationReadingImages(int combinationReadingImagesId, String feedbackText, String imagePath) {
        CombinationReadingImages cri = new CombinationReadingImages();
        cri.setId(combinationReadingImagesId);

        Feedback feedback = new Feedback();
        feedback.setFeedback(feedbackText);
        feedback.setImage(imagePath);
        feedback.setCombinationReadingImages(cri);

        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByPhonologicalAwareness(int phonologicalAwarenessId) {
        return feedbackRepository.findByPhonologicalAwarenessId(phonologicalAwarenessId);
    }

    @Override
    public List<Feedback> getFeedbackByFluentReading(int fluentReadingId) {
        return feedbackRepository.findByFluentReadingId(fluentReadingId);
    }

    @Override
    public List<Feedback> getFeedbackByVocabularyVerb(int vocabularyVerbId) {
        return feedbackRepository.findByVocabularyVerbId(vocabularyVerbId);
    }

    @Override
    public List<Feedback> getFeedbackByReadingComprehension(int readingComprehensionId) {
        return feedbackRepository.findByReadingComprehensionId(readingComprehensionId);
    }

    @Override
    public List<Feedback> getFeedbackByCombinationReadingImages(int combinationReadingImagesId) {
        return feedbackRepository.findByCombinationReadingImagesId(combinationReadingImagesId);
    }
}
