package com.courses.students.security;

import com.courses.students.repository.StudentRepository;
import com.courses.students.service.StudentDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class StudentsSecurityConfig {

    private final StudentRepository studentRepository;

    public StudentsSecurityConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                    CorsConfigurationSource corsConfigurationSource) throws Exception {
        return httpSecurity
                //.csrf(csrf -> csrf.disable()) // Optional: disable CSRF for simplicity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .logout(logout -> logout
                        //.logoutSuccessUrl("/index.html")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                //.httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/login")
                )
                .cors(cors -> cors.configurationSource(
                        corsConfigurationSource))
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
                )
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

    /* Alternative option to  public AuthenticationProvider authenticationProvider()/.
     * This method can use instead  public AuthenticationProvider authenticationProvider()
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(new StudentDetailsService(studentRepository));
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
    */

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList("http://localhost:63342")); // "http://localhost:63342" When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
        configuration.setAllowedMethods(Arrays.asList("*")); // "GET", "POST", "PUT", "DELETE", "OPTIONS"
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
