/*
 * 主键的列名统一为id。
 * 为方便数据操作及维护，不建立任何外键，用程序去保证关联关系。
 * --为表名添加前缀以便日后管理。比如有几十个表，将联系比较紧密的表，使用相同的前缀。
 * 表名全小写，因为MySQL在Linux下默认区分表名大小写。
 */

drop table if exists pdc_profile_rights;
drop table if exists pdc_rights;
drop table if exists pdc_role_profile;
drop table if exists pdc_profile;
drop table if exists pdc_project_member;
drop table if exists pdc_log_detail;
drop table if exists pdc_member;
drop table if exists pdc_role;
drop table if exists pdc_task_status;
drop table if exists pdc_task;
drop table if exists pdc_project;
drop table if exists pdc_weekly_report;

/*
	角色表
*/
create table pdc_role (
	id int auto_increment,
	code varchar(10) not null,
	label varchar(30) not null,
	prior int,
	primary key(id)
);

/*
	成员信息表
*/
create table pdc_member (
	id int auto_increment,
	pdc_id varchar(10) not null unique, /*作为login name登录，由管理员创建*/
	password varchar(255) not null, 
	salt varchar(64),
	name varchar(20) not null,
	gender char(4) not null default '未知',
	role_id int,
	supervisor_id int,
	backup char(1) default '0',
	phone varchar(15),
	email varchar(30),
	register_date date,
	primary key(id)
);

/*
	项目信息表
*/
create table pdc_project (
	id int auto_increment,
	code varchar(20) not null,
	full_name varchar(50),
	label varchar(200), 
	parent int,
	manager int,
	primary key(id)
);

/*
	项目成员信息表
*/
create table pdc_project_member (
	project_id int,
	member_id int,
	primary key(project_id, member_id)
);

/*
	任务状态信息表
*/
create table pdc_task_status (
	id int auto_increment,
	code varchar(20) not null,
	primary key(id)
);

/*
	任务信息表
*/
create table pdc_task (
	id int auto_increment,
	project_id int,
	code varchar(20) not null,
	title varchar(50) not null,
	status_id int,
	percent char(4) default '0%',
	comment varchar(200),
	primary key(id)
);

/*
	工作状态记录表
*/
create table pdc_log_detail (
	task_id int,
	member_id int,
	day date,
	work_time numeric(5, 2) not null,
	absent char(1),
	primary key(task_id, member_id, day)
);

/*
	档案记录信息表
*/
create table pdc_profile (
	id int auto_increment,
	code varchar(10) not null unique,
	label varchar(50),
	primary key(id)
);

/*
	角色档案信息表
*/
create table pdc_role_profile (
	role_id int,
	profile_id int,
	primary key(role_id, profile_id)
);

/*
	权限信息表
*/
create table pdc_rights (
	id int auto_increment,
	code varchar(10) not null unique,
	label varchar(50),
	primary key(id)
);

/*
	档案权限信息表
*/
create table pdc_profile_rights (
	profile_id int, 
	rights_id int,
	primary key(profile_id, rights_id)
);

/*
 * 	周报信息表
 */
create table pdc_weekly_report (
	id int auto_increment,
	project_name varchar(20),
	project_description varchar(500),
	client_department varchar(20),
	pm_china varchar(30),
	pm_client varchar(40),
	weekly_meeting date,
	participants varchar(100),
	week varchar(10),
	primary key(id)
);