package com.courses.students;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
//@WithMockUser
@ActiveProfiles("h2-test")
@AutoConfigureMockMvc
public class StudentMockMvcWithoutMockUserTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createStudent_WithLoginSession() throws Exception {
        // Step 1: Login using form auth
        MvcResult loginResult = mockMvc.perform(post("/login")
                        .param("username", TestConstants.ADMIN_EMAIL)
                        .param("password", TestConstants.ADMIN_NO_PASSWORD))
                .andExpect(status().is3xxRedirection()) // redirects after login
                .andReturn();

        // Step 2: Extract session (cookie)
        MockHttpSession session = (MockHttpSession) loginResult.getRequest().getSession(false);

        // Step 3: Use session to call secured endpoint
        mockMvc.perform(post(TestConstants.STUDENTS_ENDPOINT)
                        .session(Objects.requireNonNull(session))
                        .contentType("application/json")
                        .content(TestConstants.NEW_STUDENTS_CONTENT))
                .andExpect(status().isCreated());
    }
}
