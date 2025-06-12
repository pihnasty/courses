package com.courses.students;

import com.courses.students.config.StudentConfig;
import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import com.courses.students.security.StudentsSecurityConfig;
import com.courses.students.web.StudentsController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import({StudentsSecurityConfig.class, StudentConfig.class})
@WebMvcTest(controllers = { StudentsController.class })
public class StudentControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private StudentRepository studentRepository;


    @BeforeEach
    void SetUp(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .alwaysDo(print())
                .apply(springSecurity())
                .build();
    }


    @WithMockUser
    @Test
    void getAllStudentsTest() throws Exception {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(
                Student.builder()
                        .email(TestConstants.NEW_TEST_EMAIL)
                        .name(TestConstants.NEW_TEST_NAME)
                        .password(TestConstants.NEW_TEST_PASSWORD)
                        .role(Role.STUDENT)
                        .active(true)
                        .build(),
                Student.builder()
                        .email(TestConstants.TEST_EMAIL)
                        .name(TestConstants.TEST_NAME)
                        .password(TestConstants.TEST_PASSWORD_NO_ENCRYPT)
                        .role(Role.STUDENT)
                        .active(true)
                        .build()
        ));

        mockMvc.perform(get(TestConstants.STUDENTS_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].active").value(true));
    }

        @WithMockUser
        @Test
        void newStudentTest() throws Exception {
            Student student = Student.builder()
                    .email(TestConstants.TEST_EMAIL)
                    .name(TestConstants.TEST_NAME)
                    .password(TestConstants.TEST_PASSWORD_NO_ENCRYPT)
                    .role(Role.STUDENT)
                    .active(true)
                    .build();

            when(studentRepository.save(student)).thenReturn(student);
            when(studentRepository.findByEmail(student.getEmail())).thenReturn(Optional.of(student));

            mockMvc.perform(post(TestConstants.STUDENTS_ENDPOINT)
                            .content(toJson(student))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.email").value(TestConstants.TEST_EMAIL));
        }

        @WithMockUser
        @Test
        void findStudentByEmailTest() throws Exception {
            Student student = Student.builder()
                    .email(TestConstants.TEST_EMAIL)
                    .name(TestConstants.TEST_NAME)
                    .password(TestConstants.TEST_PASSWORD_NO_ENCRYPT)
                    .role(Role.STUDENT)
                    .active(true)
                    .build();

            when(studentRepository.findByEmail(student.getEmail())).thenReturn(Optional.of(student));


            mockMvc.perform(get("/students/{email}",student.getEmail())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.email").value(TestConstants.TEST_EMAIL));
        }

    @WithMockUser
    @Test
    void deleteStudentByEmailTest() throws Exception{
        Student student = Student.builder()
                .email(TestConstants.TEST_EMAIL)
                .name(TestConstants.TEST_NAME)
                .password(TestConstants.TEST_PASSWORD_NO_ENCRYPT)
                .role(Role.STUDENT)
                .active(true)
                .build();

        doNothing().when(studentRepository).deleteById(student.getEmail());

        mockMvc.perform(delete(TestConstants.STUDENTS_ENDPOINT + "/{email}",student.getEmail()))
                .andExpect(status().isNoContent());

    }

    private static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
