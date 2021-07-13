CREATE DATABASE `manage` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_bin';

CREATE TABLE `base_menu` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编码',
  `name` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '跳转路径',
  `level` int(2) DEFAULT NULL COMMENT '菜单级别',
  `parent_id` int(16) DEFAULT NULL COMMENT '父级菜单',
  `icon` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `del_flag` tinyint(2) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单表';