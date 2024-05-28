package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.Level;
import com.smartnest.SmartNest.model.PhonologicalAwareness;

import java.util.List;

public interface PhonologicalAwarenessService {
    public abstract PhonologicalAwareness createPhonologicalAwareness(PhonologicalAwareness phonologicalAwareness);
    public abstract PhonologicalAwareness updatePhonologicalAwareness(PhonologicalAwareness phonologicalAwareness);
    public abstract PhonologicalAwareness getPhonologicalAwarenessById(int id);
    public abstract List<PhonologicalAwareness> getAllPhonologicalAwareness();
    public abstract void deletePhonologicalAwareness(int id);
    public abstract boolean isPhonologicalAwarenessExist(int id);
}
