package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class PhonologicalAwareness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="main_image", nullable = false, length = 250)
    private String mainImage;

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



    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Column(name="question", nullable = false, length = 100)
    private String question;
    @Column(name="user_response", nullable = false, length = 100)
    private String userResponse;
    @Column(name="correct_answer", nullable = false, length = 100)
    private String correctAnswer;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Column(name="correct", nullable = false)
    private boolean correct;

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    @Column(name="answer_one", nullable = false, length = 300)
    private String answerOne;

    @Column(name="answer_two", nullable = false, length = 300)
    private String answerTwo;

    @Column(name="answer_three", nullable = false, length = 300)
    private String answerThree;

    @ManyToOne
    @JoinColumn(name="level_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_LEVEL_ID_LEVEL_PHONOLOGICAL_AWARENESS"))
    private Level level;

}

