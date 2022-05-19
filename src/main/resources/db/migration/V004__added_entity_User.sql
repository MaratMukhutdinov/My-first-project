CREATE TABLE app_user
(
    id          BIGSERIAL    NOT NULL,
    username    VARCHAR(100) NOT NULL UNIQUE,
    first_name  VARCHAR(100),
    middle_name VARCHAR(100),
    last_name   VARCHAR(100),
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(100) NOT NULL,
    role        VARCHAR(100) NOT NULL,
    deleted     BOOLEAN default false,

    PRIMARY KEY (id)
);

COMMENT ON COLUMN app_user.id IS 'Первичный ключ';
COMMENT ON COLUMN app_user.username IS 'Логин пользователя';
COMMENT ON COLUMN app_user.first_name IS 'Имя пользователя';
COMMENT ON COLUMN app_user.middle_name IS 'Отчество пользователя';
COMMENT ON COLUMN app_user.last_name IS 'Фамилия пользователя';
COMMENT ON COLUMN app_user.email IS 'Email пользователя';
COMMENT ON COLUMN app_user.password IS 'Пароль в зашифрованном виде';
COMMENT ON COLUMN app_user.role IS 'Роль';
COMMENT ON COLUMN app_user.deleted IS 'Признак удаленности';