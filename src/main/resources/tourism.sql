--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2022-06-25 12:35:41

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
-- TOC entry 218 (class 1259 OID 16524)
-- Name: bookings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bookings (
    id integer NOT NULL,
    tourist_id integer NOT NULL,
    tour_id integer NOT NULL,
    paid boolean DEFAULT false NOT NULL
);


ALTER TABLE public.bookings OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16523)
-- Name: bookings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bookings_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bookings_id_seq OWNER TO postgres;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 217
-- Name: bookings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bookings_id_seq OWNED BY public.bookings.id;


--
-- TOC entry 210 (class 1259 OID 16489)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    role character varying(12) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16488)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 209
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 216 (class 1259 OID 16517)
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status (
    id integer NOT NULL,
    tour_status character varying(25) NOT NULL
);


ALTER TABLE public.status OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16516)
-- Name: status_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_id_seq OWNER TO postgres;

--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 215
-- Name: status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.status_id_seq OWNED BY public.status.id;


--
-- TOC entry 220 (class 1259 OID 16559)
-- Name: tour_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tour_types (
    id integer NOT NULL,
    type character varying(25) NOT NULL
);


ALTER TABLE public.tour_types OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16558)
-- Name: tour_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tour_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tour_types_id_seq OWNER TO postgres;

--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 219
-- Name: tour_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tour_types_id_seq OWNED BY public.tour_types.id;


--
-- TOC entry 214 (class 1259 OID 16503)
-- Name: tours; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tours (
    id integer NOT NULL,
    status_id integer NOT NULL,
    description character varying(100) NOT NULL,
    capacity integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    price money NOT NULL,
    booked integer NOT NULL,
    type_id integer NOT NULL
);


ALTER TABLE public.tours OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16502)
-- Name: tours_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tours_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tours_id_seq OWNER TO postgres;

--
-- TOC entry 3373 (class 0 OID 0)
-- Dependencies: 213
-- Name: tours_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tours_id_seq OWNED BY public.tours.id;


--
-- TOC entry 212 (class 1259 OID 16496)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    surname character varying(30) NOT NULL,
    email character varying(40),
    role_id integer NOT NULL,
    login character varying(20) NOT NULL,
    password integer NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16495)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3374 (class 0 OID 0)
-- Dependencies: 211
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3193 (class 2604 OID 16527)
-- Name: bookings id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings ALTER COLUMN id SET DEFAULT nextval('public.bookings_id_seq'::regclass);


--
-- TOC entry 3189 (class 2604 OID 16492)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3192 (class 2604 OID 16520)
-- Name: status id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status ALTER COLUMN id SET DEFAULT nextval('public.status_id_seq'::regclass);


--
-- TOC entry 3195 (class 2604 OID 16562)
-- Name: tour_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tour_types ALTER COLUMN id SET DEFAULT nextval('public.tour_types_id_seq'::regclass);


--
-- TOC entry 3191 (class 2604 OID 16506)
-- Name: tours id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tours ALTER COLUMN id SET DEFAULT nextval('public.tours_id_seq'::regclass);


--
-- TOC entry 3190 (class 2604 OID 16499)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3361 (class 0 OID 16524)
-- Dependencies: 218
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bookings (id, tourist_id, tour_id, paid) FROM stdin;
\.


--
-- TOC entry 3353 (class 0 OID 16489)
-- Dependencies: 210
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role) FROM stdin;
1	admin
2	tourist
\.


--
-- TOC entry 3359 (class 0 OID 16517)
-- Dependencies: 216
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status (id, tour_status) FROM stdin;
1	valid
2	hot
3	running_or_expired
4	canceled
\.


--
-- TOC entry 3363 (class 0 OID 16559)
-- Dependencies: 220
-- Data for Name: tour_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tour_types (id, type) FROM stdin;
1	beach
2	excursion
\.


--
-- TOC entry 3357 (class 0 OID 16503)
-- Dependencies: 214
-- Data for Name: tours; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tours (id, status_id, description, capacity, start_date, end_date, price, booked, type_id) FROM stdin;
2	1	Walking tour of Minsk	20	2022-07-05	2022-07-05	$10.00	0	2
1	1	Bus tour to Lepel	12	2022-07-02	2022-07-04	$50.00	0	1
\.


--
-- TOC entry 3355 (class 0 OID 16496)
-- Dependencies: 212
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, name, surname, email, role_id, login, password) FROM stdin;
3	John	LaSalle	john@mail.ru	1	johnlasalle	1
4	Michael	Solomon	mike@gmail.com	2	mikes	11
5	Peter	Gabriel	pete@outlook.com	2	peter	55
\.


--
-- TOC entry 3375 (class 0 OID 0)
-- Dependencies: 217
-- Name: bookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bookings_id_seq', 1, false);


--
-- TOC entry 3376 (class 0 OID 0)
-- Dependencies: 209
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 2, true);


--
-- TOC entry 3377 (class 0 OID 0)
-- Dependencies: 215
-- Name: status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.status_id_seq', 4, true);


--
-- TOC entry 3378 (class 0 OID 0)
-- Dependencies: 219
-- Name: tour_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tour_types_id_seq', 2, true);


--
-- TOC entry 3379 (class 0 OID 0)
-- Dependencies: 213
-- Name: tours_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tours_id_seq', 2, true);


--
-- TOC entry 3380 (class 0 OID 0)
-- Dependencies: 211
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 5, true);


--
-- TOC entry 3205 (class 2606 OID 16530)
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);


--
-- TOC entry 3197 (class 2606 OID 16494)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3203 (class 2606 OID 16522)
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 16564)
-- Name: tour_types tour_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tour_types
    ADD CONSTRAINT tour_types_pkey PRIMARY KEY (id);


--
-- TOC entry 3201 (class 2606 OID 16508)
-- Name: tours tours_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tours
    ADD CONSTRAINT tours_pkey PRIMARY KEY (id);


--
-- TOC entry 3199 (class 2606 OID 16501)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3212 (class 2606 OID 16546)
-- Name: bookings booking_tour_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT booking_tour_fk FOREIGN KEY (tour_id) REFERENCES public.tours(id) NOT VALID;


--
-- TOC entry 3211 (class 2606 OID 16541)
-- Name: bookings booking_tourist_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT booking_tourist_fk FOREIGN KEY (tourist_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3209 (class 2606 OID 16536)
-- Name: tours tour_status_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tours
    ADD CONSTRAINT tour_status_fk FOREIGN KEY (status_id) REFERENCES public.status(id) NOT VALID;


--
-- TOC entry 3210 (class 2606 OID 16565)
-- Name: tours tour_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tours
    ADD CONSTRAINT tour_type_fk FOREIGN KEY (type_id) REFERENCES public.tour_types(id) NOT VALID;


--
-- TOC entry 3208 (class 2606 OID 16531)
-- Name: users user_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_role_fk FOREIGN KEY (role_id) REFERENCES public.roles(id) NOT VALID;


-- Completed on 2022-06-25 12:35:41

--
-- PostgreSQL database dump complete
--

