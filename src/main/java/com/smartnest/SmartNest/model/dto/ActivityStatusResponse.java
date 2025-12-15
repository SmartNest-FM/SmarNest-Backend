package com.smartnest.SmartNest.model.dto;

public class ActivityStatusResponse {

    private boolean completed;

    public ActivityStatusResponse(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
