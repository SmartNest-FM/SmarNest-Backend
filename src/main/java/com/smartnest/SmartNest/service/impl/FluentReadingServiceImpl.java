package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.FluentReading;
import com.smartnest.SmartNest.repository.FluentReadingRepository;
import com.smartnest.SmartNest.service.FluentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FluentReadingServiceImpl implements FluentReadingService {
    @Autowired
    private FluentReadingRepository fluentReadingRepository;
    @Override
    public FluentReading createFluentReading(FluentReading fluentReading) {
        return fluentReadingRepository.save(fluentReading);
    }
    @Override
    public FluentReading updateFluentReading(FluentReading fluentReading) {
        return fluentReadingRepository.save(fluentReading);
    }
    @Override
    public FluentReading getFluentReadingById(int id) {
        return fluentReadingRepository.findById(id).get();
    }
    @Override
    public List<FluentReading> getAllFluentReadings() {
        return (List<FluentReading>) fluentReadingRepository.findAll();
    }
    @Override
    public void deleteFluentReading(int id) {
        fluentReadingRepository.deleteById(id);
    }
    @Override
    public boolean isFluentReadingExist(int id) {
        return fluentReadingRepository.existsById(id);
    }
}
