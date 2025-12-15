package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.UserActivityProgress;
import com.smartnest.SmartNest.repository.UserActivityProgressRepository;
import com.smartnest.SmartNest.service.UserActivityProgressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityProgressServiceImpl implements UserActivityProgressService {

    @Autowired
    private UserActivityProgressRepository progressRepository;

    @Override
    public UserActivityProgress save(UserActivityProgress progress) {
        return progressRepository.save(progress);
    }

    @Override
    public List<UserActivityProgress> getProgressByUserUid(String uid) {
        return progressRepository.findByUser_Uid(uid);
    }

    @Override
    public List<UserActivityProgress> getProgressByUserUidAndLevel(String uid, int levelId) {
        return progressRepository.findByUser_UidAndLevelId(uid, levelId);
    }

    @Override
    public List<UserActivityProgress> getProgressByUserUidAndType(String uid, String type) {
        return progressRepository.findByUser_UidAndActivityType(uid, type);
    }

    @Override
    public boolean existsByUserAndActivity(String uid, int activityId, String type) {
        return progressRepository.findByUser_UidAndActivityType(uid, type)
                .stream()
                .anyMatch(p -> p.getActivityId() == activityId);
    }

    public boolean isActivityCompleted(String uid, int activityId, String activityType) {
        return progressRepository.existsByUser_UidAndActivityIdAndActivityType(uid, activityId, activityType);
    }
}