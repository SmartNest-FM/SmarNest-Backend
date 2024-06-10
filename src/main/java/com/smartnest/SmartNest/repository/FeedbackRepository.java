package com.smartnest.SmartNest.repository;

import com.smartnest.SmartNest.model.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

    List<Feedback> findByPhonologicalAwarenessId(int phonologicalAwarenessId);
    List<Feedback> findByFluentReadingId(int fluentReadingId);
    List<Feedback> findByVocabularyVerbId(int vocabularyVerbId);
    List<Feedback> findByReadingComprehensionId(int readingComprehensionId);
    List<Feedback> findByCombinationReadingImagesId(int combinationReadingImagesId);

}
