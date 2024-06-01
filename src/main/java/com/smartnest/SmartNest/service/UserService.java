package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.User;

import java.util.List;

public interface UserService {
    public abstract User createUser(User user);
    public abstract User updateUser(User user);
    public abstract User getUserById(int id);
    public abstract List<User> getAllUsers();
    public abstract void deleteUser(int id);
    public abstract boolean isUserExist(int id);
    public abstract User getUserByUid(String uid);
}
