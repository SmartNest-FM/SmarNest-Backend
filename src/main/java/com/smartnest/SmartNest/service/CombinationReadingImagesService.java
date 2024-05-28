package com.smartnest.SmartNest.service;
import com.smartnest.SmartNest.model.CombinationReadingImages;

import java.util.List;

public interface CombinationReadingImagesService {
    public abstract CombinationReadingImages createCombinationReadingImages(CombinationReadingImages combinationReadingImages);
    public abstract CombinationReadingImages updateCombinationReadingImages(CombinationReadingImages combinationReadingImages);
    public abstract CombinationReadingImages getCombinationReadingImagesById(int id);
    public abstract List<CombinationReadingImages> getAllCombinationReadingImages();
    public abstract void deleteCombinationReadingImages(int id);
    public abstract boolean isCombinationReadingImagesExist(int id);
}
