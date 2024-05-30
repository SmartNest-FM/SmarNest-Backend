package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="word", nullable = false, length = 100)
    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public VocabularyVerb getVocabularyVerb() {
        return vocabularyVerb;
    }

    public void setVocabularyVerb(VocabularyVerb vocabularyVerb) {
        this.vocabularyVerb = vocabularyVerb;
    }

    @Column(name="meaning", nullable = false, length = 100)
    private String meaning;
    @Column(name="image", nullable = false, length = 100)
    private String image;
    @ManyToOne
    @JoinColumn(name="vocabulary_verb_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_VOCABULARY_VERB_ID"))
    private VocabularyVerb vocabularyVerb;
}
