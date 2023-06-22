package com.eventmanagement.eventmanagementapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity(prePostEnabled = true)
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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/events/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST,"/events").hasAnyRole( "ADMIN")
                .requestMatchers(HttpMethod.PUT,"/events/**").hasAnyRole( "ADMIN")
                .requestMatchers(HttpMethod.PATCH,"/events/**").hasAnyRole( "ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/events/**").hasAnyRole( "ADMIN");

        http.csrf().disable();

        return http.build();
    }
}
