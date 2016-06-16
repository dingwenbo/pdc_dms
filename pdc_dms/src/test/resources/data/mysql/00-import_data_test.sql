/*
	普通测试用户的密码统一为:user
*/
insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date)
	values(9002, 'T000002', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM1', 2, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9003, 'T000003', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL1', 3, 9002, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9004, 'T000004', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE1', 4, 9003, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9005, 'T000005', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE2', 4, 9003, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9006, 'T000006', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV1', 5, 9004 now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9007, 'T000007', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV2', 5, 9005 now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9008, 'T000008', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV3', ,5 9005 now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9009, 'T000009', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV4', 5, 9005 now());

insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date)
	values(9010, 'T000010', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM2', 2, now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9011, 'T000011', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL2', 3, 9010, now());

insert into pdc_project(id, code, label) values(1, 'TEST1', 'First Test project'); 
insert into pdc_project(id, code, label) values(2, 'TEST2', 'Second Test project');
insert into pdc_project(id, code, label) values(3, 'TEST3', 'Third Test project');

insert into pdc_project_member(project_id, member_id) values(1, 9002);
insert into pdc_project_member(project_id, member_id) values(1, 9003);
insert into pdc_project_member(project_id, member_id) values(2, 9010);

