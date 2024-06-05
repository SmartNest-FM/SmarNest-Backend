package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.model.UserProgress;

import java.util.List;

public interface UserProgressService {
    public abstract UserProgress createUserProgress(UserProgress userProgress);
    public abstract UserProgress updateUserProgress(UserProgress userProgress);
    public abstract UserProgress getUserProgressById(int id);
    public abstract List<UserProgress> getAllUserProgresses();
    public abstract void deleteUserProgress(int id);
    public abstract boolean isUserProgressExist(int id);
    public abstract List<UserProgress> findByUser_Uid(String uid);
}
