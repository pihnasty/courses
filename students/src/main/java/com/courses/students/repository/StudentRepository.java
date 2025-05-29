package com.courses.students.repository;

import com.courses.students.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,String>{
    Optional<Student> findByEmail(String email);
    void deleteByEmail(String email);
}
