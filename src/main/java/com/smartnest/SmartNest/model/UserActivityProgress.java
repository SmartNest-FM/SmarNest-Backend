package com.smartnest.SmartNest.model;

import jakarta.persistence.*;
@Entity
@Table(name = "user_activity_progress")
public class UserActivityProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_PROGRESS_USER")
    )
    private User user;

    @Column(name = "activity_id", nullable = false)
    private int activityId;

    @Column(name = "activity_type", nullable = false, length = 50)
    private String activityType;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "level_id", nullable = false)
    private int levelId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getActivityId() { return activityId; }
    public void setActivityId(int activityId) { this.activityId = activityId; }

    public String getActivityType() { return activityType; }
    public void setActivityType(String activityType) { this.activityType = activityType; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getLevelId() { return levelId; }
    public void setLevelId(int levelId) { this.levelId = levelId; }
}
