CREATE TABLE coffee
(
    id   BIGSERIAL    NOT NULL,
    name VARCHAR(100) NOT NULL,
    deleted BOOLEAN default false,
    balance BIGINT default 0,

    PRIMARY KEY (id)
);

COMMENT ON COLUMN coffee.id IS 'Первичный ключ';
COMMENT ON COLUMN coffee.name IS 'Наименование кофе';
COMMENT ON COLUMN coffee.deleted IS 'Признак удаленности';
COMMENT ON COLUMN coffee.balance IS 'Остаток в мл';

INSERT INTO coffee (name, deleted, balance) VALUES ('Latte', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Americano', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Espresso', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Cappuccino', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Macchiato', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Cortado', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Iced Coffee', false, 100000);
INSERT INTO coffee (name, deleted, balance) VALUES ('Frappe', false, 100000);