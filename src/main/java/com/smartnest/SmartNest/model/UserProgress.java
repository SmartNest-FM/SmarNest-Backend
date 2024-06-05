package com.smartnest.SmartNest.model;

import jakarta.persistence.*;

@Entity
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_ID_USER_PROGRESS"))
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public PhonologicalAwareness getPhonologicalAwareness() {
        return phonologicalAwareness;
    }

    public void setPhonologicalAwareness(PhonologicalAwareness phonologicalAwareness) {
        this.phonologicalAwareness = phonologicalAwareness;
    }


    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_LEVEL_ID_USER_PROGRESS"))
    private Level level;

    @ManyToOne
    @JoinColumn(name = "phonological_awareness_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PHONOLOGICAL_AWARENESS  _ID_USER_PROGRESS"))
    private PhonologicalAwareness phonologicalAwareness;

    @Column(name = "completed_level", nullable = false)
    private boolean completedLevel;

    @Column(name = "score_level", nullable = false)
    private int scoreLevel;

    @Column(name = "completed_activity", nullable = false)
    private boolean completedActivity;

    public boolean isCompletedLevel() {
        return completedLevel;
    }

    public void setCompletedLevel(boolean completedLevel) {
        this.completedLevel = completedLevel;
    }

    public int getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(int scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    public boolean isCompletedActivity() {
        return completedActivity;
    }

    public void setCompletedActivity(boolean completedActivity) {
        this.completedActivity = completedActivity;
    }

    public int getScoreActivity() {
        return scoreActivity;
    }

    public void setScoreActivity(int scoreActivity) {
        this.scoreActivity = scoreActivity;
    }

    @Column(name = "score_activity", nullable = false)
    private int scoreActivity;
}
