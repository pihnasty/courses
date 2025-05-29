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
admin@example.com	Admin	admin	t
alice-postgres@example.com	Alice Johnson	passAlice123	t
bob@example.com	Bob Smith	bobSecure456	t
carol@example.com	Carol White	carolPwd789	t
david@example.com	David Brown	dav!dPwd321	t
eva@example.com	Eva Green	evaSecret987	t
frank@example.com	Frank Harris	fr4nkStrongPwd	t
grace@example.com	Grace Lee	gracePwd432	t
henry@example.com	Henry Adams	h3nrySafePass	t
irene@example.com	Irene Lewis	iren3TopPwd	t
jack@example.com	Jack Walker	jackPwd654	t
test@example.com	Test	test	t
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

