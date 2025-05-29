DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS student_roles CASCADE;
CREATE TABLE students (
    email VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);
CREATE TABLE student_roles (
    email VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL,
    FOREIGN KEY (email) REFERENCES students(email)
);
