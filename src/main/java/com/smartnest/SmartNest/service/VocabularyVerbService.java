package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.VerbSynonym;
import com.smartnest.SmartNest.model.VocabularyVerb;

import java.util.List;
import java.util.Optional;

public interface VocabularyVerbService {
    VocabularyVerb createVocabularyVerb(VocabularyVerb vocabularyVerb);
    VocabularyVerb updateVocabularyVerb(VocabularyVerb vocabularyVerb);
    VocabularyVerb getVocabularyVerbById(int id);
    List<VocabularyVerb> getAllVocabularyVerbs();
    void deleteVocabularyVerb(int id);
    boolean isVocabularyVerbExist(int id);

    Optional<VocabularyVerb> findById(int id);
}
