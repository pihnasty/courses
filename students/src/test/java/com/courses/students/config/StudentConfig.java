package com.courses.students.config;

import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class StudentConfig {

    @Bean
    CommandLineRunner init(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student("admin@example.com","Admin","admin", List.of(Role.STUDENT, Role.ADMIN),true));
            studentRepository.save(new Student("test@example.com", "Test", "test", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("test_deleting@example.com", "TestDeleting", "deleting", List.of(Role.STUDENT), true));
        };
    }

}
