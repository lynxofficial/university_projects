--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

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
-- Name: applicant_specialty; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applicant_specialty (
    applicant_id integer NOT NULL,
    specialty_id integer NOT NULL
);


ALTER TABLE public.applicant_specialty OWNER TO postgres;

--
-- Name: applicants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applicants (
    applicant_id integer NOT NULL,
    last_name character varying,
    first_name character varying,
    middle_name character varying,
    phone character varying,
    email character varying,
    points integer
);


ALTER TABLE public.applicants OWNER TO postgres;

--
-- Name: applicants_applicant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.applicants_applicant_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.applicants_applicant_id_seq OWNER TO postgres;

--
-- Name: applicants_applicant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.applicants_applicant_id_seq OWNED BY public.applicants.applicant_id;


--
-- Name: specialties; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specialties (
    specialty_id integer NOT NULL,
    specialty_code character varying,
    specialty_name character varying,
    quota integer
);


ALTER TABLE public.specialties OWNER TO postgres;

--
-- Name: specialties_specialty_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.specialties_specialty_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.specialties_specialty_id_seq OWNER TO postgres;

--
-- Name: specialties_specialty_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.specialties_specialty_id_seq OWNED BY public.specialties.specialty_id;


--
-- Name: applicants applicant_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants ALTER COLUMN applicant_id SET DEFAULT nextval('public.applicants_applicant_id_seq'::regclass);


--
-- Name: specialties specialty_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialties ALTER COLUMN specialty_id SET DEFAULT nextval('public.specialties_specialty_id_seq'::regclass);


--
-- Data for Name: applicant_specialty; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: applicants; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.applicants (applicant_id, last_name, first_name, middle_name, phone, email, points) VALUES (3, 'Clark', 'James', 'Ivanovich', '+79184613848', 'test@mail.com', 254);
INSERT INTO public.applicants (applicant_id, last_name, first_name, middle_name, phone, email, points) VALUES (4, 'Johns', 'John', 'Pkasfm', '+79594613375', 'example2@mail.com', 255);
INSERT INTO public.applicants (applicant_id, last_name, first_name, middle_name, phone, email, points) VALUES (2, 'Sidorov', 'Ivan', 'Ivanovich', '+79184613841', 'example@mail.com', 159);


--
-- Data for Name: specialties; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.specialties (specialty_id, specialty_code, specialty_name, quota) VALUES (1, '02.03.03', 'software and administration of information systems', 2);


--
-- Name: applicants_applicant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.applicants_applicant_id_seq', 4, true);


--
-- Name: specialties_specialty_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.specialties_specialty_id_seq', 1, true);


--
-- Name: applicant_specialty applicant_specialty_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicant_specialty
    ADD CONSTRAINT applicant_specialty_pk PRIMARY KEY (applicant_id, specialty_id);


--
-- Name: applicants applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (applicant_id);


--
-- Name: specialties specialties_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialties
    ADD CONSTRAINT specialties_pkey PRIMARY KEY (specialty_id);


--
-- Name: applicant_specialty applicant_specialty_applicants_applicant_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicant_specialty
    ADD CONSTRAINT applicant_specialty_applicants_applicant_id_fk FOREIGN KEY (applicant_id) REFERENCES public.applicants(applicant_id);


--
-- Name: applicant_specialty applicant_specialty_specialties_specialty_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicant_specialty
    ADD CONSTRAINT applicant_specialty_specialties_specialty_id_fk FOREIGN KEY (specialty_id) REFERENCES public.specialties(specialty_id);


--
-- PostgreSQL database dump complete
--

