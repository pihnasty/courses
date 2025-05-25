package com.courses.students.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Arrays;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="STUDENT")
public class Student {
    @Id
    @NotBlank(message = "Email can not be empty")
    @NotNull(message = "Email can not be null")
    private String email;

    @NotBlank(message = "Name can not be empty")
    @NotNull(message = "Name can not be null")
    private String name;

    @NotBlank(message = "Password can not be empty")
    @NotNull(message = "Password can not be null")
    @Size(min = 2, message = "Password must be at least 2 characters long")
    private String password;

    @Singular("role")
    private List<Role> roles;

    private boolean active;

    public void setStudentRole(Role... studentRoles){
        this.roles = Arrays.asList(studentRoles);
    }
}
