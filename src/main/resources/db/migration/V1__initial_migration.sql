create table users
(
    id       bigserial
        constraint user_id_pk
            primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null
);

alter table users
    owner to postgres;

create table addresses
(
    id      bigserial
        constraint addresses_id_pk primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    zip     varchar(255) not null,
    user_id bigint       not null
        constraint addresses_user_id_fk
            references users
);

alter table addresses
    owner to postgres;

