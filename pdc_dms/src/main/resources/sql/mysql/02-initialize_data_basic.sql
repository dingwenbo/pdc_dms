delete from pdc_project;
delete from pdc_member;
delete from pdc_role;

insert into pdc_role(id, code, label, prior) values(1, 'Admin', 'Administrator of PDC-DMS', 0);
insert into pdc_role(id, code, label, prior) values(2, 'PM', 'Project manager', 1);
insert into pdc_role(id, code, label, prior) values(3, 'TL', 'Team Leader', 2);
insert into pdc_role(id, code, label, prior) values(4, 'SE', 'Senior engineer', 3);
insert into pdc_role(id, code, label, prior) values(5, 'DEV', 'Developer', 4);

/* 插入超管, 密码为admin */
insert into pdc_member(id, pdc_id, password, salt, name, role_id, phone, email, register_date) 
	values(9001, 'A000000', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', '系统管理员', 1, '13864795216', 'test@test.com', now());
