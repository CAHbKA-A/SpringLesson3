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

DROP DATABASE IF EXISTS "GB_Shop";
--
-- Name: GB_Shop; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "GB_Shop" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE "GB_Shop" OWNER TO postgres;

\connect "GB_Shop"

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
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    category_id bigint NOT NULL,
    namecategory character varying(255) NOT NULL,
    pathurl character varying(255)
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
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    order_id integer NOT NULL,
    order_customer_id integer,
    order_total_cost integer,
    order_status character varying(255),
    order_update date
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
    categoryid_product bigint,
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

INSERT INTO public.categories (category_id, name_category, path_url) VALUES (1, 'Catregory1', '1');
INSERT INTO public.categories (category_id, name_category, path_url) VALUES (2, 'Catregory2', '2');
INSERT INTO public.categories (category_id, name_category, path_url) VALUES (3, 'Catregory3', '3');
INSERT INTO public.categories (category_id, name_category, path_url) VALUES (4, 'Catregory4', '4');


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (1, 'Alex', 0);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (2, 'Balex', 100);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (3, 'Salex', 222);
INSERT INTO public.customers (customer_id, customer_name, customer_balance) VALUES (4, 'Malex', 655);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update) VALUES (1, 1, 123, 'added', '2021-10-27');
INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update) VALUES (2, 2, 24324, 'added', '2021-10-26');
INSERT INTO public.orders (order_id, order_customer_id, order_total_cost, order_status, order_update) VALUES (3, 3, 24544, 'added', '2021-10-28');


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

INSERT INTO public.product_category (id_product, category_id) VALUES (1, 2);
INSERT INTO public.product_category (id_product, category_id) VALUES (1, 3);
INSERT INTO public.product_category (id_product, category_id) VALUES (1, 1);
INSERT INTO public.product_category (id_product, category_id) VALUES (2, 2);
INSERT INTO public.product_category (id_product, category_id) VALUES (3, 2);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products (id_product, title_product, cost_product, description_product, categoryid_product, imglink_product) VALUES (1, 'product1', 123, 'blahbla2h1', 23, 'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, categoryid_product, imglink_product) VALUES (2, 'product2', 1223, 'blaheblah1', 23, 'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, categoryid_product, imglink_product) VALUES (3, 'product3', 1223, 'blahblah1', 24, 'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, categoryid_product, imglink_product) VALUES (4, 'product4', 4123, 'blaheblah1', 23, 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg');
INSERT INTO public.products (id_product, title_product, cost_product, description_product, categoryid_product, imglink_product) VALUES (5, 'product5', 1523, 'blaheblah1', 23, 'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg');


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_category_id_seq', 1, false);


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_customer_id_seq', 4, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: orders_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_order_id_seq', 3, true);


--
-- Name: products_id_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_product_seq', 1, false);


--
-- Name: categories categories_namecategory_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_namecategory_key UNIQUE (name_category);


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
-- Name: orders_order_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX orders_order_id_uindex ON public.orders USING btree (order_id);


--
-- Name: orders_products fk43vke5jd6eyasd92t3k24kdxq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_products
    ADD CONSTRAINT fk43vke5jd6eyasd92t3k24kdxq FOREIGN KEY (product_id) REFERENCES public.products(id_product);


--
-- Name: product_category fkdswxvx2nl2032yjv609r29sdr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT fkdswxvx2nl2032yjv609r29sdr FOREIGN KEY (category_id) REFERENCES public.categories(category_id);


--
-- Name: orders_products fke4y1sseio787e4o5hrml7omt5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_products
    ADD CONSTRAINT fke4y1sseio787e4o5hrml7omt5 FOREIGN KEY (order_id) REFERENCES public.orders(order_id);


--
-- Name: product_category fkgmq8cej1itivj3b6qtbon6r45; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_category
    ADD CONSTRAINT fkgmq8cej1itivj3b6qtbon6r45 FOREIGN KEY (id_product) REFERENCES public.products(id_product);


--
-- Name: orders fkra4bew2s7yd898e6skwtmqw1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkra4bew2s7yd898e6skwtmqw1 FOREIGN KEY (order_customer_id) REFERENCES public.customers(customer_id);


--
-- PostgreSQL database dump complete
--

