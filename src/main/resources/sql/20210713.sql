CREATE DATABASE `manage` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_bin';

CREATE TABLE `base_menu` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编码',
  `name` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '跳转路径',
  `level` int(2) DEFAULT NULL COMMENT '菜单级别',
  `parent_id` int(16) DEFAULT NULL COMMENT '父级菜单',
  `icon` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `menu_order` int(8) DEFAULT NULL COMMENT '顺序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `del_flag` tinyint(2) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单表';


INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (1, 'CUSTOMER_MANAGE', '客户管理', '/path', 1, 0, 'el-icon-s-custom', 1, '2021-07-14 10:55:34', '2021-07-14 10:55:34', NULL, NULL, 0);
INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (2, 'CUSTOMER_ORIGIN', '货源', '/path', 2, 1, 'el-icon-menu', 11, '2021-07-14 11:17:22', '2021-07-14 11:17:22', NULL, NULL, 0);
INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (3, 'CUSTOMER_CONSIGNOR', '货主', '/path', 2, 1, 'el-icon-menu', 12, '2021-07-14 11:19:12', '2021-07-14 11:19:12', NULL, NULL, 0);
INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (4, 'GOODS_MANAGE', '商品管理', '/path', 1, 0, 'el-icon-s-goods', 2, '2021-07-14 15:42:03', '2021-07-14 15:42:03', NULL, NULL, 0);
INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (5, 'GOODS_RECEIVE', '收货', '/path', 2, 4, 'el-icon-menu', 21, '2021-07-14 16:57:29', '2021-07-14 16:57:29', NULL, NULL, 0);
INSERT INTO `manage`.`base_menu`(`id`, `code`, `name`, `path`, `level`, `parent_id`, `icon`, `menu_order`, `create_time`, `update_time`, `create_user`, `update_user`, `del_flag`) VALUES (6, 'GOODS_SEND', '发货', '/path', 2, 4, 'el-icon-menu', 22, '2021-07-14 16:58:07', '2021-07-14 16:58:07', NULL, NULL, 0);