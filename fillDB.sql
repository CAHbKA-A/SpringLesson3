BEGIN;


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id_product          bigserial PRIMARY KEY,
    title_product       VARCHAR(255),
    cost_product        int,
    description_product VARCHAR(255),
    categoryId_product  bigint,
    imgLink_product     VARCHAR(255)
);
INSERT INTO products (id_product, title_product, cost_product, description_product, categoryId_product, imgLink_product)
VALUES (1, 'product1', 123, 'blahbla2h1', 23, 'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg'),
       (2, 'product2', 1223, 'blaheblah1', 23, 'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg'),
       (3, 'product3', 1223, 'blahblah1', 24, 'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg'),
       (4, 'product4', 4123, 'blaheblah1', 23,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg'),
       (5, 'product5', 1523, 'blaheblah1', 23, 'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg');



DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories
(
    category_id  bigserial PRIMARY KEY,
    nameCategory VARCHAR(255) not null unique,
    pathUrl      VARCHAR(255)
);
INSERT INTO categories (category_id, nameCategory, pathUrl)
VALUES (1, 'Catregory1', '1'),
       (2, 'Catregory2', '2'),
       (3, 'Catregory3', '3'),
       (4, 'Catregory4', '4');



DROP TABLE IF EXISTS customers CASCADE;
create table customers
(
    id               serial,
    customer_name    varchar(255) not null,
    customer_balance int default 0
);

create unique index customers_id_uindex
    on customers (id);

alter table customers
    add constraint customers_pk
        primary key (id);

INSERT INTO customers (customer_name, customer_balance)
VALUES ('Alex', 0),
       ('Balex', 100),
       ('Salex', 222),
       ('Malex', 655);



DROP TABLE IF EXISTS orders CASCADE;
create table orders
(
    order_id     serial
        constraint orders_pk
            primary key,
    customer_id  integer,
    total_cost   integer,
    order_status varchar(255),
    order_update date
);


create unique index orders_order_id_uindex
    on orders (order_id);

INSERT INTO orders (customer_id, total_cost, order_status, order_update)
VALUES (1, 123, 'added', '2021-10-27'),
       (2, 24324, 'added', '2021-10-26');


DROP TABLE IF EXISTS orders_products CASCADE;
create table orders_products
(
    order_id   integer not null,
    product_id integer,
    cost       integer default 0,
    count      integer default 0
);

INSERT INTO orders_products (order_id, product_id, cost, count)
VALUES (1, 1, 100, 2),
       (1, 2, 200, 1),
       (2, 1, 100, 2),
       (2, 4, 100, 5);


COMMIT;

