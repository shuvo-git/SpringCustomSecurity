package com.jobayed.customsecurity.auth_user.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.jobayed.customsecurity.auth_user.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GeneralConfig {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean JwtUtils jwtUtils(){return new JwtUtils();}

    @Bean
    public Hibernate5Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }
}
