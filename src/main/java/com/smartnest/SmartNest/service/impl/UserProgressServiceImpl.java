package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.ReadingComprehension;
import com.smartnest.SmartNest.model.User;
import com.smartnest.SmartNest.model.UserProgress;
import com.smartnest.SmartNest.repository.UserProgressRepository;
import com.smartnest.SmartNest.service.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProgressServiceImpl implements UserProgressService {
    @Autowired
    private UserProgressRepository userProgressRepository;
    @Override
    public UserProgress createUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }
    @Override
    public UserProgress updateUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }
    @Override
    public UserProgress getUserProgressById(int id) {
        return userProgressRepository.findById(id).get();
    }
    @Override
    public List<UserProgress> getAllUserProgresses() {
        return (List<UserProgress>) userProgressRepository.findAll();
    }
    @Override
    public void deleteUserProgress(int id) {
        userProgressRepository.deleteById(id);
    }
    @Override
    public boolean isUserProgressExist(int id) {
        return userProgressRepository.existsById(id);
    }

    @Override
    public List<UserProgress>  findByUser_Uid(String uid) {
        return userProgressRepository.findByUser_Uid(uid);
    }


}
