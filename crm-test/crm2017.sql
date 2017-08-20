/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : crm2017

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-07-12 19:23:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'BOSS', '总经办', '0');
INSERT INTO `department` VALUES ('2', 'PERSONAL', '人事部', '0');
INSERT INTO `department` VALUES ('3', 'MARKET', '市场部', '0');
INSERT INTO `department` VALUES ('4', 'SALE', '营销部', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `inputtime` date DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_emp_dept` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', '超级管理员', '1', null, null, '2017-04-17', '0', '1', '1');
INSERT INTO `employee` VALUES ('2', 'liudh', '刘德华', '1', '13088888888', 'liudh@520it.com', '2017-04-17', '0', '0', '2');
INSERT INTO `employee` VALUES ('3', 'zhangxy', '张学友', '1', '13088888887', 'liudh@520it.com', '2017-04-17', '0', '0', '3');
INSERT INTO `employee` VALUES ('5', 'liming', '黎明', '1', '13088888886', 'liming@520it.com', '2017-04-19', '0', '0', '4');
INSERT INTO `employee` VALUES ('6', 'guofc', '郭富城', '27daf707e9d91b10ed61c9fa7cac7b1f', '13088888885', 'guofc@520it.com', '2017-06-21', '1', '0', '4');
INSERT INTO `employee` VALUES ('7', 'test', 'test', '5a105e8b9d40e1329780d62ea2265d8a', '', '', '2017-07-12', '0', '0', null);

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role` (
  `employee_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_role
-- ----------------------------
INSERT INTO `employee_role` VALUES ('2', '2');
INSERT INTO `employee_role` VALUES ('3', '3');
INSERT INTO `employee_role` VALUES ('5', '4');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `resource` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('5', '员工数据', 'employee:list');
INSERT INTO `permission` VALUES ('6', '员工新增', 'employee:save');
INSERT INTO `permission` VALUES ('7', '员工列表', 'employee:index');
INSERT INTO `permission` VALUES ('8', '员工更新', 'employee:update');
INSERT INTO `permission` VALUES ('9', '员工离职', 'employee:quit');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', 'HR', '人事专员');
INSERT INTO `role` VALUES ('3', 'MARKETMAN', '市场专员');
INSERT INTO `role` VALUES ('4', 'SALEMAN', '销售专员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('2', '2');
INSERT INTO `role_menu` VALUES ('2', '7');
INSERT INTO `role_menu` VALUES ('2', '26');
INSERT INTO `role_menu` VALUES ('2', '27');
INSERT INTO `role_menu` VALUES ('2', '28');
INSERT INTO `role_menu` VALUES ('4', '1');
INSERT INTO `role_menu` VALUES ('4', '6');
INSERT INTO `role_menu` VALUES ('4', '25');
INSERT INTO `role_menu` VALUES ('4', '38');
INSERT INTO `role_menu` VALUES ('4', '39');
INSERT INTO `role_menu` VALUES ('3', '4');
INSERT INTO `role_menu` VALUES ('3', '33');
INSERT INTO `role_menu` VALUES ('3', '34');
INSERT INTO `role_menu` VALUES ('3', '35');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '6');
INSERT INTO `role_permission` VALUES ('2', '7');
INSERT INTO `role_permission` VALUES ('2', '8');
INSERT INTO `role_permission` VALUES ('2', '9');
INSERT INTO `role_permission` VALUES ('3', '7');
INSERT INTO `role_permission` VALUES ('3', '5');
INSERT INTO `role_permission` VALUES ('4', '7');
INSERT INTO `role_permission` VALUES ('4', '5');

-- ----------------------------
-- Table structure for systemmenu
-- ----------------------------
DROP TABLE IF EXISTS `systemmenu`;
CREATE TABLE `systemmenu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(20) DEFAULT NULL,
  `iconCls` varchar(20) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_parent` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemmenu
-- ----------------------------
INSERT INTO `systemmenu` VALUES ('1', '营销管理', 'icon-add', '', null);
INSERT INTO `systemmenu` VALUES ('2', '客户管理', null, '', null);
INSERT INTO `systemmenu` VALUES ('3', '系统管理', '', '', null);
INSERT INTO `systemmenu` VALUES ('4', '订单合同管理', null, '', null);
INSERT INTO `systemmenu` VALUES ('6', '潜在客户开发计划', 'icon-remove', '', '1');
INSERT INTO `systemmenu` VALUES ('7', '客户信息管理', null, '', '2');
INSERT INTO `systemmenu` VALUES ('25', '潜在客户管理', 'icon-add', '', '1');
INSERT INTO `systemmenu` VALUES ('26', '客户跟进历史', '', '', '2');
INSERT INTO `systemmenu` VALUES ('27', '客户移交记录', '', '', '2');
INSERT INTO `systemmenu` VALUES ('28', '客户资源池管理', '', '', '2');
INSERT INTO `systemmenu` VALUES ('29', '员工管理', '', '/employee', '3');
INSERT INTO `systemmenu` VALUES ('30', '部门管理', '', '/department', '3');
INSERT INTO `systemmenu` VALUES ('31', '角色管理', '', '/role', '3');
INSERT INTO `systemmenu` VALUES ('32', '数据字典', '', '', '3');
INSERT INTO `systemmenu` VALUES ('33', '合同管理', '', '', '4');
INSERT INTO `systemmenu` VALUES ('34', '订单管理', '', '', '4');
INSERT INTO `systemmenu` VALUES ('35', '售后管理', '', '', null);
INSERT INTO `systemmenu` VALUES ('36', '权限管理', '', '/permission', '3');
INSERT INTO `systemmenu` VALUES ('37', '菜单管理', '', '/systemMenu', '3');
INSERT INTO `systemmenu` VALUES ('38', 'test1', 'icon-add', '', '1');
INSERT INTO `systemmenu` VALUES ('39', 'test11', 'icon-tip', '', '38');
