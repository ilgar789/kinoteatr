CREATE TABLE t_user_roles
(
    user_id  BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    CONSTRAINT pk_t_user_roles PRIMARY KEY (user_id, roles_id)
);

ALTER TABLE t_user_roles
    ADD CONSTRAINT fk_tuserol_on_role FOREIGN KEY (roles_id) REFERENCES t_role (id);

ALTER TABLE t_user_roles
    ADD CONSTRAINT fk_tuserol_on_user FOREIGN KEY (user_id) REFERENCES t_user (id);