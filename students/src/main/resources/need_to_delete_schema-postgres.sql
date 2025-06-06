--SELECT current_user;
--CREATE DATABASE studentsdb;
--SELECT email, roles
--FROM public.student_roles;
--SELECT email, "name", "password", active
--FROM public.students;

-- Drop tables if they exist
DROP TABLE IF EXISTS student_roles CASCADE;
DROP TABLE IF EXISTS students CASCADE;

-- Create students table
CREATE TABLE students (
    email VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);

-- Create student_roles table
CREATE TABLE student_roles (
    email VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL,
    FOREIGN KEY (email) REFERENCES students(email) ON DELETE CASCADE
);
