package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.Image;

import java.util.List;

public interface ImageService {
    public abstract Image createImage(Image image);
    public abstract Image updateImage(Image image);
    public abstract Image getImageById(int id);
    public abstract List<Image> getAllImages();
    public abstract void deleteImage(int id);
    public abstract boolean isImageExist(int id);
}
