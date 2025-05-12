create table public.users
(
    created_at  date,
    modified_at date,
    premium     boolean,
    user_age    integer not null,
    id          uuid    not null
        primary key,
    email       varchar(255)
        unique,
    name        varchar(255),
    status      varchar(255)
        constraint users_status_check
            check ((status)::text = ANY
        ((ARRAY ['ACTIVE'::character varying, 'BANNED'::character varying, 'DELETED'::character varying])::text[]))
    );

alter table public.users
    owner to postgres;

