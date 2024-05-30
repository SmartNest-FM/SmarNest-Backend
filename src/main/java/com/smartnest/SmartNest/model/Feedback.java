package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="feedback", nullable = false, length = 100)
    private String feedback;
    @Column(name="image", nullable = false, length = 100)
    private String image;

    @OneToOne
    @JoinColumn(name="feedback_phonological_awareness_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_FEEDBACK_PHONOLOGICAL_AWARENESS_ID"))
    private PhonologicalAwareness phonologicalAwareness;

    @OneToOne
    @JoinColumn(name="feedback_reading_comprehension_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_FEEDBACK_READING_COMPREHENSION_ID"))
    private ReadingComprehension readingComprehension;

    @OneToOne
    @JoinColumn(name="feedback_fluent_reading_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_FEEDBACK_FLUENT_READING_ID"))
    private FluentReading fluentReading;

    @OneToOne
    @JoinColumn(name="feedback_combination_reading_images_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_FEEDBACK_COMBINATION_READING_ID"))
    private CombinationReadingImages combinationReadingImages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PhonologicalAwareness getPhonologicalAwareness() {
        return phonologicalAwareness;
    }

    public void setPhonologicalAwareness(PhonologicalAwareness phonologicalAwareness) {
        this.phonologicalAwareness = phonologicalAwareness;
    }

    public ReadingComprehension getReadingComprehension() {
        return readingComprehension;
    }

    public void setReadingComprehension(ReadingComprehension readingComprehension) {
        this.readingComprehension = readingComprehension;
    }

    public FluentReading getFluentReading() {
        return fluentReading;
    }

    public void setFluentReading(FluentReading fluentReading) {
        this.fluentReading = fluentReading;
    }

    public CombinationReadingImages getCombinationReadingImages() {
        return combinationReadingImages;
    }

    public void setCombinationReadingImages(CombinationReadingImages combinationReadingImages) {
        this.combinationReadingImages = combinationReadingImages;
    }

    public VocabularyVerb getVocabularyVerb() {
        return vocabularyVerb;
    }

    public void setVocabularyVerb(VocabularyVerb vocabularyVerb) {
        this.vocabularyVerb = vocabularyVerb;
    }

    @OneToOne
    @JoinColumn(name="feedback_vocabulary_verb_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_FEEDBACK_VOCABULARY_VERB_ID"))
    private VocabularyVerb vocabularyVerb;

}
