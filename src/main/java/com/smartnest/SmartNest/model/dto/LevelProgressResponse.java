package com.smartnest.SmartNest.model.dto;

public class LevelProgressResponse {

    private int levelId;
    private String levelName;
    private int totalActivities;
    private int completedActivities;
    private double percentage;

    public LevelProgressResponse(int levelId, String levelName, int totalActivities, int completedActivities, double percentage) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.totalActivities = totalActivities;
        this.completedActivities = completedActivities;
        this.percentage = percentage;
    }

    public int getLevelId() {
        return levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getTotalActivities() {
        return totalActivities;
    }

    public int getCompletedActivities() {
        return completedActivities;
    }

    public double getPercentage() {
        return percentage;
    }
}
