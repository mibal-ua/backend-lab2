CREATE SEQUENCE IF NOT EXISTS categories_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS currencies_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS records_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS users_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE categories
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE currencies
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_currencies PRIMARY KEY (id)
);

CREATE TABLE records
(
    id          BIGINT                      NOT NULL,
    user_id     BIGINT                      NOT NULL,
    category_id BIGINT                      NOT NULL,
    timestamp   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    amount      BIGINT                      NOT NULL,
    currency_id BIGINT                      NOT NULL,
    CONSTRAINT pk_records PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                  BIGINT       NOT NULL,
    name                VARCHAR(255) NOT NULL,
    default_currency_id BIGINT       NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE records
    ADD CONSTRAINT FK_RECORDS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE records
    ADD CONSTRAINT FK_RECORDS_ON_CURRENCY FOREIGN KEY (currency_id) REFERENCES currencies (id);

ALTER TABLE records
    ADD CONSTRAINT FK_RECORDS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_DEFAULT_CURRENCY FOREIGN KEY (default_currency_id) REFERENCES currencies (id);
