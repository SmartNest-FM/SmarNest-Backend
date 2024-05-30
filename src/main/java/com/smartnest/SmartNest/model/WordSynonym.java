package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class WordSynonym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="word", nullable = false, length = 100)
    private String word;
    @Column(name="meaning", nullable = false, length = 100)
    private String meaning;
    @Column(name="image", nullable = false, length = 100)
    private String image;

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

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    @ManyToOne
    @JoinColumn(name="vocabulary_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_VOCABULARY_ID"))
    private Vocabulary vocabulary;
}
