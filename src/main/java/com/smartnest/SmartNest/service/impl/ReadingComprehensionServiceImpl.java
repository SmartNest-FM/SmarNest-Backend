package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.PhonologicalAwareness;
import com.smartnest.SmartNest.model.ReadingComprehension;
import com.smartnest.SmartNest.repository.PhonologicalAwarenessRepository;
import com.smartnest.SmartNest.repository.ReadingComprehensionRepository;
import com.smartnest.SmartNest.service.ReadingComprehensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingComprehensionServiceImpl implements ReadingComprehensionService {
    @Autowired
    private ReadingComprehensionRepository readingComprehensionRepository;
    @Override
    public ReadingComprehension createReadingComprehension(ReadingComprehension readingComprehension) {
        return readingComprehensionRepository.save(readingComprehension);
    }
    @Override
    public ReadingComprehension updateReadingComprehension(ReadingComprehension readingComprehension) {
        return readingComprehensionRepository.save(readingComprehension);
    }
    @Override
    public ReadingComprehension getReadingComprehensionById(int id) {
        return readingComprehensionRepository.findById(id).get();
    }
    @Override
    public List<ReadingComprehension> getAllReadingComprehensions() {
        return (List<ReadingComprehension>) readingComprehensionRepository.findAll();
    }
    @Override
    public void deleteReadingComprehension(int id) {
        readingComprehensionRepository.deleteById(id);
    }
    @Override
    public boolean isReadingComprehensionExist(int id) {
        return readingComprehensionRepository.existsById(id);
    }

}
