CREATE TABLE product (
                         id BIGSERIAL NOT NULL,
                         name VARCHAR(100) NULL,
                         count INTEGER default 0,
                         PRIMARY KEY (id)
);