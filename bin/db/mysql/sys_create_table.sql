
#DROP TABLE IF EXISTS icy_menu;
#DROP TABLE IF EXISTS icy_depart;
#DROP TABLE IF EXISTS icy_role;
#DROP TABLE IF EXISTS icy_user;
#DROP TABLE IF EXISTS icy_role_user;
#DROP TABLE IF EXISTS icy_role_menu;

/** t_sys_menu **/
CREATE TABLE t_sys_menu
(
  id int(64) NOT NULL COMMENT 'ID',
  parent_id int(64) NOT NULL COMMENT '父级ID',
  parent_ids varchar(2000) NOT NULL COMMENT '所有父级ID',
  name varchar(100) NOT NULL COMMENT '名称',
  sort decimal(10,0) NOT NULL COMMENT '排序',
  href varchar(2000) COMMENT '链接',
  target varchar(20) COMMENT '目标',
  icon varchar(100) COMMENT '图标',
  is_show char(1) NOT NULL COMMENT '是否在菜单中显示',
  permission varchar(200) COMMENT '权限标识',
  creator  varchar(64) NOT NULL COMMENT '创建者',
  create_date datetime NOT NULL COMMENT '创建时间',
  updater varchar(64) NOT NULL COMMENT '更新者',
  update_date datetime NOT NULL COMMENT '更新时间',
  remark varchar(255) COMMENT '备注信息',
  state char(1) DEFAULT '0' NOT NULL COMMENT '状态',
  PRIMARY KEY (id)
) COMMENT = '菜单表';


/** t_sys_operation **/
CREATE TABLE t_sys_operation 
(
  id int(64) NOT NULL COMMENT 'ID',
  parent_id int(64) NOT NULL COMMENT '父级ID',
  parent_ids varchar(2000) NOT NULL COMMENT '所有父级ID',
  name varchar(100) NOT NULL COMMENT '名称',
  code varchar(100) NOT NULL COMMENT '名称',
  state char(1) DEFAULT '0' NOT NULL COMMENT '状态',
  PRIMARY KEY (id)
) COMMENT = '菜单表';

/** department **/
CREATE TABLE t_sys_depart
(
  id int(64) NOT NULL COMMENT '编号',
  parent_id int(64) NOT NULL COMMENT '父级编号',
  parent_ids varchar(2000) NOT NULL COMMENT '所有父级编号',
  name varchar(100) NOT NULL COMMENT '名称',
  sort decimal(10,0) NOT NULL COMMENT '排序',
  depart_type char(1) NOT NULL COMMENT '机构类型',
  grade char(1) NOT NULL COMMENT '机构等级',
  address varchar(255) COMMENT '联系地址',
  master varchar(100) COMMENT '负责人',
  mobile varchar(200) COMMENT '手机',
  email varchar(200) COMMENT '邮箱',
  creator varchar(64) NOT NULL COMMENT '创建者',
  create_date datetime NOT NULL COMMENT '创建时间',
  updater varchar(64) NOT NULL COMMENT '更新者',
  update_date datetime NOT NULL COMMENT '更新时间',
  remark varchar(255) COMMENT '备注信息',
  enable varchar(64) COMMENT '是否可用',
  state char(1) DEFAULT '0' NOT NULL COMMENT '状态',
  PRIMARY KEY (id)
) COMMENT = '部门表';


/** user **/
CREATE TABLE t_sys_user
(
  id varchar(64) NOT NULL COMMENT '编号',
  depart_id varchar(64) NOT NULL COMMENT '归属部门',
  username varchar(100) NOT NULL COMMENT '登录名',
  password varchar(100) NOT NULL COMMENT '密码',
  user_no varchar(100) COMMENT '工号',
  name varchar(100) NOT NULL COMMENT '姓名',
  email varchar(200) COMMENT '邮箱',
  mobile varchar(200) COMMENT '手机',
  user_type char(1) COMMENT '用户类型',
  photo varchar(1000) COMMENT '用户头像',
  login_ip varchar(100) COMMENT '最后登陆IP',
  login_date datetime COMMENT '最后登陆时间',
  creator varchar(64) NOT NULL COMMENT '创建者',
  create_date datetime NOT NULL COMMENT '创建时间',
  updater varchar(64) NOT NULL COMMENT '更新者',
  update_date datetime NOT NULL COMMENT '更新时间',
  remarks varchar(255) COMMENT '备注信息',
  state char(1) DEFAULT '0' NOT NULL COMMENT '状态',
  PRIMARY KEY (id)
) COMMENT = '用户表';

/** role **/
CREATE TABLE t_sys_role
(
  id varchar(64) NOT NULL COMMENT '编号',
  name varchar(100) NOT NULL COMMENT '角色名称',
  role_type varchar(255) COMMENT '角色类型',
  depart_id varchar(64) COMMENT '归属部门',
  creator  varchar(64) NOT NULL COMMENT '创建者',
  create_date datetime NOT NULL COMMENT '创建时间',
  updater varchar(64) NOT NULL COMMENT '更新者',
  update_date datetime NOT NULL COMMENT '更新时间',
  remark varchar(255) COMMENT '备注信息',
  enable varchar(64) COMMENT '是否可用',
  state char(1) DEFAULT '0' NOT NULL COMMENT '状态',
  PRIMARY KEY (id)
) COMMENT = '角色表';


/**  user role  **/

CREATE TABLE t_sys_user_role
(
  id  int(64) NOT NULL COMMENT '编号',
  role_id varchar(64) NOT NULL COMMENT '角色编号',
  user_id varchar(64) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (id)
) COMMENT = '角色-用户';

/** role permission **/
CREATE TABLE t_sys_role_permission
(
  id  int(64) NOT NULL COMMENT '编号',
  role_id varchar(64) NOT NULL COMMENT '角色编号',
  resource_id varchar(64) NOT NULL COMMENT '资源编号',
  resource_type varchar(64) NOT NULL COMMENT '资源类型',
  PRIMARY KEY (id)
) COMMENT = '角色-菜单';

/** dict **/

/** param **/


/** index **/
CREATE INDEX idx_sys_user ON  t_sys_user (depart_id ASC);
