ALTER TABLE users
    ADD email VARCHAR(255) NOT NULL;

ALTER TABLE users
    ADD password VARCHAR(255) NOT NULL;

ALTER TABLE users
    ADD CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);

ALTER TABLE currencies
    ADD CONSTRAINT uka2yxotynwqjrmkq71won77vui UNIQUE (name);
