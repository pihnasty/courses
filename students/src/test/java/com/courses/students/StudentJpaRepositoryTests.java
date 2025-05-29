package com.courses.students;

import com.courses.students.config.StudentConfig;
import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("h2-test")
@Import({StudentConfig.class})
public class StudentJpaRepositoryTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAllTest(){
        var expectedStudents = studentRepository.findAll();
        assertThat(expectedStudents).isNotEmpty();
        assertThat(expectedStudents).isInstanceOf(Iterable.class);
        assertThat(expectedStudents).element(0).isInstanceOf(Student.class);
        assertThat(expectedStudents).element(0).matches(Student::isActive);
    }

    @Test
    void saveTest(){
        var newStudent =  Student.builder()
                .email(TestConstants.NEW_TEST_EMAIL)
                .name(TestConstants.NEW_TEST_NAME)
                .password(TestConstants.NEW_TEST_PASSWORD)
                .role(Role.STUDENT)
                .active(true)
                .build();
        var student = studentRepository.save(newStudent);
        assertThat(student).isNotNull();
        assertThat(student).isInstanceOf(Student.class);
        assertThat(student).hasNoNullFieldsOrProperties();
        assertThat(student.isActive()).isTrue();
    }

    @Test
    void findByIdTest(){
        var student = studentRepository.findByEmail(TestConstants.TEST_EMAIL);

        assertThat(student).isNotNull();
        assertThat(student.get()).isInstanceOf(Student.class);
        assertThat(student.get().isActive()).isTrue();
        assertThat(student.get().getName()).isEqualTo(TestConstants.TEST_NAME);
    }

    @Test
    @Transactional
    void deleteByIdTest(){
        var student = studentRepository.findByEmail(TestConstants.TEST_EMAIL);
        assertThat(student).isNotNull();
        assertThat(student.get()).isInstanceOf(Student.class);
        assertThat(student.get().isActive()).isTrue();
        assertThat(student.get().getName()).isEqualTo(TestConstants.TEST_NAME);

        studentRepository.deleteByEmail(TestConstants.TEST_EMAIL);

        student = studentRepository.findById(TestConstants.TEST_EMAIL);
        assertThat(student).isNotNull();
        assertThat(student).isEmpty();
    }
}
