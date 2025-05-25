package com.courses.students.security;

import com.courses.students.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class StudentsSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin@email.com")
                .password(passwordEncoder.encode("11"))
                .roles(Role.ADMIN.name(), Role.TEACHER.name(), Role.STUDENT.name())
                .build();
        UserDetails teacher = User.builder()
                .username("teacher1")
                .password(passwordEncoder.encode("11"))
                .roles(Role.TEACHER.name())
                .build();
        UserDetails student = User.builder()
                .username("student1")
                .password(passwordEncoder.encode("11"))
                .roles(Role.STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
