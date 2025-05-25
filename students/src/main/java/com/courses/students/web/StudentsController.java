package com.courses.students.web;

import com.courses.students.model.Student;
import com.courses.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentsController {

    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAll(){
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Student> findStudentById(@PathVariable String email) {
        return ResponseEntity.of(this.studentRepository.findById(email));
    }

    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public ResponseEntity<Student> save(@RequestBody Student student){
       this.studentRepository.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(student.getEmail())
                .toUri();
        return ResponseEntity.created(location).body(student);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable String email){
        this.studentRepository.deleteById(email);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}

