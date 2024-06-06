package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class CombinationReadingImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="question", nullable = false, length = 100)
    private String question;
    @Column(name="statement", nullable = false, length = 100)
    private String statement;
    @Column(name="user_response", nullable = false, length = 100)
    private String userResponse;
    @Column(name="correct_answer", nullable = false, length = 100)
    private String correctAnswer;

    @Column(name="answer_one", nullable = false, length = 300)
    private String answerOne;

    @Column(name="answer_two", nullable = false, length = 300)
    private String answerTwo;

    @Column(name="second_image", nullable = false, length = 300)
    private String secondImage;

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @Column(name="main_image", nullable = false, length = 300)
    private String mainImage;

    public String getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(String secondImage) {
        this.secondImage = secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(String thirdImage) {
        this.thirdImage = thirdImage;
    }

    @Column(name="third_image", nullable = false, length = 300)
    private String thirdImage;

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

    @Column(name="answer_three", nullable = false, length = 300)
    private String answerThree;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Column(name="correct", nullable = false)
    private boolean correct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @ManyToOne
    @JoinColumn(name="level_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_LEVEL_ID_LEVEL_COMBINATION_READING_IMAGES"))
    private Level level;
}
