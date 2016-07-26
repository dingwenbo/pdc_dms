delete from pdc_member where role_id != 1; /* 删除除管理员外的所有角色 */
delete from pdc_project;
delete from pdc_project_member;
delete from pdc_task_status;
delete from pdc_task;
delete from pdc_log_detail;

/*
	普通测试用户的密码统一为:user
	测试用户的id统一为9开头
*/
insert into pdc_member(id, pdc_id, password, salt, name, role_id, gender, register_date)
	values(9002, 'T000002', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM1', 2, '男', now());
	
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9003, 'T000003', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL1', 3, 9002, '女', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9004, 'T000004', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE1', 4, 9003, '男', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9005, 'T000005', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试SE2', 4, 9003, '女', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9006, 'T000006', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV1', 5, 9004, '男', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9007, 'T000007', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV2', 5, 9005, '女',  now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9008, 'T000008', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV3', 5, 9005, '男', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9009, 'T000009', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试DEV4', 5, 9005, '女', now());

insert into pdc_member(id, pdc_id, password, salt, name, role_id, gender, register_date)
	values(9010, 'T000010', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试PM2', 2, '男', now());
insert into pdc_member(id, pdc_id, password, salt, name, role_id, supervisor_id, gender, register_date)
	values(9011, 'T000011', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b', '6d65d24122c30500', '测试TL2', 3, 9010, '女', now());

insert into pdc_project(id, code, full_name, label) values(1, 'PMM', 'PxxMxxMxx', 'First Test project'); 
insert into pdc_project(id, code, full_name, label) values(2, 'Q3P', 'Qxx3Pxx', 'Second Test project');
insert into pdc_project(id, code, full_name, label) values(3, 'LTP', 'LxxTxxPxx', 'Third Test project');

insert into pdc_project_member(project_id, member_id) values(1, 9002);
insert into pdc_project_member(project_id, member_id) values(1, 9003);
insert into pdc_project_member(project_id, member_id) values(1, 9004);
insert into pdc_project_member(project_id, member_id) values(1, 9005);
insert into pdc_project_member(project_id, member_id) values(1, 9006);
insert into pdc_project_member(project_id, member_id) values(1, 9007);
insert into pdc_project_member(project_id, member_id) values(1, 9008);
insert into pdc_project_member(project_id, member_id) values(1, 9009);
insert into pdc_project_member(project_id, member_id) values(2, 9010);
insert into pdc_project_member(project_id, member_id) values(2, 9011);

insert into pdc_task_status(id, code) values(1, 'In progress');
insert into pdc_task_status(id, code) values(2, 'Finished');
insert into pdc_task_status(id, code) values(3, 'TODO');
insert into pdc_task_status(id, code) values(4, 'Pending');

insert into pdc_task(id, project_id, code, title, status_id, percent, comment) values(1, 1, 'TASK-01', 'TEST-TASK-01', 1, '20%', 'no comment');
insert into pdc_task(id, project_id, code, title, status_id, percent, comment) values(2, 1, 'TASK-02', 'TEST-TASK-02', 2, '50%', 'comment');

insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(1, 9002, now(), 0.5, null);
insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(1, 9003, now(), 1, null);
insert into pdc_log_detail(task_id, member_id, day, work_time, absent) values(2, 9002, now(), 0.25, null);
