package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

public class VocabularyVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="main_image", nullable = false, length = 100)
    private String mainImage;
    @Column(name="question", nullable = false, length = 100)
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getWordSelectVerb() {
        return wordSelectVerb;
    }

    public void setWordSelectVerb(String wordSelectVerb) {
        this.wordSelectVerb = wordSelectVerb;
    }

    public String getWordSelectVocabulary() {
        return wordSelectVocabulary;
    }

    public void setWordSelectVocabulary(String wordSelectVocabulary) {
        this.wordSelectVocabulary = wordSelectVocabulary;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Column(name="statement", nullable = false, length = 100)
    private String statement;
    @Column(name="user_response", nullable = false, length = 100)
    private String userResponse;
    @Column(name="correct_answer", nullable = false, length = 100)
    private String correctAnswer;
    @Column(name="is_correct", nullable = false)
    private boolean isCorrect;
    @Column(name="word_select_verb", nullable = false, length = 100)
    private String wordSelectVerb;
    @Column(name="word_select_vocabulary", nullable = false, length = 100)
    private String wordSelectVocabulary;


    @ManyToOne
    @JoinColumn(name="level_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_LEVEL_ID_LEVEL_VOCABULARY_VERB"))
    private Level level;
}
