package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.VerbSynonym;
import com.smartnest.SmartNest.repository.VerbSynonymRepository;
import com.smartnest.SmartNest.service.VerbSynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerbSynonymServiceImpl implements VerbSynonymService {
    @Autowired
    private VerbSynonymRepository verbSynonymRepository;
    @Override
    public VerbSynonym createWordSynonym(VerbSynonym verbSynonym) {
        return verbSynonymRepository.save(verbSynonym);
    }
    @Override
    public VerbSynonym updateWordSynonym(VerbSynonym verbSynonym) {
        return verbSynonymRepository.save(verbSynonym);
    }
    @Override
    public VerbSynonym getWordSynonymById(int id) {
        return verbSynonymRepository.findById(id).get();
    }
    @Override
    public List<VerbSynonym> getAllWordSynonyms() {
        return (List<VerbSynonym>) verbSynonymRepository.findAll();
    }
    @Override
    public void deleteWordSynonym(int id) {
        verbSynonymRepository.deleteById(id);
    }
    @Override
    public boolean isWordSynonymExist(int id) {
        return verbSynonymRepository.existsById(id);
    }

}
