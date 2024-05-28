package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.model.Image;
import com.smartnest.SmartNest.service.FluentReadingService;
import com.smartnest.SmartNest.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/imageService", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllImages() {
        return new ResponseEntity<>(imageService.getAllImages(), HttpStatus.OK);
    }

    @PostMapping(value = "/imageService")
    public ResponseEntity<Object> createImage(@RequestBody Image image) {
        imageService.createImage(image);
        return new ResponseEntity<>("Image is created successfully with id = " + image.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/imageService/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getImageById(@PathVariable("id") int id) {
        Image image = imageService.getImageById(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @RequestMapping(value = "/imageService/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateImage(@PathVariable("id") int id, @RequestBody Image image) {
        image.setId(id);
        imageService.updateImage(image);
        return new ResponseEntity<>("Image is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/imageService/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteImage(@PathVariable("id") int id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>("Image is deleted successfully", HttpStatus.OK);
    }
}
