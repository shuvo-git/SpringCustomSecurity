package com.jobayed.customsecurity.auth_user.service;

import com.jobayed.customsecurity.auth_user.domain.Role;
import com.jobayed.customsecurity.auth_user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void assignRole(String username, String rolename);
    User getUser(String username);
    Page<User> getUsers(int pageNumber, int pageSize);
}
