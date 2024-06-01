package com.smartnest.SmartNest.repository;

import com.smartnest.SmartNest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUid(String uid);
}
