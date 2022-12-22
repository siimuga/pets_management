-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE IF NOT EXISTS country (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT country_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS fur_color (
                           id serial  NOT NULL,
                           name varchar(255)  NOT NULL,
                           CONSTRAINT fur_color_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS type (
                                    id serial  NOT NULL,
                                    name varchar(255)  NOT NULL,
                                    CONSTRAINT type_pk PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS pet (
                     id serial  NOT NULL,
                     name varchar(255)  NOT NULL,
                     code int  NOT NULL,
                     type_id int  NOT NULL,
                     fur_color_id int  NOT NULL,
                     country_id int  NOT NULL,
                     CONSTRAINT pet_pk PRIMARY KEY (id)
);

ALTER TABLE pet ADD CONSTRAINT pet_country
    FOREIGN KEY (country_id)
        REFERENCES country (id)
        NOT DEFERRABLE
;
ALTER TABLE pet ADD CONSTRAINT pet_fur_color
    FOREIGN KEY (fur_color_id)
        REFERENCES fur_color (id)
        NOT DEFERRABLE
;
ALTER TABLE pet ADD CONSTRAINT pet_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
;