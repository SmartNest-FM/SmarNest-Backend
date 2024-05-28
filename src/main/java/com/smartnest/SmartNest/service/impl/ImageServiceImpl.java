package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.FluentReading;
import com.smartnest.SmartNest.model.Image;
import com.smartnest.SmartNest.repository.FluentReadingRepository;
import com.smartnest.SmartNest.repository.ImageRepository;
import com.smartnest.SmartNest.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }
    @Override
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }
    @Override
    public Image getImageById(int id) {
        return imageRepository.findById(id).get();
    }
    @Override
    public List<Image> getAllImages() {
        return (List<Image>) imageRepository.findAll();
    }
    @Override
    public void deleteImage(int id) {
        imageRepository.deleteById(id);
    }
    @Override
    public boolean isImageExist(int id) {
        return imageRepository.existsById(id);
    }
}
