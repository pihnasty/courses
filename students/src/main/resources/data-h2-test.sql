INSERT INTO students (email, name, password, active) VALUES
('admin@example.com', 'Admin', 'admin', TRUE),
('alice-test@example.com', 'Alice Johnson', 'passAlice123', TRUE),
('bob-test@example.com', 'Bob Smith', 'bobSecure456', TRUE),
('carol-test@example.com', 'Carol White', 'carolPwd789', TRUE),
('david-test@example.com', 'David Brown', 'dav!dPwd321', TRUE),
('eva-test@example.com', 'Eva Green', 'evaSecret987', TRUE),
('frank-test@example.com', 'Frank Harris', 'fr4nkStrongPwd', TRUE),
('grace-test@example.com', 'Grace Lee', 'gracePwd432', TRUE),
('henry-test@example.com', 'Henry Adams', 'h3nrySafePass', TRUE),
('irene-test@example.com', 'Irene Lewis', 'iren3TopPwd', TRUE),
('jack-test@example.com', 'Jack Walker', 'jackPwd654', TRUE),
('test@example.com', 'Test', 'test', TRUE);

-- admin@example.com
INSERT INTO student_roles (email, roles) VALUES
('admin@example.com', 'STUDENT'),
('admin@example.com', 'TEACHER'),
('admin@example.com', 'ADMIN');

-- alice@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('alice-test@example.com', 'STUDENT');

-- bob@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('bob-test@example.com', 'STUDENT');

-- carol@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('carol-test@example.com', 'STUDENT');

-- david@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('david-test@example.com', 'STUDENT');

-- eva@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('eva-test@example.com', 'STUDENT');

-- frank@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('frank-test@example.com', 'STUDENT');

-- grace@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('grace-test@example.com', 'STUDENT');

-- henry@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('henry-test@example.com', 'STUDENT');

-- irene@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('irene-test@example.com', 'STUDENT');

-- jack@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('jack-test@example.com', 'STUDENT');

-- test@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES
('test@example.com', 'STUDENT'),
('test@example.com', 'ADMIN');
