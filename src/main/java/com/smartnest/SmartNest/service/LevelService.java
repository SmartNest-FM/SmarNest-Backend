package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.Level;

import java.util.List;

public interface LevelService {
    public abstract Level createLevel(Level level);
    public abstract Level updateLevel(Level level);
    public abstract Level getLevelById(int id);
    public abstract List<Level> getAllLevels();
    public abstract void deleteLevel(int id);
    public abstract boolean isLevelExist(int id);
}
