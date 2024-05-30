package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.exception.UserNotFoundException;
import com.smartnest.SmartNest.model.CombinationReadingImages;
import com.smartnest.SmartNest.service.CombinationReadingImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CombinationReadingImagesController {
    @Autowired
    CombinationReadingImagesService combinationReadingImagesService;

    @RequestMapping(value = "/combinationReadingImagesService", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCombinationReadingImages() {
        return new ResponseEntity<>(combinationReadingImagesService.getAllCombinationReadingImages(), HttpStatus.OK);
    }

    @RequestMapping(value = "/combinationReadingImagesService", method = RequestMethod.POST)
    public ResponseEntity<Object> createCombinationReadingImages(@RequestBody CombinationReadingImages combinationReadingImages) {
        combinationReadingImagesService.createCombinationReadingImages(combinationReadingImages);
        return new ResponseEntity<>("CombinationReadingImages is created successfully with id = " + combinationReadingImages.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/combinationReadingImagesService/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCombinationReadingImagesById(@PathVariable("id") int id) {
        boolean  isExist = combinationReadingImagesService.isCombinationReadingImagesExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            CombinationReadingImages combinationReadingImages = combinationReadingImagesService.getCombinationReadingImagesById(id);
            return new ResponseEntity<>(combinationReadingImages, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/combinationReadingImagesService/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCombinationReadingImages(@PathVariable("id") int id, @RequestBody CombinationReadingImages combinationReadingImages) {
        boolean  isExist = combinationReadingImagesService.isCombinationReadingImagesExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            combinationReadingImages.setId(id);
            combinationReadingImagesService.updateCombinationReadingImages(combinationReadingImages);
            return new ResponseEntity<>("CombinationReadingImages is updated successfully", HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/combinationReadingImagesService/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCombinationReadingImages(@PathVariable("id") int id) {
        boolean  isExist = combinationReadingImagesService.isCombinationReadingImagesExist(id);
        if (!isExist){
            throw  new UserNotFoundException();
        }else{
            combinationReadingImagesService.deleteCombinationReadingImages(id);
            return new ResponseEntity<>("CombinationReadingImages is deleted successfully", HttpStatus.OK);
        }
    }
}
