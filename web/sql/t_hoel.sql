/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/1/21 16:08:39                           */
/*==============================================================*/


drop table if exists t_admin;

drop table if exists t_food;

drop table if exists t_food_type;

drop table if exists t_menu;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   admin_id             int not null auto_increment,
   admin_name           varchar(20),
   password             varchar(60),
   status               tinyint comment '0:未激活 1:已激活 2:已禁用',
   phone                varchar(11),
   email                varchar(30),
   role                 varchar(1) comment '0:超级管理员 1:管理员 2:普通用户',
   admin_create_time    datetime,
   admin_update_time    datetime,
   primary key (admin_id)
);

alter table t_admin comment '这是管理员表';

/*==============================================================*/
/* Table: t_food                                                */
/*==============================================================*/
create table t_food
(
   food_id              int not null auto_increment,
   type_id              int,
   food_name            varchar(20),
   price                bigint comment '价格以分为单位',
   vip_price            bigint,
   image                varchar(300),
   food_desc            varchar(300),
   primary key (food_id)
);

alter table t_food comment '这是一个菜品表';

/*==============================================================*/
/* Table: t_food_type                                           */
/*==============================================================*/
create table t_food_type
(
   type_id              int not null auto_increment,
   type_name            varchar(20),
   primary key (type_id)
);

alter table t_food_type comment '这是一个菜类别表';

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   menu_id              int not null auto_increment comment '这是主键',
   menu_name            varchar(20) comment '菜单名称',
   url                  varchar(200) comment '菜单URL',
   menu_create_time     datetime,
   menu_update_time     datetime,
   menu_create_user     int,
   menu_update_user     int,
   primary key (menu_id)
);

alter table t_menu comment '这是菜单表';

alter table t_food add constraint FK_菜类别与菜一对多 foreign key (type_id)
      references t_food_type (type_id) on delete restrict on update restrict;

