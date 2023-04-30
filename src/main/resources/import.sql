insert into role (id_role,name,enabled) values (1,'ADMIN',true);
insert into role(id_role,name,enabled) values (2,'USER',true);

insert into user_data (id_user,enabled, password, username, id_role) values (1,true, '$2y$10$h/Y8vk2jXPBftWohq2afL.63Ch4Szwox7/rYE1CpzSq/Q.ITouLO6','mito',1);
insert into user_data (id_user,enabled, password, username, id_role) values (2,true, '$2y$10$h/Y8vk2jXPBftWohq2afL.63Ch4Szwox7/rYE1CpzSq/Q.ITouLO6','code',2);
