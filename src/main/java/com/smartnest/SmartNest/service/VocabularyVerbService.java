package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.VocabularyVerb;

import java.util.List;

public interface VocabularyVerbService {
    VocabularyVerb createVocabularyVerb(VocabularyVerb vocabularyVerb);
    VocabularyVerb updateVocabularyVerb(VocabularyVerb vocabularyVerb);
    VocabularyVerb getVocabularyVerbById(int id);
    List<VocabularyVerb> getAllVocabularyVerbs();
    void deleteVocabularyVerb(int id);
    boolean isVocabularyVerbExist(int id);
}
