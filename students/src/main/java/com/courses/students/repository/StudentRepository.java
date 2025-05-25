package com.courses.students.repository;

import com.courses.students.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,String>{

}
