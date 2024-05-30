package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.VocabularyVerb;
import com.smartnest.SmartNest.repository.VocabularyVerbRepository;
import com.smartnest.SmartNest.service.VocabularyVerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyVerbServiceImpl implements VocabularyVerbService {
    @Autowired
    private VocabularyVerbRepository vocabularyVerbRepository;
    @Override
    public VocabularyVerb createVocabularyVerb(VocabularyVerb vocabularyVerb) {
        return vocabularyVerbRepository.save(vocabularyVerb);
    }
    @Override
    public VocabularyVerb updateVocabularyVerb(VocabularyVerb vocabularyVerb) {
        return vocabularyVerbRepository.save(vocabularyVerb);
    }
    @Override
    public VocabularyVerb getVocabularyVerbById(int id) {
        return vocabularyVerbRepository.findById(id).get();
    }
    @Override
    public List<VocabularyVerb> getAllVocabularyVerbs() {
        return (List<VocabularyVerb>) vocabularyVerbRepository.findAll();
    }
    @Override
    public void deleteVocabularyVerb(int id) {
        vocabularyVerbRepository.deleteById(id);
    }
    @Override
    public boolean isVocabularyVerbExist(int id) {
        return vocabularyVerbRepository.existsById(id);
    }

}
