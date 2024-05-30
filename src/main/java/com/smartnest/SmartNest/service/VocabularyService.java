package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.Vocabulary;

import java.util.List;

public interface VocabularyService {
    Vocabulary createVocabulary(Vocabulary vocabulary);
    Vocabulary updateVocabulary(Vocabulary vocabulary);
    Vocabulary getVocabularyById(int id);
    List<Vocabulary> getAllVocabulary();
    void deleteVocabulary(int id);
    boolean isVocabularyExist(int id);
}
