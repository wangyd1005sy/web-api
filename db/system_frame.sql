DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `tenant_id`    bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `user_name`    varchar(32)  DEFAULT NULL COMMENT '用户名',
    `nick_name`    varchar(32)  DEFAULT NULL COMMENT '昵称',
    `area_code`    varchar(10)  DEFAULT NULL COMMENT '手机号区号',
    `mobile`       varchar(32)  DEFAULT NULL COMMENT '手机号',
    `password`     varchar(100) DEFAULT NULL COMMENT '密码',
    `head_picture` varchar(100) DEFAULT NULL COMMENT '头像路径',
    `status`       tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `create_by`    varchar(50) NOT NULL COMMENT '创建人',
    `create_time`  bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`    varchar(50) NOT NULL COMMENT '创建人',
    `modify_time`  bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS t_system_resource;
CREATE TABLE t_system_resource
(
    `id`            bigint(20) AUTO_INCREMENT NOT NULL COMMENT 'id',
    `tenant_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `parent_id`     bigint(20) DEFAULT 0 NOT NULL COMMENT '资源父id',
    `name`          VARCHAR(32) NOT NULL COMMENT '资源名称',
    `description`   VARCHAR(64) COMMENT '资源描述',
    `resource_path` VARCHAR(100) COMMENT '资源请求路径',
    `icon_class`    VARCHAR(100) COMMENT 'icon样式',
    `type`          tinyint(3) NOT NULL COMMENT '类型，1：菜单，2：按钮',
    `sort_id`       int(11) COMMENT '顺序',
    `status`        tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `create_by`     varchar(50) NOT NULL COMMENT '创建人',
    `create_time`   bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`     varchar(50) NOT NULL COMMENT '创建人',
    `modify_time`   bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源表';

DROP TABLE IF EXISTS t_system_role;
CREATE TABLE t_system_role
(
    `id`          bigint(20) AUTO_INCREMENT NOT NULL COMMENT 'id',
    `tenant_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `name`        VARCHAR(32) NOT NULL COMMENT '角色名',
    `description` VARCHAR(64) DEFAULT NULL COMMENT '角色描述',
    `status`      tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `create_by`   varchar(50) NOT NULL COMMENT '创建人',
    `create_time` bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`   varchar(50) NOT NULL COMMENT '创建人',
    `modify_time` bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

DROP TABLE IF EXISTS t_system_role_resource;
CREATE TABLE t_system_role_resource
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `role_id`     bigint(20) NOT NULL COMMENT '角色 ID',
    `resource_id` VARCHAR(32) NOT NULL COMMENT '资源 ID',
    `status`      tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `create_by`   varchar(50) NOT NULL COMMENT '创建人',
    `create_time` bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`   varchar(50) NOT NULL COMMENT '创建人',
    `modify_time` bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

DROP TABLE IF EXISTS t_system_user_role;
CREATE TABLE t_system_user_role
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`         bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `user_id`           bigint(20) NOT NULL COMMENT '用户ID',
    `role_id`           bigint(20) NOT NULL COMMENT '角色ID',
    `status`            tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `effect_start_time` bigint(20) NOT NULL COMMENT '生效开始时间',
    `effect_end_time`   bigint(20) NOT NULL COMMENT '生效结束时间',
    `create_by`         varchar(50) NOT NULL COMMENT '创建人',
    `create_time`       bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`         varchar(50) NOT NULL COMMENT '创建人',
    `modify_time`       bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色关系表';

DROP TABLE IF EXISTS t_system_user_data_role;
CREATE TABLE t_system_user_data_role
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`         bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `user_id`           bigint(20) NOT NULL COMMENT '用户id',
    `resource_id`       bigint(20) NOT NULL COMMENT '资源id',
    `status`            tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `effect_start_time` bigint(20) NOT NULL COMMENT '生效开始时间',
    `effect_end_time`   bigint(20) NOT NULL COMMENT '生效结束时间',
    `create_by`         varchar(50) NOT NULL COMMENT '创建人',
    `create_time`       bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`         varchar(50) NOT NULL COMMENT '创建人',
    `modify_time`       bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户数据权限表';


DROP TABLE IF EXISTS t_system_data_type;
CREATE TABLE t_system_data_type
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `tenant_id`   bigint(20) NOT NULL DEFAULT '0' COMMENT '租户id',
    `date_key`    varchar(50) NOT NULL COMMENT '类型',
    `data_value`  varchar(50) NOT NULL COMMENT '类型值',
    `status`      tinyint(3) DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `create_by`   varchar(50) NOT NULL COMMENT '创建人',
    `create_time` bigint(20) NOT NULL COMMENT '创建时间',
    `modify_by`   varchar(50) NOT NULL COMMENT '创建人',
    `modify_time` bigint(20) NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    unique key `uni_data`(`date_key`, `data_value`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户数据权限类型表表';

