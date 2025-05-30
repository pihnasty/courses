package com.courses.students.security;

import com.courses.students.repository.StudentRepository;
import com.courses.students.service.StudentDetailsService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@TestConfiguration
public class StudentsSecurityConfig {

    private final StudentRepository studentRepository;

    public StudentsSecurityConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Bean
    SecurityFilterChain filterChainTest(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
/**
 * Exception description:
 * Trying to match using RequestHeaderRequestMatcher [expectedHeaderName=X-Requested-With, expectedHeaderValue=XMLHttpRequest]
 * No match found. Using default entry point org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint@2f78bd0c
 *
 * Solution:
 *
 * add .csrf(AbstractHttpConfigurer::disable)
 *
 * Spring Security enables CSRF (Cross-Site Request Forgery) protection by default for state-changing
 * requests like POST, PUT, DELETE. When testing such endpoints with TestRestTemplate, CSRF tokens are
 * not automatically included, unless you disable CSRF or explicitly handle it.
 */
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .requestCache(RequestCacheConfigurer::disable)
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(new StudentDetailsService(studentRepository));
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
