CREATE DATABASE
IF
	NOT EXISTS `boot_security` DEFAULT CHARACTER
	SET = utf8mb4;
USE `boot_security`;

SET SESSION sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

SET FOREIGN_KEY_CHECKS = 0;# Host: 192.168.3.150  (Version 5.7.22)
# Date: 2018-06-24 11:52:30
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/
/*!40101
SET NAMES utf8 */;#

# Structure for table "file_info"
DROP TABLE
IF
	EXISTS `file_info`;
CREATE TABLE `file_info` (
	`id` VARCHAR ( 32 ) NOT NULL COMMENT '文件md5',
	`contentType` VARCHAR ( 128 ) NOT NULL,
	`size` INT ( 11 ) NOT NULL,
	`path` VARCHAR ( 255 ) NOT NULL COMMENT '物理路径',
	`url` VARCHAR ( 1024 ) NOT NULL,
	`type` INT ( 1 ) NOT NULL,
	`createTime` datetime NOT NULL,
	`updateTime` datetime NOT NULL,
	PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='文件表';#


# Data for table "file_info"
INSERT INTO `file_info`
VALUES
	( 'c5ca69c2971ac9add9efe91115bf500c', 'image/png', 12105, 'd:/files/2018/05/28/c5ca69c2971ac9add9efe91115bf500c.png', '/2018/05/28/c5ca69c2971ac9add9efe91115bf500c.png', 1, '2018-05-28 02:54:47', '2018-05-28 02:54:47' );#


# Structure for table "oauth_client_details"
DROP TABLE
IF
	EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`client_id` VARCHAR ( 48 ) NOT NULL COMMENT '应用标识',
	`resource_ids` VARCHAR ( 256 ) DEFAULT NULL COMMENT '资源限定串(逗号分割)',
	`client_secret` VARCHAR ( 256 ) DEFAULT NULL COMMENT '应用密钥(bcyt) 加密',
	`scope` VARCHAR ( 256 ) DEFAULT NULL COMMENT '范围',
	`authorized_grant_types` VARCHAR ( 256 ) DEFAULT NULL COMMENT '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)',
	`web_server_redirect_uri` VARCHAR ( 256 ) DEFAULT NULL COMMENT '回调地址 ',
	`authorities` VARCHAR ( 256 ) DEFAULT NULL COMMENT '权限',
	`access_token_validity` INT ( 11 ) DEFAULT NULL COMMENT 'access_token有效期',
	`refresh_token_validity` INT ( 11 ) DEFAULT NULL COMMENT 'refresh_token有效期',
	`additional_information` VARCHAR ( 4096 ) DEFAULT NULL COMMENT '{}',
	`autoapprove` VARCHAR ( 256 ) DEFAULT NULL COMMENT '是否自动授权 是-true',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 8 DEFAULT CHARSET = utf8 COMMENT = 'OAUTH2客户端模式表';#


# Data for table "oauth_client_details"
INSERT INTO `oauth_client_details`
VALUES
	( 1, 'app', NULL, 'app', 'app', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),
	( 2, 'mobile', 'mobile,test', 'mobile', 'all', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),
	( 3, 'test', 'test', 'test', 'test', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),
	( 4, 'webApp', NULL, 'webApp', 'app', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 180000, NULL, '{}', 'true' ),
	( 5, 'clientId', '', 'clientSecret', 'all', 'authorization_code,password,refresh_token,client_credentials', 'http://www.baidu.com', '', 180000, NULL, '{}', 'true' ),
	( 6, 'owen', NULL, 'owen', 'app', 'authorization_code,password,refresh_token,client_credentials', 'http://127.0.0.1:9997/clientOne/login', NULL, 180000, NULL, '{}', 'true' );#


# Structure for table "sys_client_permission"
DROP TABLE
IF
	EXISTS `sys_client_permission`;
CREATE TABLE `sys_client_permission` (
	`clientId` INT ( 11 ) NOT NULL COMMENT '应用标识',
	`permissionId` INT ( 11 ) NOT NULL COMMENT '服务权限标识',
	PRIMARY KEY ( `clientId`, `permissionId` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT ='客户端id和api绑定关系';#

# Data for table "sys_client_permission"
INSERT INTO `sys_client_permission`
VALUES
	( 1, 71 ),
	( 1, 72 ),
	( 1, 73 ),
	( 1, 74 ),
	( 1, 75 ),
	( 2, 71 ),
	( 2, 72 ),
	( 2, 73 ),
	( 2, 74 ),
	( 2, 75 ),
	( 3, 71 ),
	( 3, 72 ),
	( 3, 73 ),
	( 3, 74 ),
	( 3, 75 ),
	( 4, 71 ),
	( 4, 72 ),
	( 4, 73 ),
	( 4, 74 ),
	( 4, 75 ),
	( 5, 71 ),
	( 5, 72 ),
	( 5, 73 ),
	( 5, 74 ),
	( 5, 75 );#


# Structure for table "sys_logs"
DROP TABLE
IF
	EXISTS `sys_logs`;
CREATE TABLE `sys_logs` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
	`userId` INT ( 11 ) NOT NULL,
	`module` VARCHAR ( 50 ) DEFAULT NULL COMMENT '模块名',
	`flag` TINYINT ( 4 ) NOT NULL DEFAULT '1' COMMENT '成功失败',
	`remark` text COMMENT '备注',
	`createTime` datetime NOT NULL,
	PRIMARY KEY ( `id` ),
	KEY `userId` ( `userId` ),
	KEY `createTime` ( `createTime` )
) ENGINE = INNODB AUTO_INCREMENT = 362 DEFAULT CHARSET = utf8mb4 COMMENT ='中台操作日志表';#

# Data for table "sys_logs"
INSERT INTO `sys_logs`
VALUES
	( 1, 1, '登陆', 1, NULL, '2018-03-14 03:59:44' );#


# Structure for table "sys_permission"
DROP TABLE
IF
	EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
	`parentId` INT ( 11 ) NOT NULL COMMENT '父权限ID',
	`name` VARCHAR ( 50 ) NOT NULL COMMENT '权限名称',
	`css` VARCHAR ( 30 ) DEFAULT NULL,
	`href` VARCHAR ( 1000 ) DEFAULT NULL COMMENT '链接',
	`type` TINYINT ( 1 ) NOT NULL COMMENT '资源类型 1菜单 2按钮',
	`permission` VARCHAR ( 50 ) DEFAULT NULL COMMENT '权限标识符',
	`sort` INT ( 11 ) NOT NULL COMMENT '排序号',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 67 DEFAULT CHARSET = utf8mb4 COMMENT ='中台资源权限表';#

# Data for table "sys_permission"
INSERT INTO `sys_permission`
VALUES
	( 1, 0, '用户管理', 'fa-users', '', 1, '', 2 ),
	( 2, 1, '用户查询', 'fa-user', 'pages/user/userList.html', 1, '', 3 ),
	( 3, 2, '查询', '', '', 2, 'sys:user:query', 100 ),
	( 4, 2, '新增', '', '', 2, 'sys:user:add', 100 ),
	( 6, 1, '修改密码', 'fa-pencil-square-o', 'pages/user/changePassword.html', 1, 'sys:user:password', 4 ),
	( 7, 0, '系统设置', 'fa-gears', '', 1, '', 5 ),
	( 8, 7, '菜单', 'fa-cog', 'pages/menu/menuList.html', 1, '', 6 ),
	( 9, 8, '查询', '', '', 2, 'sys:menu:query', 100 ),
	( 10, 8, '新增', '', '', 2, 'sys:menu:add', 100 ),
	( 11, 8, '删除', '', '', 2, 'sys:menu:del', 100 ),
	( 12, 7, '角色', 'fa-user-secret', 'pages/role/roleList.html', 1, '', 7 ),
	( 13, 12, '查询', '', '', 2, 'sys:role:query', 100 ),
	( 14, 12, '新增', '', '', 2, 'sys:role:add', 100 ),
	( 15, 12, '删除', '', '', 2, 'sys:role:del', 100 ),
	( 16, 0, '文件管理', 'fa-folder-open', 'pages/file/fileList.html', 1, '', 8 ),
	( 17, 16, '查询', '', '', 2, 'sys:file:query', 100 ),
	( 18, 16, '删除', '', '', 2, 'sys:file:del', 100 ),
	( 19, 0, '数据源监控', 'fa-eye', 'druid/index.html', 1, '', 9 ),
	( 26, 0, '日志查询', 'fa-reorder', 'pages/log/logList.html', 1, 'sys:log:query', 13 ),
	( 41, 0, '注册中心', 'fa-th-list', 'pages/euraka/euraka.html', 1, '', 18 ),
	( 60, 41, '操作', '', '', 2, 'job:add', 100 ),
	( 61, 66, '应用管理', 'fa-cubes', 'pages/client/clientList.html', 1, '', 10 ),
	( 62, 61, '查询', '', '', 2, 'sys:role:query', 100 ),
	( 63, 61, '新增', '', '', 2, 'sys:role:add', 100 ),
	( 64, 61, '删除', '', '', 2, 'sys:role:del', 100 ),
	( 65, 66, '服务管理', 'fa-cloud', 'pages/service/serviceList.html', 1, '', 1 ),
	( 66, 0, '资源管理', 'fa-th', '', 1, '', 100 );#


# Structure for table "sys_role"
DROP TABLE
IF
	EXISTS `sys_role`;
CREATE TABLE `sys_role` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR ( 50 ) NOT NULL COMMENT '角色名称',
	`description` VARCHAR ( 100 ) DEFAULT NULL COMMENT '描述',
	`createTime` datetime NOT NULL COMMENT '创建时间',
	`updateTime` datetime NOT NULL COMMENT '修改时间',
	PRIMARY KEY ( `id` ),
	UNIQUE KEY `name` ( `name` )
) ENGINE = INNODB AUTO_INCREMENT = 7 DEFAULT CHARSET = utf8mb4 COMMENT ='中台角色表';#

# Data for table "sys_role"
INSERT INTO `sys_role`
VALUES
	( 1, 'ADMIN', '管理员', '2017-05-01 13:25:39', '2018-06-22 07:46:48' ),
	( 2, 'USER', '11', '2017-08-01 21:47:31', '2018-06-21 11:09:12' ),
	( 3, 'test1', 'test1', '2018-03-14 13:03:36', '2018-06-21 11:09:32' ),
	( 4, 'ttttt', 'ttt1', '2018-04-24 11:09:34', '2018-06-21 11:12:26' ),
	( 5, '11111', '222222', '2018-04-24 17:47:12', '2018-04-26 10:49:07' );#


# Structure for table "sys_role_permission"
DROP TABLE
IF
	EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
	`roleId` INT ( 11 ) NOT NULL COMMENT '角色',
	`permissionId` INT ( 11 ) NOT NULL COMMENT '权限',
	PRIMARY KEY ( `roleId`, `permissionId` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4  COMMENT ='中台角色权限关系表';#

# Data for table "sys_role_permission"
INSERT INTO `sys_role_permission`
VALUES
	( 1, 1 ),
	( 1, 2 ),
	( 1, 3 ),
	( 1, 4 ),
	( 1, 6 ),
	( 1, 7 ),
	( 1, 8 ),
	( 1, 9 ),
	( 1, 10 ),
	( 1, 11 ),
	( 1, 12 ),
	( 1, 13 ),
	( 1, 14 ),
	( 1, 15 ),
	( 1, 16 ),
	( 1, 17 ),
	( 1, 18 ),
	( 1, 19 ),
	( 1, 26 ),
	( 1, 41 ),
	( 1, 42 ),
	( 1, 56 ),
	( 1, 57 ),
	( 1, 58 ),
	( 1, 60 ),
	( 1, 61 ),
	( 1, 62 ),
	( 1, 63 ),
	( 1, 64 ),
	( 1, 65 ),
	( 1, 66 ),
	( 2, 1 ),
	( 2, 2 ),
	( 2, 3 ),
	( 2, 4 ),
	( 2, 6 ),
	( 2, 7 ),
	( 2, 8 ),
	( 2, 9 ),
	( 2, 10 ),
	( 2, 11 ),
	( 2, 12 ),
	( 2, 13 ),
	( 2, 14 ),
	( 2, 15 ),
	( 2, 16 ),
	( 2, 17 ),
	( 2, 18 ),
	( 2, 19 ),
	( 3, 1 ),
	( 3, 2 ),
	( 3, 3 ),
	( 3, 7 ),
	( 3, 12 ),
	( 3, 13 ),
	( 3, 14 ),
	( 3, 15 ),
	( 4, 1 ),
	( 4, 2 ),
	( 4, 3 ),
	( 4, 4 ),
	( 4, 6 ),
	( 4, 7 ),
	( 4, 8 ),
	( 4, 9 ),
	( 4, 10 ),
	( 4, 11 ),
	( 4, 12 ),
	( 4, 13 ),
	( 4, 14 ),
	( 4, 15 ),
	( 4, 16 ),
	( 4, 17 ),
	( 4, 18 ),
	( 4, 19 ),
	( 4, 26 ),
	( 4, 41 ),
	( 4, 42 ),
	( 5, 1 ),
	( 5, 2 ),
	( 5, 3 ),
	( 5, 4 ),
	( 5, 6 ),
	( 5, 7 ),
	( 5, 8 ),
	( 5, 9 ),
	( 5, 10 ),
	( 5, 11 ),
	( 5, 12 ),
	( 5, 13 ),
	( 5, 14 ),
	( 5, 15 ),
	( 5, 16 ),
	( 5, 17 ),
	( 5, 18 ),
	( 5, 19 ),
	( 5, 26 ),
	( 5, 38 ),
	( 5, 39 ),
	( 5, 40 ),
	( 5, 41 ),
	( 5, 42 );#


# Structure for table "sys_role_user"
DROP TABLE
IF
	EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
	`userId` INT ( 11 ) NOT NULL COMMENT '用户',
	`roleId` INT ( 11 ) NOT NULL COMMENT '角色',
	PRIMARY KEY ( `userId`, `roleId` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT ='中台用户角色关系表';#

# Data for table "sys_role_user"
INSERT INTO `sys_role_user`
VALUES
	( 1, 1 ),
	( 1, 2 ),
	( 1, 3 ),
	( 1, 4 ),
	( 1, 5 ),
	( 2, 1 ),
	( 2, 2 ),
	( 2, 3 ),
	( 2, 4 ),
	( 2, 5 ),
	( 3, 1 ),
	( 3, 2 ),
	( 4, 3 ),
	( 5, 1 ),
	( 5, 2 );#


# Structure for table "micro_service"
DROP TABLE
IF
	EXISTS `micro_service`;
CREATE TABLE `micro_service` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '服务ID',
	`parentId` INT ( 11 ) NOT NULL COMMENT '父服务ID',
	`name` VARCHAR ( 50 ) NOT NULL COMMENT '服务名称',
	`href` VARCHAR ( 1000 ) DEFAULT NULL COMMENT '服务地址',
	`permission` VARCHAR ( 50 ) DEFAULT NULL COMMENT '服务权限标识符',
	`sort` INT ( 11 ) NOT NULL COMMENT '排序',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB AUTO_INCREMENT = 74 DEFAULT CHARSET = utf8mb4 COMMENT ='微服务API表';#

# Data for table "micro_service"
INSERT INTO `micro_service`
VALUES
	( 71, 0, '授权服务',  '/auth', '', 1 ),
	( 72, 71, '用户授权token',  '/auth/user/token', '', 100 ),
	( 73, 71, '应用申请token','/auth/client/token', '', 100 ),
	( 74, 0, '测试微服务', '/client', '', 100 ),
	( 75, 74, 'hello接口', '/client/hello', '', 100 );#

# Structure for table "sys_user"
DROP TABLE
IF
	EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
	`username` VARCHAR ( 50 ) NOT NULL COMMENT '用户名',
	`password` VARCHAR ( 60 ) NOT NULL COMMENT '密码',
	`nickname` VARCHAR ( 255 ) DEFAULT NULL COMMENT '昵称',
	`headImgUrl` VARCHAR ( 255 ) DEFAULT NULL COMMENT '头像地址',
	`phone` VARCHAR ( 11 ) DEFAULT NULL COMMENT '电话',
	`telephone` VARCHAR ( 30 ) DEFAULT NULL COMMENT '手机号',
	`email` VARCHAR ( 50 ) DEFAULT NULL COMMENT '邮箱',
	`birthday` date DEFAULT NULL COMMENT '生日',
	`sex` TINYINT ( 1 ) DEFAULT NULL COMMENT '性别',
	`status` TINYINT ( 1 ) NOT NULL DEFAULT '1' COMMENT '状态  不可用:0   有效:1  锁定:2 ',
	`createTime` datetime NOT NULL COMMENT '创建时间',
	`updateTime` datetime NOT NULL COMMENT '修改时间',
	PRIMARY KEY ( `id` ),
	UNIQUE KEY `username` ( `username` )
) ENGINE = INNODB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4  COMMENT ='中台登陆用户表';#

# Data for table "sys_user"
INSERT INTO `sys_user`
VALUES
	( 1, 'admin', '$2a$10$q54rooCXqDTWYkf29d4ZFu/L3zkq5Uoa6jdA/spRNSwpxksEqJYpy', '管理员', NULL, '', '', '', '1998-07-01', 0, 1, '2017-04-10 15:21:38', '2018-05-28 02:49:01' ),
	( 2, 'user', '$2a$10$ooGb4wjT7Hg3zgU2RhZp6eVu3jvG29i/U4L6VRwiZZ4.DZ0OOEAHu', '用户', NULL, '22222', '2222', '', NULL, 1, 1, '2017-08-01 21:47:18', '2018-06-21 21:05:02' ),
	( 3, 'test123', '$2a$10$MGxO0dynaARStolVS9tzk.ZGwzlC2WZ2LZ/LzxixWxCUoftU5Xtnq', 'test111', NULL, '18571111111', '221', '22', '2018-03-14', 1, 1, '2018-03-14 08:43:48', '2018-06-21 21:04:47' ),
	( 4, 'owen', '$2a$10$JTuOh..ec2N1BBi6NOsn1.beg72gN7je7uNvFn.VWbfkrAsPZ3otC', 'test', NULL, '18571111111', '', '11@11.com', '2018-03-20', 0, 1, '2018-03-14 13:02:36', '2018-06-12 20:56:07' ),
	( 5, '111111111', '$2a$10$mJuBGzs67CyExiTZkk5iLOF9sE09GDK7jLf2O6gosMh.g/fDeKEiS', '111111', NULL, '11111111111', '11111111111', '11@11.com', '2018-04-11', 0, 1, '2018-04-14 21:42:43', '2018-04-14 21:42:43' );#

#
# Structure for table "t_dict"
#
DROP TABLE
IF
	EXISTS `t_dict`;
CREATE TABLE `t_dict` (
`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
`type` VARCHAR ( 16 ) NOT NULL COMMENT '字段类型 eg sex',
`k` VARCHAR ( 16 ) NOT NULL COMMENT 'key值',
`val` VARCHAR ( 64 ) NOT NULL COMMENT '中文',
`createTime` datetime NOT NULL COMMENT '添加时间',
`updateTime` datetime NOT NULL COMMENT '修改时间',
PRIMARY KEY ( `id` ),
UNIQUE KEY `type` ( `type`, `k` )
) ENGINE = INNODB AUTO_INCREMENT = 10 DEFAULT CHARSET = utf8mb4 COMMENT='系统字典表';#
# Data for table "t_dict"
#
INSERT INTO `t_dict`
VALUES
	( 1, 'sex', '0', '女', '2017-11-17 09:58:24', '2017-11-18 14:21:05' ),
	( 2, 'sex', '1', '男', '2017-11-17 10:03:46', '2017-11-17 10:03:46' ),
	( 3, 'userStatus', '0', '无效', '2017-11-17 16:26:06', '2017-11-17 16:26:09' ),
	( 4, 'userStatus', '1', '正常', '2017-11-17 16:26:06', '2017-11-17 16:26:09' ),
	( 5, 'userStatus', '2', '锁定', '2017-11-17 16:26:06', '2017-11-17 16:26:09' ),