create schema if not exists blog;

create table if not exists blog.user(
    user_id uuid primary key,
    username text not null,
    first_name text not null,
    last_name text not null,
    password text not null,
    is_incognito_mode boolean not null
);