CREATE TABLE T_USER (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE T_TRANSACTION (
    id BIGSERIAL PRIMARY KEY,
    userId BIGINT,
    paymentMethod VARCHAR(255),
    amount DOUBLE PRECISION,
    status VARCHAR(255),
    role VARCHAR(255),
    CONSTRAINT fk_t_user FOREIGN KEY (userId) REFERENCES t_user(id)
);