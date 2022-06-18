package com.jobayed.customsecurity.auth_user.repository;

import com.jobayed.customsecurity.auth_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
