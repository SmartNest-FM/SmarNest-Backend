package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.Level;
import com.smartnest.SmartNest.model.PhonologicalAwareness;
import com.smartnest.SmartNest.repository.LevelRepository;
import com.smartnest.SmartNest.repository.PhonologicalAwarenessRepository;
import com.smartnest.SmartNest.service.PhonologicalAwarenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonologicalAwarenessServiceImpl implements PhonologicalAwarenessService {
    @Autowired
    private PhonologicalAwarenessRepository phonologicalAwarenessRepository;
    @Override
    public PhonologicalAwareness createPhonologicalAwareness(PhonologicalAwareness phonologicalAwareness) {
        return phonologicalAwarenessRepository.save(phonologicalAwareness);
    }
    @Override
    public PhonologicalAwareness updatePhonologicalAwareness(PhonologicalAwareness phonologicalAwareness) {
        return phonologicalAwarenessRepository.save(phonologicalAwareness);
    }
    @Override
    public PhonologicalAwareness getPhonologicalAwarenessById(int id) {
        return phonologicalAwarenessRepository.findById(id).get();
    }
    @Override
    public List<PhonologicalAwareness> getAllPhonologicalAwareness() {
        return (List<PhonologicalAwareness>) phonologicalAwarenessRepository.findAll();
    }
    @Override
    public void deletePhonologicalAwareness(int id) {
        phonologicalAwarenessRepository.deleteById(id);
    }
    @Override
    public boolean isPhonologicalAwarenessExist(int id) {
        return phonologicalAwarenessRepository.existsById(id);
    }
}
