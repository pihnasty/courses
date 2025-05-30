--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: student_roles; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.student_roles (
    email character varying(255) NOT NULL,
    roles character varying(255) NOT NULL
);


ALTER TABLE public.student_roles OWNER TO admin;

--
-- Name: students; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.students (
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    active boolean NOT NULL
);


ALTER TABLE public.students OWNER TO admin;

--
-- Data for Name: student_roles; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.student_roles (email, roles) FROM stdin;
admin@example.com	STUDENT
admin@example.com	TEACHER
admin@example.com	ADMIN
alice-postgres@example.com	STUDENT
bob@example.com	STUDENT
carol@example.com	STUDENT
david@example.com	STUDENT
eva@example.com	STUDENT
frank@example.com	STUDENT
grace@example.com	STUDENT
henry@example.com	STUDENT
irene@example.com	STUDENT
jack@example.com	STUDENT
test@example.com	STUDENT
test@example.com	ADMIN
\.


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.students (email, name, password, active) FROM stdin;
admin@example.com	Admin	$2a$10$FVtkW.syUD9vBn2qyR/1X.aJqId70A8Y3VMkyggPearWxyCPhUSAS	t
alice-postgres@example.com	Alice Johnson	$2a$10$d0ERqv2HUUIUcIkAqcGIa.zoT3SmYLwD2SvR7jyFNngaioq228NLm	t
bob@example.com	Bob Smith	$2a$10$ZC6CWNeY2Ilt.I0W7ZffGuFnyihSlumRTfKPqnA0pObevFu8KlNDq	t
carol@example.com	Carol White	$2a$10$RZ5T0FtSmf4RobZZDSaSQubrFjPHcPv7R67m3bP.mSWJZl086zWwq	t
david@example.com	David Brown	$2a$10$Vlr2TjbGm2vv.rHILIWjXOw.oAyZym.b/afOcpUbujw33saGHTCWm	t
eva@example.com	Eva Green	$2a$10$/V0gv2wi/KgwURoJwVPu6.Jcoz5HnNdKfKOoYw8HifJWyPsy5jPxS	t
frank@example.com	Frank Harris	$2a$10$z80TiUyRQpjNnJEoqhujzuovJ.mDzyMORwLu1oI1G.9YTpYiQgyYK	t
grace@example.com	Grace Lee	$2a$10$SUrfJcDamPSl5I3N3jWG4OgFHQX4dgi6cA78OfgQUCSABNOLWvfY.	t
henry@example.com	Henry Adams	$2a$10$K8ZO653uDiSj7M9O19ABvO0V6K4GDCm4pcrWobimXE67WR1QytqOK	t
irene@example.com	Irene Lewis	$2a$10$Ta1Vh8pkO.g1y6lNeve3..mjowWAAvYgJcpkpoH9UL6pmUPV5kCDi	t
jack@example.com	Jack Walker	$2a$10$DtwK4bkes7e9H8LUWU9piuDvyinG8rTtKu/89b5xyHhrXMo4odmlW	t
test@example.com	Test	$2a$10$jF.GApl9MDKckgtv.Ej50.IfZLy2K059ycd0nqpyz5pqAPBqhqlhO	t
\.


--
-- Name: students students_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (email);


--
-- Name: student_roles student_roles_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.student_roles
    ADD CONSTRAINT student_roles_email_fkey FOREIGN KEY (email) REFERENCES public.students(email) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

