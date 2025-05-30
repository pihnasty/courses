package com.courses.students.config;

import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@TestConfiguration
public class StudentConfig {

    @Profile("memory")  // Activate this with --spring.profiles.active=memory
    @Bean
    CommandLineRunner init(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student("admin@example.com","Admin","$2a$10$FVtkW.syUD9vBn2qyR/1X.aJqId70A8Y3VMkyggPearWxyCPhUSAS", List.of(Role.STUDENT, Role.ADMIN),true));
            studentRepository.save(new Student("test@example.com", "Test", "$2a$10$jF.GApl9MDKckgtv.Ej50.IfZLy2K059ycd0nqpyz5pqAPBqhqlhO", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("test_deleting@example.com", "TestDeleting", "$2a$10$HOG57Cxoc/E.d8U7upmsAuprEAREQu8W9tDVdcBGH6wha/TFSXqRS", List.of(Role.STUDENT), true));
        };
    }

}
