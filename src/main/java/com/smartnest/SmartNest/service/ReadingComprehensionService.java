package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.ReadingComprehension;

import java.util.List;

public interface ReadingComprehensionService {
    public abstract ReadingComprehension createReadingComprehension(ReadingComprehension readingComprehension);
    public abstract ReadingComprehension updateReadingComprehension(ReadingComprehension readingComprehension);
    public abstract ReadingComprehension getReadingComprehensionById(int id);
    public abstract List<ReadingComprehension> getAllReadingComprehensions();
    public abstract void deleteReadingComprehension(int id);
    public abstract boolean isReadingComprehensionExist(int id);
}
