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
            studentRepository.save(new Student("admin@example.com","Admin","$2a$10$FVtkW.syUD9vBn2qyR/1X.aJqId70A8Y3VMkyggPearWxyCPhUSAS", List.of(Role.STUDENT, Role.TEACHER, Role.ADMIN),true));
            studentRepository.save(new Student("alice@example.com", "Alice Johnson", "$2a$10$d0ERqv2HUUIUcIkAqcGIa.zoT3SmYLwD2SvR7jyFNngaioq228NLm", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("bob@example.com", "Bob Smith", "$2a$10$ZC6CWNeY2Ilt.I0W7ZffGuFnyihSlumRTfKPqnA0pObevFu8KlNDq", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("carol@example.com", "Carol White", "$2a$10$RZ5T0FtSmf4RobZZDSaSQubrFjPHcPv7R67m3bP.mSWJZl086zWwq", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("david@example.com", "David Brown", "$2a$10$Vlr2TjbGm2vv.rHILIWjXOw.oAyZym.b/afOcpUbujw33saGHTCWm", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("eva@example.com", "Eva Green", "$2a$10$/V0gv2wi/KgwURoJwVPu6.Jcoz5HnNdKfKOoYw8HifJWyPsy5jPxS", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("jack@example.com", "Jack Walker", "$2a$10$DtwK4bkes7e9H8LUWU9piuDvyinG8rTtKu/89b5xyHhrXMo4odmlW", List.of(Role.STUDENT), true));
            studentRepository.save(new Student("test@example.com", "Test", "$2a$10$jF.GApl9MDKckgtv.Ej50.IfZLy2K059ycd0nqpyz5pqAPBqhqlhO", List.of(Role.STUDENT, Role.ADMIN), true));
        };
    }
}
