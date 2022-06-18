package com.jobayed.customsecurity.auth_user.repository;

import com.jobayed.customsecurity.auth_user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String name);
}
