INSERT INTO students (email, name, password, active) VALUES
('admin@example.com', 'Admin', '$2a$10$FVtkW.syUD9vBn2qyR/1X.aJqId70A8Y3VMkyggPearWxyCPhUSAS', TRUE),
('alice@example.com', 'Alice Johnson', '$2a$10$d0ERqv2HUUIUcIkAqcGIa.zoT3SmYLwD2SvR7jyFNngaioq228NLm', TRUE),
('bob@example.com', 'Bob Smith', '$2a$10$ZC6CWNeY2Ilt.I0W7ZffGuFnyihSlumRTfKPqnA0pObevFu8KlNDq', TRUE),
('carol@example.com', 'Carol White', '$2a$10$RZ5T0FtSmf4RobZZDSaSQubrFjPHcPv7R67m3bP.mSWJZl086zWwq', TRUE),
('david@example.com', 'David Brown', '$2a$10$Vlr2TjbGm2vv.rHILIWjXOw.oAyZym.b/afOcpUbujw33saGHTCWm', TRUE),
('eva@example.com', 'Eva Green', '$2a$10$/V0gv2wi/KgwURoJwVPu6.Jcoz5HnNdKfKOoYw8HifJWyPsy5jPxS', TRUE),
('frank@example.com', 'Frank Harris', '$2a$10$z80TiUyRQpjNnJEoqhujzuovJ.mDzyMORwLu1oI1G.9YTpYiQgyYK', TRUE),
('grace@example.com', 'Grace Lee', '$2a$10$SUrfJcDamPSl5I3N3jWG4OgFHQX4dgi6cA78OfgQUCSABNOLWvfY.', TRUE),
('henry@example.com', 'Henry Adams', '$2a$10$K8ZO653uDiSj7M9O19ABvO0V6K4GDCm4pcrWobimXE67WR1QytqOK', TRUE),
('irene@example.com', 'Irene Lewis', '$2a$10$Ta1Vh8pkO.g1y6lNeve3..mjowWAAvYgJcpkpoH9UL6pmUPV5kCDi', TRUE),
('jack@example.com', 'Jack Walker', '$2a$10$DtwK4bkes7e9H8LUWU9piuDvyinG8rTtKu/89b5xyHhrXMo4odmlW', TRUE),
('test@example.com', 'Test', '$2a$10$jF.GApl9MDKckgtv.Ej50.IfZLy2K059ycd0nqpyz5pqAPBqhqlhO', TRUE);

-- admin@example.com
INSERT INTO student_roles (email, roles) VALUES
('admin@example.com', 'STUDENT'),
('admin@example.com', 'TEACHER'),
('admin@example.com', 'ADMIN');

-- alice@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('alice@example.com', 'STUDENT');

-- bob@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('bob@example.com', 'STUDENT');

-- carol@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('carol@example.com', 'STUDENT');

-- david@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('david@example.com', 'STUDENT');

-- eva@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('eva@example.com', 'STUDENT');

-- frank@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('frank@example.com', 'STUDENT');

-- grace@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('grace@example.com', 'STUDENT');

-- henry@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('henry@example.com', 'STUDENT');

-- irene@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('irene@example.com', 'STUDENT');

-- jack@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('jack@example.com', 'STUDENT');

-- test@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES
('test@example.com', 'STUDENT'),
('test@example.com', 'ADMIN');
