insert into user (id, username, password, email)
values (1, 'admin', '$2y$12$.OWb.CCkBYZIiTy2rLWsHeK11DatFWgMk/bVY0TSfg7HeTG3GmXWm', 'admin@admin.com'); --password=test
insert into user (id, username, password, email)
values (2, 'user', '$2y$12$.OWb.CCkBYZIiTy2rLWsHeK11DatFWgMk/bVY0TSfg7HeTG3GmXWm', 'user@user.com'); --password=test

insert into post (id, comment, timestamp, userid)
values (1, 'Admin comment', '2020-01-01 12:10:00', 1);
insert into post (id, comment, timestamp, userid)
values (2, 'User comment', '2020-04-01 10:30:00', 2);

insert into authority (id, name)
values (1, 'ROLE_ADMIN');
insert into authority (id, name)
values (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values (1, 1);
insert into user_authority (user_id, authority_id)
values (2, 2);
