CREATE TABLE coffee_order (
                             id BIGSERIAL NOT NULL,
                             coffee_id BIGINT NOT NULL,
                             count INTEGER default 0,
                             capacity INTEGER default 0,
                             PRIMARY KEY (id),
                             CONSTRAINT fk_coffee_id FOREIGN KEY (coffee_id) REFERENCES coffee(id)
);

COMMENT ON COLUMN coffee_order.id IS 'Первичный ключ';
COMMENT ON COLUMN coffee_order.coffee_id IS 'ID кофе';
COMMENT ON COLUMN coffee_order.capacity IS 'Вместимость в мл';
COMMENT ON COLUMN coffee_order.count IS 'Количество заказа';