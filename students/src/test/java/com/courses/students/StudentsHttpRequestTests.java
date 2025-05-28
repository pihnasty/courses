package com.courses.students;

import com.courses.students.config.StudentConfig;
import com.courses.students.model.Role;
import com.courses.students.model.Student;
import com.courses.students.security.StudentsSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.context.annotation.Import;
import java.util.List;


@Import({StudentsSecurityConfig.class, StudentConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentsHttpRequestTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void indexPageShouldReturnHeaderOneContentTest() {
        var html = this.restTemplate
                .withBasicAuth(TestConstants.TEST_EMAIL, TestConstants.TEST_PASSWORD)
                .getForObject("/", String.class);
        assertThat(html).contains("Students Rest Application");
    }

    @Test
    public void studentsEndPointShouldReturnCollectionWithTwoStudents() {
        var response = this.restTemplate
                .withBasicAuth(TestConstants.TEST_EMAIL, TestConstants.TEST_PASSWORD)
                .getForObject(TestConstants.STUDENTS_ENDPOINT, Collection.class);
        assertThat(response.size()).isGreaterThan(1);
    }

    @Test
    public void studentEndPointPostNewStudentShouldReturnStudent() {
        var initialStudents = getStudents();
        var size = initialStudents.size();
        var newStudent = new Student(
                TestConstants.NEW_TEST_EMAIL,
                TestConstants.NEW_TEST_NAME,
                TestConstants.NEW_TEST_PASSWORD,
                List.of(Role.STUDENT),
                true);
        var response =  this.restTemplate
                .withBasicAuth(TestConstants.TEST_EMAIL, TestConstants.TEST_PASSWORD)
                .postForObject(TestConstants.STUDENTS_ENDPOINT,newStudent, Student.class);

        assertThat(response).isNotNull();
        assertThat(response.getEmail()).isEqualTo(newStudent.getEmail());

        var students = getStudents();

        assertThat(students.size()).isEqualTo(size + 1);
    }

    @Test
    public void studentEndPointDeleteStudentShouldReturnVoid() {
        var initialStudents = getStudents();
        var size = initialStudents.size();

        this.restTemplate
                .withBasicAuth(TestConstants.ADMIN_EMAIL, TestConstants.ADMIN_PASSWORD)
                .delete(TestConstants.STUDENTS_ENDPOINT + "/" + TestConstants.TEST_DELETING_EMAIL);

        var students = getStudents();
        assertThat(students.size()).isLessThanOrEqualTo(size-1);
    }

    @Test
    public void studentsEndPointFindStudentShouldReturnStudent() {
        var student = this.restTemplate
                .withBasicAuth(TestConstants.ADMIN_EMAIL, TestConstants.ADMIN_PASSWORD)
                .getForObject(TestConstants.STUDENTS_ENDPOINT + "/" + TestConstants.TEST_EMAIL,Student.class);

        assertThat(student).isNotNull();
        assertThat(student.getEmail()).isEqualTo(TestConstants.TEST_EMAIL);
    }

    private Collection getStudents() {
        return this.restTemplate
                .withBasicAuth(TestConstants.ADMIN_EMAIL, TestConstants.ADMIN_PASSWORD)
                .getForObject(TestConstants.STUDENTS_ENDPOINT, Collection.class);
    }
}
