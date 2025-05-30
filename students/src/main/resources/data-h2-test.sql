INSERT INTO students (email, name, password, active) VALUES
('admin@example.com', 'Admin', '$2a$10$FVtkW.syUD9vBn2qyR/1X.aJqId70A8Y3VMkyggPearWxyCPhUSAS', TRUE),
('alice-test@example.com', 'Alice Johnson', '$2a$10$d0ERqv2HUUIUcIkAqcGIa.zoT3SmYLwD2SvR7jyFNngaioq228NLm', TRUE),
('bob-test@example.com', 'Bob Smith', '$2a$10$ZC6CWNeY2Ilt.I0W7ZffGuFnyihSlumRTfKPqnA0pObevFu8KlNDq', TRUE),
('carol-test@example.com', 'Carol White', '$2a$10$RZ5T0FtSmf4RobZZDSaSQubrFjPHcPv7R67m3bP.mSWJZl086zWwq', TRUE),
('david-test@example.com', 'David Brown', '$2a$10$Vlr2TjbGm2vv.rHILIWjXOw.oAyZym.b/afOcpUbujw33saGHTCWm', TRUE),
('eva-test@example.com', 'Eva Green', '$2a$10$/V0gv2wi/KgwURoJwVPu6.Jcoz5HnNdKfKOoYw8HifJWyPsy5jPxS', TRUE),
('frank-test@example.com', 'Frank Harris', '$2a$10$z80TiUyRQpjNnJEoqhujzuovJ.mDzyMORwLu1oI1G.9YTpYiQgyYK', TRUE),
('grace-test@example.com', 'Grace Lee', '$2a$10$SUrfJcDamPSl5I3N3jWG4OgFHQX4dgi6cA78OfgQUCSABNOLWvfY.', TRUE),
('henry-test@example.com', 'Henry Adams', '$2a$10$K8ZO653uDiSj7M9O19ABvO0V6K4GDCm4pcrWobimXE67WR1QytqOK', TRUE),
('irene-test@example.com', 'Irene Lewis', '$2a$10$Ta1Vh8pkO.g1y6lNeve3..mjowWAAvYgJcpkpoH9UL6pmUPV5kCDi', TRUE),
('jack-test@example.com', 'Jack Walker', '$2a$10$DtwK4bkes7e9H8LUWU9piuDvyinG8rTtKu/89b5xyHhrXMo4odmlW', TRUE),
('test_deleting@example.com', 'TestDeleting', '$2a$10$HOG57Cxoc/E.d8U7upmsAuprEAREQu8W9tDVdcBGH6wha/TFSXqRS', TRUE),
('test@example.com', 'Test', '$2a$10$jF.GApl9MDKckgtv.Ej50.IfZLy2K059ycd0nqpyz5pqAPBqhqlhO', TRUE);

-- admin@example.com
INSERT INTO student_roles (email, roles) VALUES
('admin@example.com', 'STUDENT'),
('admin@example.com', 'TEACHER'),
('admin@example.com', 'ADMIN');

-- test_deleting@example.com
INSERT INTO STUDENT_ROLES (email, roles) VALUES ('test_deleting@example.com', 'STUDENT');

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
