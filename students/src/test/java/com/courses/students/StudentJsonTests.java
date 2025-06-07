package com.courses.students;


import com.courses.students.model.Role;
import com.courses.students.model.Student;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class StudentJsonTests {

    @Autowired
    private JacksonTester<Student> jacksonTester;

    @Test
    void serializeStudentJsonTest() throws IOException{
        JsonContent<Student> json =  jacksonTester.write(getStudent());
        assertThat(json).extractingJsonPathValue("$.email").isEqualTo(TestConstants.TEST_EMAIL);
        assertThat(json).extractingJsonPathArrayValue("$.roles").size().isEqualTo(1);
        assertThat(json).extractingJsonPathBooleanValue("$.active").isTrue();
    }

    @Test
    void serializeStudentJsonFileTest() throws IOException{
        JsonContent<Student> json =  jacksonTester.write(getStudent());
        assertThat(json).isEqualToJson("student.json");
    }

    @Test
    void deserializeStudentJsonTest() throws Exception{
        Student user = this.jacksonTester.parseObject(TestConstants.NEW_STUDENTS_CONTENT);

        assertThat(user.getEmail()).isEqualTo(TestConstants.TEST_EMAIL);
        assertThat(user.getPassword()).isEqualTo(TestConstants.TEST_PASSWORD_NO_ENCRYPT);
        assertThat(user.isActive()).isTrue();

    }

    @Test
    void studentValidationTest(){
        Student student = Student.builder()
                .password(TestConstants.TEST_EMAIL)
                .role( Role.STUDENT)
                .active(true)
                .build();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
        assertThat(constraintViolations).isNotEmpty();
        assertThat(constraintViolations).hasSize(4);
    }

    private Student getStudent() {
        return Student.builder()
                .email(TestConstants.TEST_EMAIL)
                .name(TestConstants.TEST_NAME)
                .password(TestConstants.TEST_PASSWORD_NO_ENCRYPT)
                .role(Role.STUDENT)
                .active(true)
                .build();
    }
}
