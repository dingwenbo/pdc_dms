/* 删除除管理员外的所有角色 */
delete from pdc_member where role_id != 1;
delete from pdc_project;
delete from pdc_project_member;
delete from pdc_task_status;
delete from pdc_task;
delete from pdc_log_detail;

/*
	普通测试用户的密码统一为:user
	测试用户的id统一为9开头
*/
insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date)
	values(9002, 'T000002', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM1', 2, '2016-01-01');
	
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9003, 'T000003', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL1', 3, 9002, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9004, 'T000004', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE1', 4, 9003, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9005, 'T000005', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE2', 4, 9003, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9006, 'T000006', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV1', 5, 9004, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9007, 'T000007', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV2', 5, 9005, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9008, 'T000008', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV3', 5, 9005, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9009, 'T000009', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV4', 5, 9005, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9012, 'T000012', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '翻译DEV1', 5, 9002, '2016-01-01');

insert into pdc_member(id, pdc_id, password, salt, name, role_id, register_date)
	values(9010, 'T000010', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM2', 2, '2016-01-01');
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, register_date)
	values(9011, 'T000011', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL2', 3, 9010, '2016-01-01');

/* FJV2 项目的数据*/
insert into pdc_project(id, code, full_name, label, parent, manager) values(1, 'GPRO_Pyramide', 'GPRO and Pyramide Group', 'GPRO_Pyramide Group label.', 7, 9002); 
insert into pdc_project(id, code, full_name, label, parent, manager) values(2, 'Pyramide', 'Pyramide Full-name', 'Second Test project', 1, 9002);
insert into pdc_project(id, code, full_name, label, parent, manager) values(3, 'Pissaro', 'Pissaro Full-name', 'Third Test project', 1, 9002);
insert into pdc_project(id, code, full_name, label, parent, manager) values(4, 'Translation', 'Translation Full-name', 'Third Test project', 1, 9002);
insert into pdc_project(id, code, full_name, label, parent, manager) values(5, 'Sextant', 'Sextant Full-name', 'Third Test project', 7, 9002);
insert into pdc_project(id, code, full_name, label, parent, manager) values(6, 'STXBRUT', 'Sextant BRUT', 'Third Test project', 5, 9002);
insert into pdc_project(id, code, full_name, label, parent, manager) values(7, 'FJV2', 'PDC FJV2 Team', 'FJV2 Label', null, 9002);

/*PM1 -> GPRO_Pyramide*/
insert into pdc_project_member(project_id, member_id) values(1, 9002);
/*PM1 -> Sextant*/
insert into pdc_project_member(project_id, member_id) values(5, 9002);
/*PM1 -> FJV2*/
insert into pdc_project_member(project_id, member_id) values(7, 9002);
/*TL1 -> Pyramide*/
insert into pdc_project_member(project_id, member_id) values(2, 9003);
/*SE1 -> Pyramide*/
insert into pdc_project_member(project_id, member_id) values(2, 9004);
/*SE2 -> Pissaro*/
insert into pdc_project_member(project_id, member_id) values(3, 9005);
/*DEV1 -> Pyramide*/
insert into pdc_project_member(project_id, member_id) values(2, 9006);
/*DEV2 -> Pissaro*/
insert into pdc_project_member(project_id, member_id) values(3, 9007);
/*DEV3 -> Pyramide*/
insert into pdc_project_member(project_id, member_id) values(2, 9008);
/*DEV4 -> Pyramide*/
insert into pdc_project_member(project_id, member_id) values(2, 9009);
/*PM2 -> Sextant*/
insert into pdc_project_member(project_id, member_id) values(5, 9010);
/*TL2 -> STXBRUT*/
insert into pdc_project_member(project_id, member_id) values(6, 9011);
/*翻译DEV1 -> Translation*/
insert into pdc_project_member(project_id, member_id) values(4, 9012);

insert into pdc_task(id, project_id, code, title, status_id, percent, comment) values(1, 1, 'TASK-01', 'TEST-TASK-01', 1, '20%', 'no comment');
insert into pdc_task(id, project_id, code, title, status_id, percent, comment) values(2, 1, 'TASK-02', 'TEST-TASK-02', 2, '50%', 'comment');

insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(1, 9002, '2016-01-01', 0.5, null);
insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(1, 9003, '2016-01-01', 1, null);
insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(2, 9002, '2016-01-01', 0.25, null);
