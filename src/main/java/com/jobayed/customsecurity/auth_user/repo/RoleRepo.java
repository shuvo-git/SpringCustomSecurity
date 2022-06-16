package com.jobayed.customsecurity.auth_user.repo;

import com.jobayed.customsecurity.auth_user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String name);
}
