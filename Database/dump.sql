--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

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

--
-- Name: acd; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA acd;


ALTER SCHEMA acd OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: enrollees; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.enrollees (
    registration_number integer NOT NULL,
    specialty_code integer,
    achievements boolean
);


ALTER TABLE acd.enrollees OWNER TO postgres;

--
-- Name: enrollees_registration_number_seq; Type: SEQUENCE; Schema: acd; Owner: postgres
--

CREATE SEQUENCE acd.enrollees_registration_number_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acd.enrollees_registration_number_seq OWNER TO postgres;

--
-- Name: enrollees_registration_number_seq; Type: SEQUENCE OWNED BY; Schema: acd; Owner: postgres
--

ALTER SEQUENCE acd.enrollees_registration_number_seq OWNED BY acd.enrollees.registration_number;


--
-- Name: exam_scores; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.exam_scores (
    registration_number integer,
    exam_score_1 integer,
    exam_score_2 integer,
    exam_score_3 integer,
    exam_scores_id integer NOT NULL
);


ALTER TABLE acd.exam_scores OWNER TO postgres;

--
-- Name: exam_scores_exam_score_id_seq; Type: SEQUENCE; Schema: acd; Owner: postgres
--

CREATE SEQUENCE acd.exam_scores_exam_score_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acd.exam_scores_exam_score_id_seq OWNER TO postgres;

--
-- Name: exam_scores_exam_score_id_seq; Type: SEQUENCE OWNED BY; Schema: acd; Owner: postgres
--

ALTER SEQUENCE acd.exam_scores_exam_score_id_seq OWNED BY acd.exam_scores.exam_scores_id;


--
-- Name: faculties; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.faculties (
    faculty_code integer NOT NULL,
    faculty_name character varying(100),
    exam_1 character varying(100),
    exam_2 character varying(100),
    exam_3 character varying(100)
);


ALTER TABLE acd.faculties OWNER TO postgres;

--
-- Name: faculties_faculty_code_seq; Type: SEQUENCE; Schema: acd; Owner: postgres
--

CREATE SEQUENCE acd.faculties_faculty_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE acd.faculties_faculty_code_seq OWNER TO postgres;

--
-- Name: faculties_faculty_code_seq; Type: SEQUENCE OWNED BY; Schema: acd; Owner: postgres
--

ALTER SEQUENCE acd.faculties_faculty_code_seq OWNED BY acd.faculties.faculty_code;


--
-- Name: forms; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.forms (
    last_name character varying(100),
    first_name character varying(100),
    middle_name character varying(100),
    date_of_birthday character varying(30),
    country character varying(100),
    city character varying(100),
    education_establishment character varying(100),
    registration_number integer,
    form_id integer NOT NULL
);


ALTER TABLE acd.forms OWNER TO postgres;

--
-- Name: results; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.results (
    registration_number integer,
    enrollment boolean,
    result_id integer NOT NULL
);


ALTER TABLE acd.results OWNER TO postgres;

--
-- Name: specialties; Type: TABLE; Schema: acd; Owner: postgres
--

CREATE TABLE acd.specialties (
    specialty_code integer NOT NULL,
    specialty_name character varying(100),
    faculty_code integer,
    admission_plan integer
);


ALTER TABLE acd.specialties OWNER TO postgres;

--
-- Name: enrollees registration_number; Type: DEFAULT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.enrollees ALTER COLUMN registration_number SET DEFAULT nextval('acd.enrollees_registration_number_seq'::regclass);


--
-- Name: exam_scores exam_scores_id; Type: DEFAULT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.exam_scores ALTER COLUMN exam_scores_id SET DEFAULT nextval('acd.exam_scores_exam_score_id_seq'::regclass);


--
-- Name: faculties faculty_code; Type: DEFAULT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.faculties ALTER COLUMN faculty_code SET DEFAULT nextval('acd.faculties_faculty_code_seq'::regclass);


--
-- Data for Name: enrollees; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.enrollees (registration_number, specialty_code, achievements) FROM stdin;
\.


--
-- Data for Name: exam_scores; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.exam_scores (registration_number, exam_score_1, exam_score_2, exam_score_3, exam_scores_id) FROM stdin;
\.


--
-- Data for Name: faculties; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.faculties (faculty_code, faculty_name, exam_1, exam_2, exam_3) FROM stdin;
100	Faculty1	Math	Physics	Russian language
\.


--
-- Data for Name: forms; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.forms (last_name, first_name, middle_name, date_of_birthday, country, city, education_establishment, registration_number, form_id) FROM stdin;
\.


--
-- Data for Name: results; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.results (registration_number, enrollment, result_id) FROM stdin;
\.


--
-- Data for Name: specialties; Type: TABLE DATA; Schema: acd; Owner: postgres
--

COPY acd.specialties (specialty_code, specialty_name, faculty_code, admission_plan) FROM stdin;
\.


--
-- Name: enrollees_registration_number_seq; Type: SEQUENCE SET; Schema: acd; Owner: postgres
--

SELECT pg_catalog.setval('acd.enrollees_registration_number_seq', 1, false);


--
-- Name: exam_scores_exam_score_id_seq; Type: SEQUENCE SET; Schema: acd; Owner: postgres
--

SELECT pg_catalog.setval('acd.exam_scores_exam_score_id_seq', 1, false);


--
-- Name: faculties_faculty_code_seq; Type: SEQUENCE SET; Schema: acd; Owner: postgres
--

SELECT pg_catalog.setval('acd.faculties_faculty_code_seq', 1, false);


--
-- Name: enrollees enrollees_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.enrollees
    ADD CONSTRAINT enrollees_pk PRIMARY KEY (registration_number);


--
-- Name: exam_scores exam_scores_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.exam_scores
    ADD CONSTRAINT exam_scores_pk PRIMARY KEY (exam_scores_id);


--
-- Name: faculties faculties_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.faculties
    ADD CONSTRAINT faculties_pk PRIMARY KEY (faculty_code);


--
-- Name: forms forms_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.forms
    ADD CONSTRAINT forms_pk PRIMARY KEY (form_id);


--
-- Name: results results_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.results
    ADD CONSTRAINT results_pk PRIMARY KEY (result_id);


--
-- Name: specialties specialties_pk; Type: CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.specialties
    ADD CONSTRAINT specialties_pk PRIMARY KEY (specialty_code);


--
-- Name: exam_scores_exam_score_id_uindex; Type: INDEX; Schema: acd; Owner: postgres
--

CREATE UNIQUE INDEX exam_scores_exam_score_id_uindex ON acd.exam_scores USING btree (exam_scores_id);


--
-- Name: faculties_faculty_name_uindex; Type: INDEX; Schema: acd; Owner: postgres
--

CREATE UNIQUE INDEX faculties_faculty_name_uindex ON acd.faculties USING btree (faculty_name);


--
-- Name: results_result_id_uindex; Type: INDEX; Schema: acd; Owner: postgres
--

CREATE UNIQUE INDEX results_result_id_uindex ON acd.results USING btree (result_id);


--
-- Name: enrollees enrollees_specialties_specialty_code_fk; Type: FK CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.enrollees
    ADD CONSTRAINT enrollees_specialties_specialty_code_fk FOREIGN KEY (specialty_code) REFERENCES acd.specialties(specialty_code);


--
-- Name: exam_scores exam_scores_enrollees_registration_number_fk; Type: FK CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.exam_scores
    ADD CONSTRAINT exam_scores_enrollees_registration_number_fk FOREIGN KEY (registration_number) REFERENCES acd.enrollees(registration_number);


--
-- Name: forms forms_enrollees_registration_number_fk; Type: FK CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.forms
    ADD CONSTRAINT forms_enrollees_registration_number_fk FOREIGN KEY (registration_number) REFERENCES acd.enrollees(registration_number);


--
-- Name: results results_enrollees_registration_number_fk; Type: FK CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.results
    ADD CONSTRAINT results_enrollees_registration_number_fk FOREIGN KEY (registration_number) REFERENCES acd.enrollees(registration_number);


--
-- Name: specialties specialties_faculties_faculty_code_fk; Type: FK CONSTRAINT; Schema: acd; Owner: postgres
--

ALTER TABLE ONLY acd.specialties
    ADD CONSTRAINT specialties_faculties_faculty_code_fk FOREIGN KEY (faculty_code) REFERENCES acd.faculties(faculty_code);


--
-- PostgreSQL database dump complete
--

