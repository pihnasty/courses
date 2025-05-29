package com.courses.students.config;

import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    @Profile("memory")  // Activate this with --spring.profiles.active=memory
    CommandLineRunner init(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student("admin@example.com","Admin","admin", List.of(Role.STUDENT, Role.TEACHER, Role.ADMIN),true));
            studentRepository.save(new Student("alice@example.com", "Alice Johnson", "passAlice123", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("bob@example.com", "Bob Smith", "bobSecure456", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("carol@example.com", "Carol White", "carolPwd789", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("david@example.com", "David Brown", "dav!dPwd321", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("eva@example.com", "Eva Green", "evaSecret987", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("jack@example.com", "Jack Walker", "jackPwd654", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("test@example.com", "Test", "test", List.of(Role.STUDENT, Role.ADMIN), true));
        };
    }
}
