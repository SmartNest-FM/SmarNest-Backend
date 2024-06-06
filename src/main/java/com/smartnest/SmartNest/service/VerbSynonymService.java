package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.VerbSynonym;

import java.util.List;

public interface VerbSynonymService {
    VerbSynonym createWordSynonym(VerbSynonym verbSynonym);
    VerbSynonym updateWordSynonym(VerbSynonym verbSynonym);
    VerbSynonym getWordSynonymById(int id);
    List<VerbSynonym> getAllWordSynonyms();
    void deleteWordSynonym(int id);
    boolean isWordSynonymExist(int id);
}
