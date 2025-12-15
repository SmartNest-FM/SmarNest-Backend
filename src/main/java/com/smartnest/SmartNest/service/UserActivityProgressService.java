package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.UserActivityProgress;

import java.util.List;

public interface UserActivityProgressService {

    UserActivityProgress save(UserActivityProgress progress);

    List<UserActivityProgress> getProgressByUserUid(String uid);

    List<UserActivityProgress> getProgressByUserUidAndLevel(String uid, int levelId);

    List<UserActivityProgress> getProgressByUserUidAndType(String uid, String type);

    boolean existsByUserAndActivity(String uid, int activityId, String type);

    boolean isActivityCompleted(String uid, int activityId, String activityType);
}
