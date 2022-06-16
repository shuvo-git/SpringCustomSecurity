package com.jobayed.customsecurity.auth_user.api;

import com.jobayed.customsecurity.auth_user.domain.Role;
import com.jobayed.customsecurity.auth_user.domain.User;
import com.jobayed.customsecurity.auth_user.service.UserService;
import com.jobayed.customsecurity.auth_user.utils.JwtUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("http://localhost:4200")
@Slf4j
@RestController @RequiredArgsConstructor
@RequestMapping("/user")
public class UserController
{
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping("/get")
    public ResponseEntity<Page<User>> getusers(@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        return ResponseEntity.ok(userService.getUsers(pageNumber,pageSize));
    }

    @PostMapping("/store")
    public ResponseEntity<User> storeUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/assign-role")
    public ResponseEntity<?> assignRole(@RequestBody RoleToUserForm form){
        userService.assignRole(form.getUsername(),form.getRolename());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/store-role")
    public ResponseEntity<Role> storeRole(@RequestBody Role role){
        return ResponseEntity.ok(userService.saveRole(role));
    }

    @Data
    static class RoleToUserForm{
        private String username;
        private String rolename;
    }
}
