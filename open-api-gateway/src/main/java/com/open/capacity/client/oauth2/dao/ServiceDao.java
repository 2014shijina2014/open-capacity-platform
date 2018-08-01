package com.open.capacity.client.oauth2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ServiceDao {

    @Select("select p.* from CREATE DATABASE\n" +
            "IF\n" +
            "\tNOT EXISTS `boot_security` DEFAULT CHARACTER\n" +
            "\tSET = utf8mb4;\n" +
            "USE `boot_security`;\n" +
            "\n" +
            "SET SESSION sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';\n" +
            "\n" +
            "SET FOREIGN_KEY_CHECKS = 0;# Host: 192.168.3.150  (Version 5.7.22)\n" +
            "# Date: 2018-06-24 11:52:30\n" +
            "# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/\n" +
            "/*!40101\n" +
            "SET NAMES utf8 */;#\n" +
            "\n" +
            "# Structure for table \"file_info\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `file_info`;\n" +
            "CREATE TABLE `file_info` (\n" +
            "\t`id` VARCHAR ( 32 ) NOT NULL COMMENT '文件md5',\n" +
            "\t`contentType` VARCHAR ( 128 ) NOT NULL,\n" +
            "\t`size` INT ( 11 ) NOT NULL,\n" +
            "\t`path` VARCHAR ( 255 ) NOT NULL COMMENT '物理路径',\n" +
            "\t`url` VARCHAR ( 1024 ) NOT NULL,\n" +
            "\t`type` INT ( 1 ) NOT NULL,\n" +
            "\t`createTime` datetime NOT NULL,\n" +
            "\t`updateTime` datetime NOT NULL,\n" +
            "\tPRIMARY KEY ( `id` )\n" +
            ") ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='文件表';#\n" +
            "\n" +
            "\n" +
            "# Data for table \"file_info\"\n" +
            "INSERT INTO `file_info`\n" +
            "VALUES\n" +
            "\t( 'c5ca69c2971ac9add9efe91115bf500c', 'image/png', 12105, 'd:/files/2018/05/28/c5ca69c2971ac9add9efe91115bf500c.png', '/2018/05/28/c5ca69c2971ac9add9efe91115bf500c.png', 1, '2018-05-28 02:54:47', '2018-05-28 02:54:47' );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"oauth_client_details\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `oauth_client_details`;\n" +
            "CREATE TABLE `oauth_client_details` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
            "\t`client_id` VARCHAR ( 48 ) NOT NULL COMMENT '应用标识',\n" +
            "\t`resource_ids` VARCHAR ( 256 ) DEFAULT NULL COMMENT '资源限定串(逗号分割)',\n" +
            "\t`client_secret` VARCHAR ( 256 ) DEFAULT NULL COMMENT '应用密钥(bcyt) 加密',\n" +
            "\t`scope` VARCHAR ( 256 ) DEFAULT NULL COMMENT '范围',\n" +
            "\t`authorized_grant_types` VARCHAR ( 256 ) DEFAULT NULL COMMENT '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)',\n" +
            "\t`web_server_redirect_uri` VARCHAR ( 256 ) DEFAULT NULL COMMENT '回调地址 ',\n" +
            "\t`authorities` VARCHAR ( 256 ) DEFAULT NULL COMMENT '权限',\n" +
            "\t`access_token_validity` INT ( 11 ) DEFAULT NULL COMMENT 'access_token有效期',\n" +
            "\t`refresh_token_validity` INT ( 11 ) DEFAULT NULL COMMENT 'refresh_token有效期',\n" +
            "\t`additional_information` VARCHAR ( 4096 ) DEFAULT NULL COMMENT '{}',\n" +
            "\t`autoapprove` VARCHAR ( 256 ) DEFAULT NULL COMMENT '是否自动授权 是-true',\n" +
            "\tPRIMARY KEY ( `id` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 8 DEFAULT CHARSET = utf8 COMMENT = 'OAUTH2客户端模式表';#\n" +
            "\n" +
            "\n" +
            "# Data for table \"oauth_client_details\"\n" +
            "INSERT INTO `oauth_client_details`\n" +
            "VALUES\n" +
            "\t( 1, 'app', NULL, 'app', 'app', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),\n" +
            "\t( 2, 'mobile', 'mobile,test', 'mobile', 'all', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),\n" +
            "\t( 3, 'test', 'test', 'test', 'test', 'password,refresh_token', NULL, NULL, 180000, NULL, '{}', 'true' ),\n" +
            "\t( 4, 'webApp', NULL, 'webApp', 'app', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 180000, NULL, '{}', 'true' ),\n" +
            "\t( 5, 'clientId', '', 'clientSecret', 'all', 'authorization_code,password,refresh_token,client_credentials', 'http://www.baidu.com', '', 180000, NULL, '{}', 'true' ),\n" +
            "\t( 6, 'owen', NULL, 'owen', 'app', 'authorization_code,password,refresh_token,client_credentials', 'http://127.0.0.1:9997/clientOne/login', NULL, 180000, NULL, '{}', 'true' );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_client_permission\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_client_permission`;\n" +
            "CREATE TABLE `sys_client_permission` (\n" +
            "\t`clientId` INT ( 11 ) NOT NULL COMMENT '应用标识',\n" +
            "\t`permissionId` INT ( 11 ) NOT NULL COMMENT '服务权限标识',\n" +
            "\tPRIMARY KEY ( `clientId`, `permissionId` )\n" +
            ") ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT ='客户端id和api绑定关系';#\n" +
            "\n" +
            "# Data for table \"sys_client_permission\"\n" +
            "INSERT INTO `sys_client_permission`\n" +
            "VALUES\n" +
            "\t( 1, 71 ),\n" +
            "\t( 1, 72 ),\n" +
            "\t( 1, 73 ),\n" +
            "\t( 1, 74 ),\n" +
            "\t( 1, 75 ),\n" +
            "\t( 2, 71 ),\n" +
            "\t( 2, 72 ),\n" +
            "\t( 2, 73 ),\n" +
            "\t( 2, 74 ),\n" +
            "\t( 2, 75 ),\n" +
            "\t( 3, 71 ),\n" +
            "\t( 3, 72 ),\n" +
            "\t( 3, 73 ),\n" +
            "\t( 3, 74 ),\n" +
            "\t( 3, 75 ),\n" +
            "\t( 4, 71 ),\n" +
            "\t( 4, 72 ),\n" +
            "\t( 4, 73 ),\n" +
            "\t( 4, 74 ),\n" +
            "\t( 4, 75 ),\n" +
            "\t( 5, 71 ),\n" +
            "\t( 5, 72 ),\n" +
            "\t( 5, 73 ),\n" +
            "\t( 5, 74 ),\n" +
            "\t( 5, 75 );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_logs\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_logs`;\n" +
            "CREATE TABLE `sys_logs` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,\n" +
            "\t`userId` INT ( 11 ) NOT NULL,\n" +
            "\t`module` VARCHAR ( 50 ) DEFAULT NULL COMMENT '模块名',\n" +
            "\t`flag` TINYINT ( 4 ) NOT NULL DEFAULT '1' COMMENT '成功失败',\n" +
            "\t`remark` text COMMENT '备注',\n" +
            "\t`createTime` datetime NOT NULL,\n" +
            "\tPRIMARY KEY ( `id` ),\n" +
            "\tKEY `userId` ( `userId` ),\n" +
            "\tKEY `createTime` ( `createTime` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 362 DEFAULT CHARSET = utf8mb4 COMMENT ='中台操作日志表';#\n" +
            "\n" +
            "# Data for table \"sys_logs\"\n" +
            "INSERT INTO `sys_logs`\n" +
            "VALUES\n" +
            "\t( 1, 1, '登陆', 1, NULL, '2018-03-14 03:59:44' );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_permission\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_permission`;\n" +
            "CREATE TABLE `sys_permission` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '权限ID',\n" +
            "\t`parentId` INT ( 11 ) NOT NULL COMMENT '父权限ID',\n" +
            "\t`name` VARCHAR ( 50 ) NOT NULL COMMENT '权限名称',\n" +
            "\t`css` VARCHAR ( 30 ) DEFAULT NULL,\n" +
            "\t`href` VARCHAR ( 1000 ) DEFAULT NULL COMMENT '链接',\n" +
            "\t`type` TINYINT ( 1 ) NOT NULL COMMENT '资源类型 1菜单 2按钮',\n" +
            "\t`permission` VARCHAR ( 50 ) DEFAULT NULL COMMENT '权限标识符',\n" +
            "\t`sort` INT ( 11 ) NOT NULL COMMENT '排序号',\n" +
            "\tPRIMARY KEY ( `id` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 67 DEFAULT CHARSET = utf8mb4 COMMENT ='中台资源权限表';#\n" +
            "\n" +
            "# Data for table \"sys_permission\"\n" +
            "INSERT INTO `sys_permission`\n" +
            "VALUES\n" +
            "\t( 1, 0, '用户管理', 'fa-users', '', 1, '', 2 ),\n" +
            "\t( 2, 1, '用户查询', 'fa-user', 'pages/user/userList.html', 1, '', 3 ),\n" +
            "\t( 3, 2, '查询', '', '', 2, 'sys:user:query', 100 ),\n" +
            "\t( 4, 2, '新增', '', '', 2, 'sys:user:add', 100 ),\n" +
            "\t( 6, 1, '修改密码', 'fa-pencil-square-o', 'pages/user/changePassword.html', 1, 'sys:user:password', 4 ),\n" +
            "\t( 7, 0, '系统设置', 'fa-gears', '', 1, '', 5 ),\n" +
            "\t( 8, 7, '菜单', 'fa-cog', 'pages/menu/menuList.html', 1, '', 6 ),\n" +
            "\t( 9, 8, '查询', '', '', 2, 'sys:menu:query', 100 ),\n" +
            "\t( 10, 8, '新增', '', '', 2, 'sys:menu:add', 100 ),\n" +
            "\t( 11, 8, '删除', '', '', 2, 'sys:menu:del', 100 ),\n" +
            "\t( 12, 7, '角色', 'fa-user-secret', 'pages/role/roleList.html', 1, '', 7 ),\n" +
            "\t( 13, 12, '查询', '', '', 2, 'sys:role:query', 100 ),\n" +
            "\t( 14, 12, '新增', '', '', 2, 'sys:role:add', 100 ),\n" +
            "\t( 15, 12, '删除', '', '', 2, 'sys:role:del', 100 ),\n" +
            "\t( 16, 0, '文件管理', 'fa-folder-open', 'pages/file/fileList.html', 1, '', 8 ),\n" +
            "\t( 17, 16, '查询', '', '', 2, 'sys:file:query', 100 ),\n" +
            "\t( 18, 16, '删除', '', '', 2, 'sys:file:del', 100 ),\n" +
            "\t( 19, 0, '数据源监控', 'fa-eye', 'druid/index.html', 1, '', 9 ),\n" +
            "\t( 26, 0, '日志查询', 'fa-reorder', 'pages/log/logList.html', 1, 'sys:log:query', 13 ),\n" +
            "\t( 41, 0, '注册中心', 'fa-th-list', 'pages/euraka/euraka.html', 1, '', 18 ),\n" +
            "\t( 60, 41, '操作', '', '', 2, 'job:add', 100 ),\n" +
            "\t( 61, 66, '应用管理', 'fa-cubes', 'pages/client/clientList.html', 1, '', 10 ),\n" +
            "\t( 62, 61, '查询', '', '', 2, 'sys:role:query', 100 ),\n" +
            "\t( 63, 61, '新增', '', '', 2, 'sys:role:add', 100 ),\n" +
            "\t( 64, 61, '删除', '', '', 2, 'sys:role:del', 100 ),\n" +
            "\t( 65, 66, '服务管理', 'fa-cloud', 'pages/service/serviceList.html', 1, '', 1 ),\n" +
            "\t( 66, 0, '资源管理', 'fa-th', '', 1, '', 100 );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_role\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_role`;\n" +
            "CREATE TABLE `sys_role` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
            "\t`name` VARCHAR ( 50 ) NOT NULL COMMENT '角色名称',\n" +
            "\t`description` VARCHAR ( 100 ) DEFAULT NULL COMMENT '描述',\n" +
            "\t`createTime` datetime NOT NULL COMMENT '创建时间',\n" +
            "\t`updateTime` datetime NOT NULL COMMENT '修改时间',\n" +
            "\tPRIMARY KEY ( `id` ),\n" +
            "\tUNIQUE KEY `name` ( `name` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 7 DEFAULT CHARSET = utf8mb4 COMMENT ='中台角色表';#\n" +
            "\n" +
            "# Data for table \"sys_role\"\n" +
            "INSERT INTO `sys_role`\n" +
            "VALUES\n" +
            "\t( 1, 'ADMIN', '管理员', '2017-05-01 13:25:39', '2018-06-22 07:46:48' ),\n" +
            "\t( 2, 'USER', '11', '2017-08-01 21:47:31', '2018-06-21 11:09:12' ),\n" +
            "\t( 3, 'test1', 'test1', '2018-03-14 13:03:36', '2018-06-21 11:09:32' ),\n" +
            "\t( 4, 'ttttt', 'ttt1', '2018-04-24 11:09:34', '2018-06-21 11:12:26' ),\n" +
            "\t( 5, '11111', '222222', '2018-04-24 17:47:12', '2018-04-26 10:49:07' );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_role_permission\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_role_permission`;\n" +
            "CREATE TABLE `sys_role_permission` (\n" +
            "\t`roleId` INT ( 11 ) NOT NULL COMMENT '角色',\n" +
            "\t`permissionId` INT ( 11 ) NOT NULL COMMENT '权限',\n" +
            "\tPRIMARY KEY ( `roleId`, `permissionId` )\n" +
            ") ENGINE = INNODB DEFAULT CHARSET = utf8mb4  COMMENT ='中台角色权限关系表';#\n" +
            "\n" +
            "# Data for table \"sys_role_permission\"\n" +
            "INSERT INTO `sys_role_permission`\n" +
            "VALUES\n" +
            "\t( 1, 1 ),\n" +
            "\t( 1, 2 ),\n" +
            "\t( 1, 3 ),\n" +
            "\t( 1, 4 ),\n" +
            "\t( 1, 6 ),\n" +
            "\t( 1, 7 ),\n" +
            "\t( 1, 8 ),\n" +
            "\t( 1, 9 ),\n" +
            "\t( 1, 10 ),\n" +
            "\t( 1, 11 ),\n" +
            "\t( 1, 12 ),\n" +
            "\t( 1, 13 ),\n" +
            "\t( 1, 14 ),\n" +
            "\t( 1, 15 ),\n" +
            "\t( 1, 16 ),\n" +
            "\t( 1, 17 ),\n" +
            "\t( 1, 18 ),\n" +
            "\t( 1, 19 ),\n" +
            "\t( 1, 26 ),\n" +
            "\t( 1, 41 ),\n" +
            "\t( 1, 42 ),\n" +
            "\t( 1, 56 ),\n" +
            "\t( 1, 57 ),\n" +
            "\t( 1, 58 ),\n" +
            "\t( 1, 60 ),\n" +
            "\t( 1, 61 ),\n" +
            "\t( 1, 62 ),\n" +
            "\t( 1, 63 ),\n" +
            "\t( 1, 64 ),\n" +
            "\t( 1, 65 ),\n" +
            "\t( 1, 66 ),\n" +
            "\t( 2, 1 ),\n" +
            "\t( 2, 2 ),\n" +
            "\t( 2, 3 ),\n" +
            "\t( 2, 4 ),\n" +
            "\t( 2, 6 ),\n" +
            "\t( 2, 7 ),\n" +
            "\t( 2, 8 ),\n" +
            "\t( 2, 9 ),\n" +
            "\t( 2, 10 ),\n" +
            "\t( 2, 11 ),\n" +
            "\t( 2, 12 ),\n" +
            "\t( 2, 13 ),\n" +
            "\t( 2, 14 ),\n" +
            "\t( 2, 15 ),\n" +
            "\t( 2, 16 ),\n" +
            "\t( 2, 17 ),\n" +
            "\t( 2, 18 ),\n" +
            "\t( 2, 19 ),\n" +
            "\t( 3, 1 ),\n" +
            "\t( 3, 2 ),\n" +
            "\t( 3, 3 ),\n" +
            "\t( 3, 7 ),\n" +
            "\t( 3, 12 ),\n" +
            "\t( 3, 13 ),\n" +
            "\t( 3, 14 ),\n" +
            "\t( 3, 15 ),\n" +
            "\t( 4, 1 ),\n" +
            "\t( 4, 2 ),\n" +
            "\t( 4, 3 ),\n" +
            "\t( 4, 4 ),\n" +
            "\t( 4, 6 ),\n" +
            "\t( 4, 7 ),\n" +
            "\t( 4, 8 ),\n" +
            "\t( 4, 9 ),\n" +
            "\t( 4, 10 ),\n" +
            "\t( 4, 11 ),\n" +
            "\t( 4, 12 ),\n" +
            "\t( 4, 13 ),\n" +
            "\t( 4, 14 ),\n" +
            "\t( 4, 15 ),\n" +
            "\t( 4, 16 ),\n" +
            "\t( 4, 17 ),\n" +
            "\t( 4, 18 ),\n" +
            "\t( 4, 19 ),\n" +
            "\t( 4, 26 ),\n" +
            "\t( 4, 41 ),\n" +
            "\t( 4, 42 ),\n" +
            "\t( 5, 1 ),\n" +
            "\t( 5, 2 ),\n" +
            "\t( 5, 3 ),\n" +
            "\t( 5, 4 ),\n" +
            "\t( 5, 6 ),\n" +
            "\t( 5, 7 ),\n" +
            "\t( 5, 8 ),\n" +
            "\t( 5, 9 ),\n" +
            "\t( 5, 10 ),\n" +
            "\t( 5, 11 ),\n" +
            "\t( 5, 12 ),\n" +
            "\t( 5, 13 ),\n" +
            "\t( 5, 14 ),\n" +
            "\t( 5, 15 ),\n" +
            "\t( 5, 16 ),\n" +
            "\t( 5, 17 ),\n" +
            "\t( 5, 18 ),\n" +
            "\t( 5, 19 ),\n" +
            "\t( 5, 26 ),\n" +
            "\t( 5, 38 ),\n" +
            "\t( 5, 39 ),\n" +
            "\t( 5, 40 ),\n" +
            "\t( 5, 41 ),\n" +
            "\t( 5, 42 );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"sys_role_user\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_role_user`;\n" +
            "CREATE TABLE `sys_role_user` (\n" +
            "\t`userId` INT ( 11 ) NOT NULL COMMENT '用户',\n" +
            "\t`roleId` INT ( 11 ) NOT NULL COMMENT '角色',\n" +
            "\tPRIMARY KEY ( `userId`, `roleId` )\n" +
            ") ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT ='中台用户角色关系表';#\n" +
            "\n" +
            "# Data for table \"sys_role_user\"\n" +
            "INSERT INTO `sys_role_user`\n" +
            "VALUES\n" +
            "\t( 1, 1 ),\n" +
            "\t( 1, 2 ),\n" +
            "\t( 1, 3 ),\n" +
            "\t( 1, 4 ),\n" +
            "\t( 1, 5 ),\n" +
            "\t( 2, 1 ),\n" +
            "\t( 2, 2 ),\n" +
            "\t( 2, 3 ),\n" +
            "\t( 2, 4 ),\n" +
            "\t( 2, 5 ),\n" +
            "\t( 3, 1 ),\n" +
            "\t( 3, 2 ),\n" +
            "\t( 4, 3 ),\n" +
            "\t( 5, 1 ),\n" +
            "\t( 5, 2 );#\n" +
            "\n" +
            "\n" +
            "# Structure for table \"micro_service\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `micro_service`;\n" +
            "CREATE TABLE `micro_service` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '服务ID',\n" +
            "\t`parentId` INT ( 11 ) NOT NULL COMMENT '父服务ID',\n" +
            "\t`name` VARCHAR ( 50 ) NOT NULL COMMENT '服务名称',\n" +
            "\t`href` VARCHAR ( 1000 ) DEFAULT NULL COMMENT '服务地址',\n" +
            "\t`permission` VARCHAR ( 50 ) DEFAULT NULL COMMENT '服务权限标识符',\n" +
            "\t`sort` INT ( 11 ) NOT NULL COMMENT '排序',\n" +
            "\tPRIMARY KEY ( `id` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 74 DEFAULT CHARSET = utf8mb4 COMMENT ='微服务API表';#\n" +
            "\n" +
            "# Data for table \"micro_service\"\n" +
            "INSERT INTO `micro_service`\n" +
            "VALUES\n" +
            "\t( 71, 0, '授权服务',  '/auth', '', 1 ),\n" +
            "\t( 72, 71, '用户授权token',  '/auth/user/token', '', 100 ),\n" +
            "\t( 73, 71, '应用申请token','/auth/client/token', '', 100 ),\n" +
            "\t( 74, 0, '测试微服务', '/client', '', 100 ),\n" +
            "\t( 75, 74, 'hello接口', '/client/hello', '', 100 );#\n" +
            "\n" +
            "# Structure for table \"sys_user\"\n" +
            "DROP TABLE\n" +
            "IF\n" +
            "\tEXISTS `sys_user`;\n" +
            "CREATE TABLE `sys_user` (\n" +
            "\t`id` INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '用户主键',\n" +
            "\t`username` VARCHAR ( 50 ) NOT NULL COMMENT '用户名',\n" +
            "\t`password` VARCHAR ( 60 ) NOT NULL COMMENT '密码',\n" +
            "\t`nickname` VARCHAR ( 255 ) DEFAULT NULL COMMENT '昵称',\n" +
            "\t`headImgUrl` VARCHAR ( 255 ) DEFAULT NULL COMMENT '头像地址',\n" +
            "\t`phone` VARCHAR ( 11 ) DEFAULT NULL COMMENT '电话',\n" +
            "\t`telephone` VARCHAR ( 30 ) DEFAULT NULL COMMENT '手机号',\n" +
            "\t`email` VARCHAR ( 50 ) DEFAULT NULL COMMENT '邮箱',\n" +
            "\t`birthday` date DEFAULT NULL COMMENT '生日',\n" +
            "\t`sex` TINYINT ( 1 ) DEFAULT NULL COMMENT '性别',\n" +
            "\t`status` TINYINT ( 1 ) NOT NULL DEFAULT '1' COMMENT '状态  不可用:0   有效:1  锁定:2 ',\n" +
            "\t`createTime` datetime NOT NULL COMMENT '创建时间',\n" +
            "\t`updateTime` datetime NOT NULL COMMENT '修改时间',\n" +
            "\tPRIMARY KEY ( `id` ),\n" +
            "\tUNIQUE KEY `username` ( `username` )\n" +
            ") ENGINE = INNODB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4  COMMENT ='中台登陆用户表';#\n" +
            "\n" +
            "# Data for table \"sys_user\"\n" +
            "INSERT INTO `sys_user`\n" +
            "VALUES\n" +
            "\t( 1, 'admin', '$2a$10$q54rooCXqDTWYkf29d4ZFu/L3zkq5Uoa6jdA/spRNSwpxksEqJYpy', '管理员', NULL, '', '', '', '1998-07-01', 0, 1, '2017-04-10 15:21:38', '2018-05-28 02:49:01' ),\n" +
            "\t( 2, 'user', '$2a$10$ooGb4wjT7Hg3zgU2RhZp6eVu3jvG29i/U4L6VRwiZZ4.DZ0OOEAHu', '用户', NULL, '22222', '2222', '', NULL, 1, 1, '2017-08-01 21:47:18', '2018-06-21 21:05:02' ),\n" +
            "\t( 3, 'test123', '$2a$10$MGxO0dynaARStolVS9tzk.ZGwzlC2WZ2LZ/LzxixWxCUoftU5Xtnq', 'test111', NULL, '18571111111', '221', '22', '2018-03-14', 1, 1, '2018-03-14 08:43:48', '2018-06-21 21:04:47' ),\n" +
            "\t( 4, 'owen', '$2a$10$JTuOh..ec2N1BBi6NOsn1.beg72gN7je7uNvFn.VWbfkrAsPZ3otC', 'test', NULL, '18571111111', '', '11@11.com', '2018-03-20', 0, 1, '2018-03-14 13:02:36', '2018-06-12 20:56:07' ),\n" +
            "\t( 5, '111111111', '$2a$10$mJuBGzs67CyExiTZkk5iLOF9sE09GDK7jLf2O6gosMh.g/fDeKEiS', '111111', NULL, '11111111111', '11111111111', '11@11.com', '2018-04-11', 0, 1, '2018-04-14 21:42:43', '2018-04-14 21:42:43' );#\n p inner join sys_client_permission rp on p.id = rp.permissionId where rp.clientId = #{clientId} order by p.sort")
    List<Map> listByClientId(Long clientId);

    @Select("select * from oauth_client_details t where t.client_id = #{clientId}")
    Map getClient(String clientId);

}
