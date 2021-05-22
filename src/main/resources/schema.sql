create table if not exists user(
id int identity,
username varchar(255) not null unique,
password varchar(255) not null,
email varchar(255) not null,
primary key (id)
);

create table if not exists post(
id int identity,
comment varchar(255) not null,
timestamp timestamp not null,
userid int not null,
primary key (id),
constraint fk_userid foreign key (userid) references user(id) on delete cascade
);

-- create table if not exists user(
-- id       identity,
--     username varchar(100) not null,
--     password varchar(250) not null,
--     first_name varchar(250) not null,
--     last_name varchar(250) not null
--     );

create table if not exists authority(
id   identity,
name varchar(100) not null
);

create table if not exists user_authority(
user_id      bigint not null,
authority_id bigint not null,
constraint fk_user foreign key (user_id) references user(id),
constraint fk_authority foreign key (authority_id) references authority(id)
);