DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demo_uuid` varchar(32) NOT NULL,
  `content` varchar(36) DEFAULT NULL COMMENT '内容',
  `status` int(2) DEFAULT '1' COMMENT '通用状态 0:删除,1:正常',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_uid` varchar(36) DEFAULT NULL COMMENT '创建人uuid',
  `update_uid` varchar(36) DEFAULT NULL COMMENT '更新人uuid',
  `remark` varchar(255) DEFAULT NULL COMMENT '通用备注',
  `sort` int(8) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_demo_uuid` (`demo_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo表';

insert into demo(demo_uuid,content) values(replace(UUID(),'-',''),'dsds1');
insert into demo(demo_uuid,content) values(replace(UUID(),'-',''),'dsds2');
insert into demo(demo_uuid,content) values(replace(UUID(),'-',''),'dsds3');
insert into demo(demo_uuid,content) values(replace(UUID(),'-',''),'dsds4');