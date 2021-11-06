BEGIN;


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id_product          bigserial PRIMARY KEY,
    title_product       VARCHAR(255),
    cost_product        int,
    description_product VARCHAR(255),

    imgLink_product     VARCHAR(255)
);
INSERT INTO products (title_product, cost_product, description_product,  imgLink_product)
VALUES ('product1', 123, 'blahbla2h1',  'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg'),
       ('product2', 1223, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg'),
       ('product3', 1223, 'blahblah1',  'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg'),
       ('product4', 4123, 'blaheblah1',         'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg'),
       ('pr7oduct5', 1523, 'blaheblah1',  'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg'),
       ('produc6t1', 123, 'blahbla2h1',  'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg'),
       ('pro5duct2', 1223, 'blaheblah1',  'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg'),
       ('prod4uct3', 1223, 'blahblah1',  'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg'),
       ('produ3ct4', 4123, 'blaheblah1',
        'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg'),
       ('prod2uct5', 1523, 'blaheblah1', 'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg'),
       ('p4rod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prtbvrod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('cvbprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('cprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('vprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('pbrod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prtbvrod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('cvbprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('cprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('vprod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('pbrod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prbod2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('pronmd2uct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg'),
       ('prod2muct5', 1523, 'blaheblah1',
        'https://image.shutterstock.com/image-vector/chain-icon-trendy-flat-style-600w-2058354959.jpg');

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories
(
    category_id  bigserial PRIMARY KEY not null,
    name_Category VARCHAR(255)          not null unique,
    path_Url      VARCHAR(255)          not null,
    parent_id    bigint,
        foreign key (parent_id) references categories(category_id)
);
INSERT INTO categories (category_id, name_category, path_url, parent_id) VALUES (10, '234', '324', null);
INSERT INTO categories (category_id, name_category, path_url, parent_id) VALUES (11, 'y54ygfdgdf', 'gfdgfdg54', null);
INSERT INTO categories (category_id, name_category, path_url, parent_id) VALUES (12, 'y5erwdfg', 'gfdgfdgfd', null);
INSERT INTO categories (category_id, name_category, path_url, parent_id) VALUES (13, 'Мясо2', '645п', 10);
INSERT INTO categories (category_id, name_category, path_url, parent_id) VALUES (14, 'gffbgfng', 'fghtrh46', 10);

DROP TABLE IF EXISTS customers CASCADE;
create table customers
(
    customer_id      serial,
    customer_name    varchar(255) not null,
    customer_balance int default 0
);

create unique index customers_id_uindex
    on customers (customer_id);

alter table customers
    add constraint customers_pk
        primary key (customer_id);

INSERT INTO customers (customer_name, customer_balance)
VALUES ('Alex', 0),
       ('Balex', 100),
       ('Salex', 222),
       ('Malex', 655);



DROP TABLE IF EXISTS orders CASCADE;
create table orders
(
    order_id          serial
        constraint orders_pk
            primary key,
    order_customer_id integer,
    order_total_cost  integer,
    order_status      varchar(255),
    order_update      date
);


create unique index orders_order_id_uindex
    on orders (order_id);

INSERT INTO orders (order_customer_id, order_total_cost, order_status, order_update)
VALUES (1, 123, 'added', '2021-10-27'),
       (2, 24324, 'added', '2021-10-26'),
       (3, 24544, 'added', '2021-10-28');


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
       (2, 4, 100, 5),
       (1, 1, 100, 2),
       (3, 4, 100, 23),
       (2, 4, 100, 5);


DROP TABLE IF EXISTS product_category CASCADE;
create table product_category
(
    id_product  integer not null,
    category_id integer not null,
    constraint product_category_pkey
        primary key (id_product, category_id)
);


INSERT INTO product_category (id_product, category_id)
VALUES (1, 10),
       (1, 13),
       (1, 11),
       (2, 10),
       (3, 12);



COMMIT;

