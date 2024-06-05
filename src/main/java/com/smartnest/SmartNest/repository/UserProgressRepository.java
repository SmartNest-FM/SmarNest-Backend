package com.smartnest.SmartNest.repository;

import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.model.UserProgress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserProgressRepository extends CrudRepository<UserProgress, Integer>{
    List<UserProgress> findByUser_Uid(String uid);
}
