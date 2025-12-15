package com.smartnest.SmartNest.repository;

import com.smartnest.SmartNest.model.UserActivityProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivityProgressRepository extends JpaRepository<UserActivityProgress, Integer> {

    List<UserActivityProgress> findByUser_Uid(String uid);

    List<UserActivityProgress> findByUser_UidAndLevelId(String uid, int levelId);

    List<UserActivityProgress> findByUser_UidAndActivityType(String uid, String type);
    
    boolean existsByUser_UidAndActivityIdAndActivityType(String uid, int activityId, String activityType);
}
