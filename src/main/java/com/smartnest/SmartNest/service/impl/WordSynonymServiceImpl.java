package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.VocabularyVerb;
import com.smartnest.SmartNest.model.WordSynonym;
import com.smartnest.SmartNest.repository.VocabularyRepository;
import com.smartnest.SmartNest.repository.VocabularyVerbRepository;
import com.smartnest.SmartNest.repository.WordSynonymRepository;
import com.smartnest.SmartNest.service.WordSynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSynonymServiceImpl implements WordSynonymService {
    @Autowired
    private WordSynonymRepository wordSynonymRepository;
    @Override
    public WordSynonym createWordSynonym(WordSynonym wordSynonym) {
        return wordSynonymRepository.save(wordSynonym);
    }
    @Override
    public WordSynonym updateWordSynonym(WordSynonym wordSynonym) {
        return wordSynonymRepository.save(wordSynonym);
    }
    @Override
    public WordSynonym getWordSynonymById(int id) {
        return wordSynonymRepository.findById(id).get();
    }
    @Override
    public List<WordSynonym> getAllWordSynonyms() {
        return (List<WordSynonym>) wordSynonymRepository.findAll();
    }
    @Override
    public void deleteWordSynonym(int id) {
        wordSynonymRepository.deleteById(id);
    }
    @Override
    public boolean isWordSynonymExist(int id) {
        return wordSynonymRepository.existsById(id);
    }

}
