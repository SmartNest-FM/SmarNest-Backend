package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.FluentReading;

import java.util.List;

public interface FluentReadingService {
    public abstract FluentReading createFluentReading(FluentReading fluentReading);
    public abstract FluentReading updateFluentReading(FluentReading fluentReading);
    public abstract FluentReading getFluentReadingById(int id);
    public abstract List<FluentReading> getAllFluentReadings();
    public abstract void deleteFluentReading(int id);
    public abstract boolean isFluentReadingExist(int id);
}
