/*
Navicat MySQL Data Transfer

Source Server         : aiguo
Source Server Version : 80020
Source Host           : 172.30.200.1:3310
Source Database       : zzdemo-online

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2021-12-30 14:46:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zz_online_page
-- ----------------------------
DROP TABLE IF EXISTS `zz_online_page`;
CREATE TABLE `zz_online_page` (
  `page_id` bigint NOT NULL COMMENT '主键Id',
  `page_code` varchar(32)  NOT NULL COMMENT '页面编码',
  `page_name` varchar(64)  NOT NULL COMMENT '页面名称',
  `table_name` int NOT NULL COMMENT '业务表名',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`page_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


DROP TABLE IF EXISTS `zz_online_form`;
CREATE TABLE `zz_online_form` (
  `form_id` bigint NOT NULL COMMENT '主键Id',
  `page_id` bigint NOT NULL COMMENT '页面id',
  `widget_json` varchar(255)  COMMENT '表单界面及属性JSON',
  `version_id` bigint COMMENT '版本id',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`form_id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
