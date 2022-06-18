package com.jobayed.customsecurity.auth_user.service;

import com.jobayed.customsecurity.auth_user.model.Role;
import com.jobayed.customsecurity.auth_user.model.User;
import com.jobayed.customsecurity.auth_user.repository.RoleRepo;
import com.jobayed.customsecurity.auth_user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService
{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null)
        {
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }
        else {
            log.info("Found User: {}",username);

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return new org.springframework.security.core
                .userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    private String getCurrentDateTime()
    {
        Date date = new Date();
        String strDateFormat = "d MM, Y hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate;
    }

    @Override
    public User saveUser(User user) {
        User u = userRepo.save(user);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        log.info("Saving new User {} at {}",u.getName(),this.getCurrentDateTime());
        return u;
    }

    @Override
    public Role saveRole(Role role) {
        Role r = roleRepo.save(role);
        log.info("Saving new Role {} at {}",r.getRoleName(),this.getCurrentDateTime());
        return r;
    }

    @Override
    public void assignRole(String username, String rolename) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(rolename);

        user.getRole().add(role);
        log.info("Assigned role {} to user {} at {}",rolename,username,this.getCurrentDateTime());
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Page<User> getUsers(int pageNumber, int pageSize) {
        return userRepo.findAll(PageRequest.of(pageNumber,pageSize));
    }
}
