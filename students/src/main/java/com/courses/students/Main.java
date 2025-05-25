package com.courses.students;

import com.courses.students.model.Role;

public class Main {
    public static void main(String[] args) {
        var admin = Role.ADMIN.name();
        System.out.println(admin);
    }
}
