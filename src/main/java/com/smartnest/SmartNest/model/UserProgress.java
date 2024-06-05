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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_LEVEL_ID_USER_PROGRESS"))
    private Level level;

    @ManyToOne
    @JoinColumn(name = "phonological_awareness_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PHONOLOGICAL_AWARENESS  _ID_USER_PROGRESS"))
    private PhonologicalAwareness phonologicalAwareness;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @Column(name = "score", nullable = false)
    private int score;
}
