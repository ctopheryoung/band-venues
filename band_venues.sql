--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.0
-- Dumped by pg_dump version 9.5.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: band_venues; Type: TABLE; Schema: public; Owner: topher
--

CREATE TABLE band_venues (
    id integer NOT NULL,
    band_id integer,
    venue_id integer
);


ALTER TABLE band_venues OWNER TO topher;

--
-- Name: band_venues_id_seq; Type: SEQUENCE; Schema: public; Owner: topher
--

CREATE SEQUENCE band_venues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE band_venues_id_seq OWNER TO topher;

--
-- Name: band_venues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: topher
--

ALTER SEQUENCE band_venues_id_seq OWNED BY band_venues.id;


--
-- Name: bands; Type: TABLE; Schema: public; Owner: topher
--

CREATE TABLE bands (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE bands OWNER TO topher;

--
-- Name: bands_id_seq; Type: SEQUENCE; Schema: public; Owner: topher
--

CREATE SEQUENCE bands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bands_id_seq OWNER TO topher;

--
-- Name: bands_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: topher
--

ALTER SEQUENCE bands_id_seq OWNED BY bands.id;


--
-- Name: venues; Type: TABLE; Schema: public; Owner: topher
--

CREATE TABLE venues (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE venues OWNER TO topher;

--
-- Name: venues_id_seq; Type: SEQUENCE; Schema: public; Owner: topher
--

CREATE SEQUENCE venues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venues_id_seq OWNER TO topher;

--
-- Name: venues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: topher
--

ALTER SEQUENCE venues_id_seq OWNED BY venues.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: topher
--

ALTER TABLE ONLY band_venues ALTER COLUMN id SET DEFAULT nextval('band_venues_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: topher
--

ALTER TABLE ONLY bands ALTER COLUMN id SET DEFAULT nextval('bands_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: topher
--

ALTER TABLE ONLY venues ALTER COLUMN id SET DEFAULT nextval('venues_id_seq'::regclass);


--
-- Data for Name: band_venues; Type: TABLE DATA; Schema: public; Owner: topher
--

COPY band_venues (id, band_id, venue_id) FROM stdin;
\.


--
-- Name: band_venues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: topher
--

SELECT pg_catalog.setval('band_venues_id_seq', 1, false);


--
-- Data for Name: bands; Type: TABLE DATA; Schema: public; Owner: topher
--

COPY bands (id, name) FROM stdin;
\.


--
-- Name: bands_id_seq; Type: SEQUENCE SET; Schema: public; Owner: topher
--

SELECT pg_catalog.setval('bands_id_seq', 1, false);


--
-- Data for Name: venues; Type: TABLE DATA; Schema: public; Owner: topher
--

COPY venues (id, name) FROM stdin;
\.


--
-- Name: venues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: topher
--

SELECT pg_catalog.setval('venues_id_seq', 1, false);


--
-- Name: band_venues_pkey; Type: CONSTRAINT; Schema: public; Owner: topher
--

ALTER TABLE ONLY band_venues
    ADD CONSTRAINT band_venues_pkey PRIMARY KEY (id);


--
-- Name: bands_pkey; Type: CONSTRAINT; Schema: public; Owner: topher
--

ALTER TABLE ONLY bands
    ADD CONSTRAINT bands_pkey PRIMARY KEY (id);


--
-- Name: venues_pkey; Type: CONSTRAINT; Schema: public; Owner: topher
--

ALTER TABLE ONLY venues
    ADD CONSTRAINT venues_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: topher
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM topher;
GRANT ALL ON SCHEMA public TO topher;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

