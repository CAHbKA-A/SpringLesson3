--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0

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

DROP DATABASE IF EXISTS postgres;
--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

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
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    category_id bigint NOT NULL,
    name_category character varying(255) NOT NULL,
    path_url character varying(255) NOT NULL,
    parent_id bigint
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_category_id_seq OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_category_id_seq OWNED BY public.categories.category_id;


--
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    customer_id integer NOT NULL,
    customer_name character varying(255) NOT NULL,
    customer_balance integer DEFAULT 0
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customers_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_customer_id_seq OWNER TO postgres;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;


--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    order_id integer NOT NULL,
    order_customer_id integer,
    order_total_cost integer,
    order_status character varying(255),
    order_update date,
    order_create date
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_order_id_seq OWNER TO postgres;

--
-- Name: orders_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_order_id_seq OWNED BY public.orders.order_id;


--
-- Name: orders_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders_products (
    order_id integer NOT NULL,
    product_id integer,
    cost integer DEFAULT 0,
    count integer DEFAULT 0
);


ALTER TABLE public.orders_products OWNER TO postgres;

--
-- Name: product_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_category (
    id_product integer NOT NULL,
    category_id integer NOT NULL
);


ALTER TABLE public.product_category OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id_product bigint NOT NULL,
    title_product character varying(255),
    cost_product integer,
    description_product character varying(255),
    imglink_product character varying(255)
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_id_product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_product_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_product_seq OWNER TO postgres;

--
-- Name: products_id_product_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_product_seq OWNED BY public.products.id_product;


--
-- Name: categories category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN category_id SET DEFAULT nextval('public.categories_category_id_seq'::regclass);


--
-- Name: customers customer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);


--
-- Name: orders order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN order_id SET DEFAULT nextval('public.orders_order_id_seq'::regclass);


--
-- Name: products id_product; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id_product SET DEFAULT nextval('public.products_id_product_seq'::regclass);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.categories (category_id, name_category, path_url, parent_id) VALUES (10, '234', '324', NULL);
INSERT INTO public.categories (category_id, name_category, path_url, parent_id) VALUES (11, 'y54ygfdgdf', 'gfdgfdg54', NULL);
INSERT INTO public.categories (category_id, name_category, path_url, parent_id) VALUES (12, 'y5erwdfg', 'gfdgfdgfd', NULL);
INSERT INTO public.categories (category_id, name_category, path_url, parent_id) VALUES (13, 'Мясо2', '645п', 10);
INSERT INTO public.categories (category_id, name_category, path_url, parent_id) VALUES (14, 'gffbgfng', 'fghtrh46', 10);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (1, 'Alex', 0);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (2, 'Balex', 100);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (3, 'Salex', 222);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (4, 'Malex', 655);


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) VALUES (1, '1.0.1', 'init', 'SQL', 'V1.0.1__init.sql', -61362389, 'postgres', '2021-11-07 02:13:36.56535', 476, true);
INSERT INTO public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) VALUES (2, '1.0.2', 'init', 'SQL', 'V1.0.2__init.sql', -1178891113, 'postgres', '2021-11-07 02:13:37.082392', 480, true);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update, order_create) VALUES (1, 1, 123, 'added', '2021-10-27', NULL);
INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update, order_create) VALUES (2, 2, 24324, 'added', '2021-10-26', NULL);
INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update, order_create) VALUES (3, 3, 24544, 'added', '2021-10-28', NULL);


--
-- Data for Name: orders_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (1, 1, 100, 2);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (1, 2, 200, 1);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (2, 1, 100, 2);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (2, 4, 100, 5);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (1, 1, 100, 2);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (3, 4, 100, 23);
INSERT INTO public.orders_products (order_id, product_id, cost, count) VALUES (2, 4, 100, 5);


--
-- Data for Name: product_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product_category (id_product, category_id) VALUES (1, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (1, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (1, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (2, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (2, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (4, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (5, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (6, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (7, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (8, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (9, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (10, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (11, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (12, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (13, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (12, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (14, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (15, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (16, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (17, 13);
INSERT INTO public.product_category (id_product, category_id) VALUES (18, 11);
INSERT INTO public.product_category (id_product, category_id) VALUES (17, 10);
INSERT INTO public.product_category (id_product, category_id) VALUES (20, 12);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (1, 'product1', 123, 'blahbla2h1', 'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (2, 'product2', 1223, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (3, 'product3', 1223, 'blahblah1', 'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (4, 'product4', 4123, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (5, 'pr7oduct5', 1523, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (6, 'produc6t1', 123, 'blahbla2h1', 'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (7, 'pro5duct2', 1223, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (8, 'prod4uct3', 1223, 'blahblah1', 'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (9, 'produ3ct4', 4123, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (10, 'prod2uct5', 1523, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (11, 'p4rod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (12, 'prod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (13, 'prtbvrod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (14, 'prod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (15, 'cvbprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (16, 'cprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (17, 'vprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (18, 'pbrod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (19, 'prod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (20, 'prtbvrod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (21, 'prod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (22, 'cvbprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (23, 'cprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (24, 'vprod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (25, 'pbrod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (26, 'prbod2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (27, 'pronmd2uct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, imglink_product) VALUES (28, 'prod2muct5', 1523, 'blaheblah1', 'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_category_id_seq', 1, false);


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_customer_id_seq', 4, true);


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_order_id_seq', 3, true);


--
-- Name: products_id_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_product_seq', 28, true);


--
-- Name: categories categories_name_category_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_name_category_key UNIQUE (name_category);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: customers customers_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pk PRIMARY KEY (customer_id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: orders orders_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pk PRIMARY KEY (order_id);


--
-- Name: product_category product_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT product_category_pkey PRIMARY KEY (id_product, category_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id_product);


--
-- Name: customers_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX customers_id_uindex ON public.customers USING btree (customer_id);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: orders_order_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX orders_order_id_uindex ON public.orders USING btree (order_id);


--
-- Name: categories categories_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.categories(category_id);


--
-- PostgreSQL database dump complete
--

