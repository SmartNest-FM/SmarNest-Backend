package com.smartnest.SmartNest.model.dto;

import java.util.List;
import java.util.Map;

public class AiEvaluateRequest {

    private String answer;
    private String expected;
    private List<String> alternatives;
    private String activityType;
    private Map<String, Double> thresholds;

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getExpected() { return expected; }
    public void setExpected(String expected) { this.expected = expected; }

    public List<String> getAlternatives() { return alternatives; }
    public void setAlternatives(List<String> alternatives) { this.alternatives = alternatives; }

    public String getActivityType() { return activityType; }
    public void setActivityType(String activityType) { this.activityType = activityType; }

    public Map<String, Double> getThresholds() { return thresholds; }
    public void setThresholds(Map<String, Double> thresholds) { this.thresholds = thresholds; }
}
