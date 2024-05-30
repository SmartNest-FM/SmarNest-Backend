package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.WordSynonym;

import java.util.List;

public interface WordSynonymService {
    WordSynonym createWordSynonym(WordSynonym wordSynonym);
    WordSynonym updateWordSynonym(WordSynonym wordSynonym);
    WordSynonym getWordSynonymById(int id);
    List<WordSynonym> getAllWordSynonyms();
    void deleteWordSynonym(int id);
    boolean isWordSynonymExist(int id);
}
