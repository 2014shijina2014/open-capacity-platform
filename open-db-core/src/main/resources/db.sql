create table sys_dept(
   dept_id           VARCHAR2 (255) NOT NULL primary key,
   dept_name      VARCHAR2 (255) NOT NULL,   
   parent_dept_id     VARCHAR2 (255),
   parent_dept_ids    VARCHAR2 (255),
   sortstring   VARCHAR2 (255),
   if_valid    CHAR (1) ,
   remark VARCHAR2 (255),
   operator varchar2(255),
   operator_time date ,
   operator_id varchar2(255)
) ;
 --添加表备注
COMMENT ON TABLE sys_dept IS '部门表';
    --添加列注释
COMMENT ON COLUMN sys_dept.dept_id IS '部门ID';
    --添加列注释
COMMENT ON COLUMN sys_dept.dept_name IS '部门名称';
    --添加列注释
COMMENT ON COLUMN sys_dept.parent_dept_id IS '父部门ID';
    --添加列注释
COMMENT ON COLUMN sys_dept.parent_dept_ids IS '父部门IDS';
    --添加列注释
COMMENT ON COLUMN sys_dept.sortstring IS '排序';


CREATE TABLE sys_user
(
   user_id         VARCHAR (255) primary key,
   username   VARCHAR2 (255),
   usercode     varchar2(255) ,
   password   VARCHAR2 (255),
   salt       VARCHAR2 (64),
   telephone varchar2(255),
   mail varchar2(255),
   dept_id varchar2(255) ,
   status  char(1)  ,
   remark varchar2(255) ,
   operator varchar2(255) ,
   operator_time date ,
   operator_ip varchar2(255)
);

 --添加表备注
COMMENT ON TABLE sys_user IS '用户表';

    --添加列注释
COMMENT ON COLUMN sys_user.usercode IS '账号';

 --添加列注释
COMMENT ON COLUMN sys_user.username IS '姓名';

 --添加列注释
COMMENT ON COLUMN sys_user.password IS '密码';
 --添加列注释
COMMENT ON COLUMN sys_user.salt IS '盐';


CREATE TABLE sys_menu
(
   menu_id           VARCHAR2 (255) NOT NULL primary key,
   menu_name         VARCHAR2 (255) NOT NULL,
   resource_TYPE         VARCHAR2 (32) NOT NULL,
   resource_url          VARCHAR (128) NOT NULL,
   percode      VARCHAR2 (128),
   parent_menu_id     VARCHAR2 (255),
   parent_menu_ids    VARCHAR2 (255),
   sortstring   VARCHAR2 (255),
   status    CHAR (1)
);


 --添加表备注
COMMENT ON TABLE sys_menu IS '权限表';

    --添加列注释
COMMENT ON COLUMN sys_menu.menu_id IS '主键';
    --添加列注释
COMMENT ON COLUMN sys_menu.menu_name IS '资源名称';
    --添加列注释
COMMENT ON COLUMN sys_menu.resource_TYPE IS '资源类型：menu,button,';
    --添加列注释
COMMENT ON COLUMN sys_menu.resource_url IS '访问url地址';
    --添加列注释
COMMENT ON COLUMN sys_menu.percode IS '权限代码字符串';
    --添加列注释
COMMENT ON COLUMN sys_menu.parent_menu_id IS '父结点id';
    --添加列注释
COMMENT ON COLUMN sys_menu.sortstring IS '排序号';
    --添加列注释
COMMENT ON COLUMN sys_menu.status IS
   '是否可用,1：可用，0不可用';

   
   

CREATE TABLE sys_role
(
   role_id          VARCHAR2 (255)  primary key,
   role_name        VARCHAR2 (255),
   status   CHAR (1)
);



 --添加表备注
COMMENT ON TABLE sys_role IS '角色表';

    --添加列注释
COMMENT ON COLUMN sys_role.role_id IS '主键';
    --添加列注释
COMMENT ON COLUMN sys_role.role_name IS '角色名称';
    --添加列注释
COMMENT ON COLUMN sys_role.status IS
   '是否可用,1：可用，0不可用';
   
      
   
CREATE TABLE sys_role_permission (
  id varchar(255) NOT NULL primary key ,
  sys_role_id varchar(255) NOT NULL ,
  sys_permission_id varchar(255) NOT NULL
)    ;

 --添加表备注
COMMENT ON TABLE sys_role_permission IS '角色权限关系表';

    --添加列注释
COMMENT ON COLUMN sys_role_permission.sys_role_id IS '角色id';

    --添加列注释
COMMENT ON COLUMN sys_role_permission.sys_permission_id IS '权限id';

 
CREATE TABLE sys_user_role (
  id varchar(255) NOT NULL primary key ,
  sys_user_id varchar(255) NOT NULL,
  sys_role_id varchar(255) NOT NULL
)  ;


 --添加表备注
COMMENT ON TABLE sys_user_role IS '用户角色关系表';

    --添加列注释
COMMENT ON COLUMN sys_user_role.id IS '主键';

    --添加列注释
COMMENT ON COLUMN sys_user_role.sys_user_id IS '用户id';

    --添加列注释
COMMENT ON COLUMN sys_user_role.sys_role_id IS '角色id';
   