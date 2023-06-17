package com.eventmanagement.eventmanagementapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("chris").password(bCryptEncoder().encode("chris")).roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(bCryptEncoder().encode("admin")).roles("ADMIN").build();

        userDetailsService.createUser(user);
        userDetailsService.createUser(admin);
        return userDetailsService;
    }

    @Bean
    BCryptPasswordEncoder bCryptEncoder(){
        return new BCryptPasswordEncoder();
    }
}
