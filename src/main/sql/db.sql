CREATE TABLE IF NOT EXISTS customer(
                                       id bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                                       first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    email varchar(255) UNIQUE,
    address varchar(255) NOT NULL,
    date_of_birth date,
    created_at timestamp,
    customer_type varchar
    );
create table IF NOT EXISTS item(
                                   id bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                                   name varchar(255),
    customer_id int REFERENCES customer(id) ON DELETE SET NULL
    );

create table IF NOT EXISTS public.custom_user(
                                          id bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                                          username varchar(255),
    password varchar(255)
    );
insert into custom_user(username, password) VALUES ('admin', 'admin');