package com.smartnest.SmartNest.model.dto;

public class ProgressResponse {

    private int totalActivities;
    private int completedActivities;
    private double percentage;

    public ProgressResponse(int totalActivities, int completedActivities, double percentage) {
        this.totalActivities = totalActivities;
        this.completedActivities = completedActivities;
        this.percentage = percentage;
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
