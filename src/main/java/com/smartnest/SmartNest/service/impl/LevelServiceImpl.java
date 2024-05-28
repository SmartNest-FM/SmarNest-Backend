package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.Level;
import com.smartnest.SmartNest.repository.LevelRepository;
import com.smartnest.SmartNest.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;
    @Override
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }
    @Override
    public Level updateLevel(Level level) {
        return levelRepository.save(level);
    }
    @Override
    public Level getLevelById(int id) {
        return levelRepository.findById(id).get();
    }
    @Override
    public List<Level> getAllLevels() {
        return (List<Level>) levelRepository.findAll();
    }
    @Override
    public void deleteLevel(int id) {
        levelRepository.deleteById(id);
    }
    @Override
    public boolean isLevelExist(int id) {
        return levelRepository.existsById(id);
    }
}
