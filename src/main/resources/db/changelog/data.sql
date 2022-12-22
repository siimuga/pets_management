-- liquibase formatted sql

-- changeset liquibase:2
INSERT INTO country (id, name) VALUES (DEFAULT, 'Estonia');
INSERT INTO country (id, name) VALUES (DEFAULT, 'Latvia');
INSERT INTO country (id, name) VALUES (DEFAULT, 'Lithuania');
INSERT INTO country (id, name) VALUES (DEFAULT, 'Finland');
INSERT INTO country (id, name) VALUES (DEFAULT, 'Sweden');
INSERT INTO country (id, name) VALUES (DEFAULT, 'Norway');

INSERT INTO fur_color (id, name) VALUES (DEFAULT, 'Black');
INSERT INTO fur_color (id, name) VALUES (DEFAULT, 'White');
INSERT INTO fur_color (id, name) VALUES (DEFAULT, 'Brown');
INSERT INTO fur_color (id, name) VALUES (DEFAULT, 'Yellow');
INSERT INTO fur_color (id, name) VALUES (DEFAULT, 'Blue');

INSERT INTO type (id, name) VALUES (DEFAULT, 'Cat');
INSERT INTO type (id, name) VALUES (DEFAULT, 'Dog');
INSERT INTO type (id, name) VALUES (DEFAULT, 'Horse');
INSERT INTO type (id, name) VALUES (DEFAULT, 'Rabbit');
INSERT INTO type (id, name) VALUES (DEFAULT, 'Parrot');