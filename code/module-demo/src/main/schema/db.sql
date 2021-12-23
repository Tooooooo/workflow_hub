/*
Navicat MySQL Data Transfer

Source Server         : 本地MYSQL
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : opr

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-01-03 14:05:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topic_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `which_module` int(2) unsigned NOT NULL COMMENT '所属的module',
  `topic_name` varchar(32) NOT NULL COMMENT '主题的名称',
  PRIMARY KEY (`topic_id`)
) AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `module_name` varchar(32) NOT NULL COMMENT '模块的名称',
  PRIMARY KEY (`module_id`)
) AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `brief` varchar(255) DEFAULT NULL COMMENT '关于该操作的简述',
  `location` varchar(128) NOT NULL COMMENT '操作对应的 class & method',
  `module` int(2) unsigned NOT NULL COMMENT '操作关联的功能模块',
  `topic` int(2) unsigned NOT NULL COMMENT '操作的目标对象',
  `operation_type` tinyint(2) unsigned NOT NULL COMMENT '操作的动作类型: 1 - 创建, 2 - 添加, 3 - 修改, 4 - 删除, 5 - 销毁, 6 - 审核, 7 - 屏蔽, 8 - 启用, 9 - 归档, 10 - 不详',
  `target_class` varchar(192) DEFAULT NULL COMMENT '关于操作作用于的具体业务对象类型',
  `marker` varchar(32) DEFAULT NULL COMMENT '记录的人为归类，对应 slf4j 里面的 marker',
  `content` varchar(2048) DEFAULT NULL COMMENT '记录目标数据对象的值的变化',
  `operator` int(3) unsigned NOT NULL COMMENT '操作员',
  `status` tinyint(1) unsigned NOT NULL COMMENT '操作结果: 0 - 失败, 1 - 成功',
  `moment` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作发生的时间 ',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `operator_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(32) NOT NULL COMMENT '操作者的系统登录账号',
  `ip` varchar(15) NULL COMMENT '操作者访问系统时的ip地址',
  `person_name` varchar(32) DEFAULT NULL COMMENT '操作者的姓名',
  PRIMARY KEY (`operator_id`)
) AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;
