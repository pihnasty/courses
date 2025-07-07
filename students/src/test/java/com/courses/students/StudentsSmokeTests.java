package com.courses.students;

import com.courses.students.web.StudentsController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
class StudentsSmokeTests {

    @Autowired
    private StudentsController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
