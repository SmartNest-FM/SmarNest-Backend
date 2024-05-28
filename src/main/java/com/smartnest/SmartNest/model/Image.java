package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="url_image", nullable = false)
    private String urlImage;
    @Column(name="description", nullable = false)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CombinationReadingImages getCombinationReadingImages() {
        return combinationReadingImages;
    }

    public void setCombinationReadingImages(CombinationReadingImages combinationReadingImages) {
        this.combinationReadingImages = combinationReadingImages;
    }

    @ManyToOne
    @JoinColumn(name="combination_reading_images_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_COMBINATION_READING_IMAGES_ID"))
    private CombinationReadingImages combinationReadingImages;
}
