package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class VocabularyVerb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="main_image", nullable = false, length = 300)
    private String mainImage;
    @Column(name="question", nullable = false, length = 300)
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


    public String getWordSelectVerb() {
        return wordSelectVerb;
    }

    public void setWordSelectVerb(String wordSelectVerb) {
        this.wordSelectVerb = wordSelectVerb;
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Column(name="statement", nullable = false, length = 300)
    private String statement;
    @Column(name="user_response", nullable = false, length = 300)
    private String userResponse;
    @Column(name="correct_answer", nullable = false, length = 300)
    private String correctAnswer;



    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

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

    @Column(name="correct", nullable = false)
    private boolean correct;
    @Column(name="word_select_verb", nullable = false, length = 100)
    private String wordSelectVerb;

    @Column(name="answer_one", nullable = false, length = 300)
    private String answerOne;

    @Column(name="answer_two", nullable = false, length = 300)
    private String answerTwo;

    @Column(name="answer_three", nullable = false, length = 300)
    private String answerThree;


    @ManyToOne
    @JoinColumn(name="level_id", nullable = false
            , foreignKey = @ForeignKey(name = "FK_LEVEL_ID_LEVEL_VOCABULARY_VERB"))
    private Level level;

    @Column(name="verb_synonym_one", nullable = false, length = 300)
    private String verbSynonymOne;

    @Column(name="verb_synonym_two", nullable = false, length = 300)
    private String verbSynonymTwo;

    public String getVerbSynonymOne() {
        return verbSynonymOne;
    }

    public void setVerbSynonymOne(String verbSynonymOne) {
        this.verbSynonymOne = verbSynonymOne;
    }

    public String getVerbSynonymTwo() {
        return verbSynonymTwo;
    }

    public void setVerbSynonymTwo(String verbSynonymTwo) {
        this.verbSynonymTwo = verbSynonymTwo;
    }

    public String getVerbSynonymThree() {
        return verbSynonymThree;
    }

    public void setVerbSynonymThree(String verbSynonymThree) {
        this.verbSynonymThree = verbSynonymThree;
    }

    @Column(name="verb_synonym_three", nullable = false, length = 300)
    private String verbSynonymThree;

    public String getVerbSynonymFour() {
        return verbSynonymFour;
    }

    public void setVerbSynonymFour(String verbSynonymFour) {
        this.verbSynonymFour = verbSynonymFour;
    }

    @Column(name="verb_synonym_four", nullable = false, length = 300)
    private String verbSynonymFour;

}
