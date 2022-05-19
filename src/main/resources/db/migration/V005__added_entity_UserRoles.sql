CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT users_roles_pk PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_users_roles_user_id FOREIGN KEY (user_id) REFERENCES app_user (id),
    CONSTRAINT fk_users_roles_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);

INSERT INTO role(name)
VALUES ('ADMIN');
INSERT INTO app_user(username, email, password, role)
VALUES ('ADMIN', 'admin@mail.ru', '$2a$10$93aJI0V8UsKiGlPk1LINceSzwkg2aU6tqKyN/jyV3wz3o5Gv8fbdi', 'ADMIN');

INSERT INTO user_roles
(user_id,
 role_id)
SELECT au.id,
       (select id from role r WHERE r.name = 'ADMIN')
FROM app_user AS au
WHERE au.username = 'ADMIN';