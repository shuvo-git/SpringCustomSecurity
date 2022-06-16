package com.jobayed.customsecurity.auth_user.repo;

import com.jobayed.customsecurity.auth_user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
