use pdc_dms;

delete from pdc_role;
delete from pdc_member;

insert into pdc_role(id, code, label) values(1, 'Admin', 'Administrator of PDC-DMS');
insert into pdc_role(id, code, label) values(2, 'PM', 'Project manager');
insert into pdc_role(id, code, label) values(3, 'TL', 'Team Leader');
insert into pdc_role(id, code, label) values(4, 'SE', 'Senior engineer');
insert into pdc_role(id, code, label) values(5, 'DEV', 'Developer');

insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date) 
	values(1, 'A000000', '691b14d79bf0fa2215f155235df5e670b64394cc', '7efbd59d9741d34f', "系统管理员", 1, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, reigster_date)
	values(2, 'A000001', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', "测试用户(PM)", 2, now());