package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.model.Vocabulary;
import com.smartnest.SmartNest.repository.UserRepository;
import com.smartnest.SmartNest.repository.VocabularyRepository;
import com.smartnest.SmartNest.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyServiceImpl implements VocabularyService {
    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Override
    public Vocabulary createVocabulary(Vocabulary vocabulary) { return vocabularyRepository.save(vocabulary); }

    @Override
    public Vocabulary updateVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }

    @Override
    public Vocabulary getVocabularyById(int id) {  return vocabularyRepository.findById(id).get(); }

    @Override
    public List<Vocabulary> getAllVocabulary() { return (List<Vocabulary>) vocabularyRepository.findAll(); }

    @Override
    public void deleteVocabulary(int id) {
        vocabularyRepository.deleteById(id);
    }

    @Override
    public boolean isVocabularyExist(int id) {
        return vocabularyRepository.existsById(id);
    }
}
