CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `sex` CHAR(1) NOT NULL,
  `address` VARCHAR(100)  NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=innodb DEFAULT CHARSET=utf8 ;

CREATE TABLE `test` (
  `id` VARCHAR(36) NOT NULL ,
  `name` VARCHAR(32) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `sex` CHAR(1) NOT NULL,
  `address` VARCHAR(100)  NULL,
  `create_time` datetime NOT NULL,
  `modify_date` datetime not null,
  PRIMARY KEY (`id`)
) ENGINE=innodb DEFAULT CHARSET=utf8 ;


 insert into test (id,name,age,sex,address,create_time,modify_date) values ('1','yu','30','M','hz',now(),now());
 
 
 
CREATE TABLE `m_app_dictionary` (
  `id` varchar(255) NOT NULL COMMENT 'ID',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime NOT NULL COMMENT '更新时间',
  `t_name` varchar(64) DEFAULT NULL COMMENT '字典名称',
  `t_value` varchar(64) DEFAULT NULL COMMENT '枚举值',
  `t_type` varchar(64) DEFAULT NULL COMMENT '字典类型',
  `t_desc` varchar(128) DEFAULT NULL COMMENT '枚举值描述',
  `t_sort` varchar(32) DEFAULT NULL COMMENT '枚举序号',
  `t_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 可用  1不可用',
  `del` tinyint(1) DEFAULT NULL COMMENT '删除标记 0-未删除  1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

