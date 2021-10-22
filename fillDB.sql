BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id          bigserial PRIMARY KEY,
    title       VARCHAR(255),
    cost        int,
    description VARCHAR(255),
    categoryId  bigint,
    imgLink     VARCHAR(255)
);
INSERT INTO products (id, title,cost,description,categoryId,imgLink)
VALUES
(1, 'product1' ,123, 'blahbla2h1',23,'https://upload.wikimedia.org/wikipedia/commons/8/8e/An-2_Lutsk.jpg'),
 (2, 'product2' ,1223, 'blaheblah1',23,'https://upload.wikimedia.org/wikipedia/commons/9/97/MiG-23P_Lutsk.jpg'),
 (3, 'product3' ,1223, 'blahblah1',24,'https://upload.wikimedia.org/wikipedia/commons/6/60/Su-24_Lutsk.jpg'),
 (4, 'product4' ,4123, 'blaheblah1',23,'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Military_aircraft_in_Lutsk.jpg/1280px-Military_aircraft_in_Lutsk.jpg'),
 (5, 'product5' ,1523, 'blaheblah1',23,'https://upload.wikimedia.org/wikipedia/commons/e/e1/PM-38_Lutsk.jpg');


COMMIT;