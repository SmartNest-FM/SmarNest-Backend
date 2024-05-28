package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.CombinationReadingImages;
import com.smartnest.SmartNest.model.FluentReading;
import com.smartnest.SmartNest.repository.CombinationReadingImagesRepository;
import com.smartnest.SmartNest.repository.FluentReadingRepository;
import com.smartnest.SmartNest.service.CombinationReadingImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinationReadingImagesServiceImpl implements CombinationReadingImagesService {
    @Autowired
    private CombinationReadingImagesRepository combinationReadingImagesRepository;
    @Override
    public CombinationReadingImages createCombinationReadingImages(CombinationReadingImages combinationReadingImages) {
        return combinationReadingImagesRepository.save(combinationReadingImages);
    }
    @Override
    public CombinationReadingImages updateCombinationReadingImages(CombinationReadingImages combinationReadingImages) {
        return combinationReadingImagesRepository.save(combinationReadingImages);
    }
    @Override
    public CombinationReadingImages getCombinationReadingImagesById(int id) {
        return combinationReadingImagesRepository.findById(id).get();
    }
    @Override
    public List<CombinationReadingImages> getAllCombinationReadingImages() {
        return (List<CombinationReadingImages>) combinationReadingImagesRepository.findAll();
    }
    @Override
    public void deleteCombinationReadingImages(int id) {
        combinationReadingImagesRepository.deleteById(id);
    }
    @Override
    public boolean isCombinationReadingImagesExist(int id) {
        return combinationReadingImagesRepository.existsById(id);
    }
}
