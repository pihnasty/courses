package com.courses.students;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Objects;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@WithMockUser
@ActiveProfiles("h2-test")
@AutoConfigureMockMvc
public class StudentMockMvcWithMockUserTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createStudentTests() throws Exception {
        String location = mockMvc.perform(post(TestConstants.STUDENTS_ENDPOINT)
                        .contentType("application/json")
                        .content(TestConstants.NEW_STUDENTS_CONTENT))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andReturn().getResponse().getHeader("Location");

        mockMvc.perform(get(Objects.requireNonNull(location)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.active").value(true));
    }

    @Test
    void getAllStudentsTests() throws Exception {
        mockMvc.perform(get(TestConstants.STUDENTS_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[12].name").value(TestConstants.TEST_NAME))
                .andExpect(jsonPath("$..active").value(hasItem(true)));
    }
}
