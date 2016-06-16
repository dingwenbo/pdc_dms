delete from pdc_project;
delete from pdc_member;
delete from pdc_role;

insert into pdc_role(id, code, label) values(1, 'Admin', 'Administrator of PDC-DMS');
insert into pdc_role(id, code, label) values(2, 'PM', 'Project manager');
insert into pdc_role(id, code, label) values(3, 'TL', 'Team Leader');
insert into pdc_role(id, code, label) values(4, 'SE', 'Senior engineer');
insert into pdc_role(id, code, label) values(5, 'DEV', 'Developer');

/* 插入超管, 密码为admin */
insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date) 
	values(9001, 'A000000', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', "系统管理员", 1, now());
