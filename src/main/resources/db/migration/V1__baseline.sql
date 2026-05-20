-- auto-generated baseline by DatabaseCreationService

CREATE TABLE users (
password VARCHAR(255),
updated_at TIMESTAMP,
last_name VARCHAR(255),
created_at TIMESTAMP,
phone_number VARCHAR(255),
id BIGINT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(255),
email VARCHAR(255),
CONSTRAINT pk_users PRIMARY KEY (id)
);