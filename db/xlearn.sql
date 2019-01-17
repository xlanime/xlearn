/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : xlearn

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-08-18 11:19:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xlearn_clock
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_clock`;
CREATE TABLE `xlearn_clock` (
  `clock_id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`clock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_clock
-- ----------------------------
INSERT INTO `xlearn_clock` VALUES ('8', '2018-07-17 00:15:19', '2018-07-17 00:15:21', '2', '0', '2018-07-17 00:15:19', '2018-07-17 00:15:21');
INSERT INTO `xlearn_clock` VALUES ('9', '2018-07-17 00:15:47', '2018-07-17 00:16:00', '2', '0', '2018-07-17 00:15:47', '2018-07-17 00:16:00');
INSERT INTO `xlearn_clock` VALUES ('10', '2018-07-17 00:17:31', '2018-07-17 00:17:31', '2', '0', '2018-07-17 00:17:31', '2018-07-17 00:17:31');
INSERT INTO `xlearn_clock` VALUES ('11', '2018-07-17 00:19:07', '2018-07-17 00:19:10', '2', '0', '2018-07-17 00:19:07', '2018-07-17 00:19:10');
INSERT INTO `xlearn_clock` VALUES ('12', '2018-07-17 00:19:48', '2018-07-17 00:19:52', '2', '0', '2018-07-17 00:19:48', '2018-07-17 00:19:52');
INSERT INTO `xlearn_clock` VALUES ('13', '2018-07-17 00:20:34', '2018-07-17 00:20:37', '2', '0', '2018-07-17 00:20:34', '2018-07-17 00:20:37');
INSERT INTO `xlearn_clock` VALUES ('14', '2018-07-17 21:56:24', '2018-07-17 21:57:13', '2', '0', '2018-07-17 21:56:24', '2018-07-17 21:57:13');
INSERT INTO `xlearn_clock` VALUES ('15', '2018-07-17 21:57:47', '2018-07-17 21:57:49', '2', '0', '2018-07-17 21:57:47', '2018-07-17 21:57:49');
INSERT INTO `xlearn_clock` VALUES ('16', '2018-07-17 21:58:59', '2018-07-17 21:59:01', '2', '0', '2018-07-17 21:58:59', '2018-07-17 21:59:01');
INSERT INTO `xlearn_clock` VALUES ('17', '2018-07-17 22:00:28', '2018-07-17 22:00:30', '2', '0', '2018-07-17 22:00:28', '2018-07-17 22:00:30');
INSERT INTO `xlearn_clock` VALUES ('18', '2018-07-17 22:00:58', '2018-07-17 22:01:02', '2', '0', '2018-07-17 22:00:58', '2018-07-17 22:01:02');
INSERT INTO `xlearn_clock` VALUES ('19', '2018-07-17 22:02:49', '2018-07-17 22:02:53', '2', '1', '2018-07-17 22:02:49', '2018-07-17 22:02:53');
INSERT INTO `xlearn_clock` VALUES ('20', '2018-07-17 22:03:18', '2018-07-17 22:03:19', '2', '1', '2018-07-17 22:03:18', '2018-07-17 22:03:19');
INSERT INTO `xlearn_clock` VALUES ('21', '2018-07-17 22:26:57', '2018-07-17 22:26:57', '2', '0', '2018-07-17 22:26:57', '2018-07-17 22:26:57');
INSERT INTO `xlearn_clock` VALUES ('22', '2018-07-17 22:32:09', '2018-07-17 22:32:09', '2', '0', '2018-07-17 22:32:09', '2018-07-17 22:32:09');
INSERT INTO `xlearn_clock` VALUES ('23', '2018-07-17 22:32:57', '2018-07-17 22:32:57', '2', '0', '2018-07-17 22:32:57', '2018-07-17 22:32:57');
INSERT INTO `xlearn_clock` VALUES ('24', '2018-07-17 22:53:09', '2018-07-17 22:53:09', '2', '0', '2018-07-17 22:53:09', '2018-07-17 22:53:09');
INSERT INTO `xlearn_clock` VALUES ('25', '2018-07-17 23:02:16', '2018-07-17 23:02:16', '2', '0', '2018-07-17 23:02:16', '2018-07-17 23:02:16');
INSERT INTO `xlearn_clock` VALUES ('26', '2018-07-18 22:12:18', '2018-07-18 22:12:18', '2', '0', '2018-07-18 22:12:18', '2018-07-18 22:12:18');
INSERT INTO `xlearn_clock` VALUES ('27', '2018-07-18 23:01:39', '2018-07-18 23:01:39', '2', '0', '2018-07-18 23:01:39', '2018-07-18 23:01:39');
INSERT INTO `xlearn_clock` VALUES ('28', '2018-07-19 21:39:52', '2018-07-19 21:39:52', '2', '0', '2018-07-19 21:39:52', '2018-07-19 21:39:52');
INSERT INTO `xlearn_clock` VALUES ('29', '2018-07-19 22:59:30', '2018-07-19 22:59:30', '2', '0', '2018-07-19 22:59:30', '2018-07-19 22:59:30');
INSERT INTO `xlearn_clock` VALUES ('30', '2018-07-19 23:07:04', '2018-07-19 23:07:04', '2', '0', '2018-07-19 23:07:04', '2018-07-19 23:07:04');
INSERT INTO `xlearn_clock` VALUES ('31', '2018-07-19 23:10:40', '2018-07-19 23:10:40', '2', '0', '2018-07-19 23:10:40', '2018-07-19 23:10:40');
INSERT INTO `xlearn_clock` VALUES ('32', '2018-07-19 23:51:47', '2018-07-19 23:51:49', '2', '0', '2018-07-19 23:51:47', '2018-07-19 23:51:49');
INSERT INTO `xlearn_clock` VALUES ('33', '2018-07-19 23:52:38', '2018-07-19 23:52:38', '2', '0', '2018-07-19 23:52:38', '2018-07-19 23:52:38');
INSERT INTO `xlearn_clock` VALUES ('34', '2018-07-20 00:52:07', '2018-07-20 01:28:33', '2', '1', '2018-07-20 00:52:07', '2018-07-20 01:28:33');
INSERT INTO `xlearn_clock` VALUES ('35', '2018-07-20 23:05:11', '2018-07-21 02:52:10', '2', '4', '2018-07-20 23:05:11', '2018-07-21 02:52:10');
INSERT INTO `xlearn_clock` VALUES ('36', '2018-07-21 02:54:32', '2018-07-21 02:54:34', '2', '0', '2018-07-21 02:54:32', '2018-07-21 02:54:34');
INSERT INTO `xlearn_clock` VALUES ('37', '2018-07-21 02:55:07', '2018-07-21 02:55:20', '2', '0', '2018-07-21 02:55:07', '2018-07-21 02:55:20');
INSERT INTO `xlearn_clock` VALUES ('38', '2018-07-21 02:55:43', '2018-07-21 02:55:57', '2', '0', '2018-07-21 02:55:43', '2018-07-21 02:55:57');
INSERT INTO `xlearn_clock` VALUES ('39', '2018-07-21 02:58:12', '2018-07-21 02:58:40', '2', '0', '2018-07-21 02:58:12', '2018-07-21 02:58:40');
INSERT INTO `xlearn_clock` VALUES ('40', '2018-07-21 02:59:09', '2018-07-21 02:59:22', '2', '0', '2018-07-21 02:59:09', '2018-07-21 02:59:22');
INSERT INTO `xlearn_clock` VALUES ('41', '2018-07-21 02:59:38', '2018-07-21 03:00:27', '2', '0', '2018-07-21 02:59:38', '2018-07-21 03:00:27');
INSERT INTO `xlearn_clock` VALUES ('42', '2018-07-21 03:06:24', '2018-07-21 03:06:58', '2', '0', '2018-07-21 03:06:24', '2018-07-21 03:06:58');
INSERT INTO `xlearn_clock` VALUES ('43', '2018-07-21 03:07:10', '2018-07-21 03:07:21', '2', '0', '2018-07-21 03:07:10', '2018-07-21 03:07:21');
INSERT INTO `xlearn_clock` VALUES ('44', '2018-07-21 03:08:57', '2018-07-21 03:09:13', '2', '0', '2018-07-21 03:08:57', '2018-07-21 03:09:13');
INSERT INTO `xlearn_clock` VALUES ('45', '2018-07-21 10:04:22', '2018-07-21 14:30:13', '2', '5', '2018-07-21 10:04:22', '2018-07-21 14:30:13');
INSERT INTO `xlearn_clock` VALUES ('46', '2018-07-22 16:16:53', '2018-07-22 16:16:53', '2', '0', '2018-07-22 16:16:53', '2018-07-22 16:16:53');
INSERT INTO `xlearn_clock` VALUES ('47', '2018-07-22 17:01:11', '2018-07-22 17:01:15', '2', '0', '2018-07-22 17:01:11', '2018-07-22 17:01:15');
INSERT INTO `xlearn_clock` VALUES ('48', '2018-07-22 20:06:15', '2018-07-22 20:06:15', '2', '0', '2018-07-22 20:06:15', '2018-07-22 20:06:15');
INSERT INTO `xlearn_clock` VALUES ('49', '2018-07-22 22:23:09', '2018-07-23 00:29:28', '2', '3', '2018-07-22 22:23:09', '2018-07-23 00:29:28');
INSERT INTO `xlearn_clock` VALUES ('50', '2018-07-24 23:28:55', '2018-07-25 01:00:11', '2', '2', '2018-07-24 23:28:55', '2018-07-25 01:00:11');
INSERT INTO `xlearn_clock` VALUES ('51', '2018-08-06 20:31:21', '2018-08-06 20:31:31', '2', '0', '2018-08-06 20:31:21', '2018-08-06 20:31:31');
INSERT INTO `xlearn_clock` VALUES ('52', '2018-08-06 20:31:49', '2018-08-06 20:32:02', '2', '0', '2018-08-06 20:31:49', '2018-08-06 20:32:02');
INSERT INTO `xlearn_clock` VALUES ('53', '2018-08-06 20:33:46', '2018-08-06 20:33:49', '2', '0', '2018-08-06 20:33:46', '2018-08-06 20:33:49');
INSERT INTO `xlearn_clock` VALUES ('54', '2018-08-06 20:46:48', '2018-08-06 20:46:54', '2', '0', '2018-08-06 20:46:48', '2018-08-06 20:46:54');
INSERT INTO `xlearn_clock` VALUES ('55', '2018-08-06 20:47:31', '2018-08-06 20:51:17', '2', '0', '2018-08-06 20:47:31', '2018-08-06 20:51:17');
INSERT INTO `xlearn_clock` VALUES ('56', '2018-08-06 20:51:39', '2018-08-06 20:51:42', '2', '0', '2018-08-06 20:51:39', '2018-08-06 20:51:42');
INSERT INTO `xlearn_clock` VALUES ('57', '2018-08-06 21:16:24', '2018-08-06 21:16:28', '2', '0', '2018-08-06 21:16:24', '2018-08-06 21:16:28');
INSERT INTO `xlearn_clock` VALUES ('58', '2018-08-06 21:16:41', '2018-08-06 21:16:50', '2', '0', '2018-08-06 21:16:41', '2018-08-06 21:16:50');
INSERT INTO `xlearn_clock` VALUES ('59', '2018-08-06 21:17:05', '2018-08-06 21:17:05', '2', '0', '2018-08-06 21:17:05', '2018-08-06 21:17:05');
INSERT INTO `xlearn_clock` VALUES ('60', '2018-08-13 23:45:03', '2018-08-13 23:45:03', '2', '0', '2018-08-13 23:45:03', '2018-08-13 23:45:03');
INSERT INTO `xlearn_clock` VALUES ('61', '2018-08-13 23:46:14', '2018-08-13 23:46:14', '2', '0', '2018-08-13 23:46:14', '2018-08-13 23:46:14');
INSERT INTO `xlearn_clock` VALUES ('62', '2018-08-13 23:47:57', '2018-08-13 23:47:57', '2', '0', '2018-08-13 23:47:57', '2018-08-13 23:47:57');
INSERT INTO `xlearn_clock` VALUES ('63', '2018-08-13 23:49:06', '2018-08-13 23:49:06', '2', '0', '2018-08-13 23:49:06', '2018-08-13 23:49:06');
INSERT INTO `xlearn_clock` VALUES ('64', '2018-08-13 23:50:54', '2018-08-13 23:50:54', '2', '0', '2018-08-13 23:50:54', '2018-08-13 23:50:54');
INSERT INTO `xlearn_clock` VALUES ('65', '2018-08-13 23:51:31', '2018-08-13 23:51:31', '2', '0', '2018-08-13 23:51:31', '2018-08-13 23:51:31');
INSERT INTO `xlearn_clock` VALUES ('66', '2018-08-13 23:52:11', '2018-08-13 23:52:11', '2', '0', '2018-08-13 23:52:11', '2018-08-13 23:52:11');
INSERT INTO `xlearn_clock` VALUES ('67', '2018-08-13 23:52:52', '2018-08-13 23:52:52', '2', '0', '2018-08-13 23:52:52', '2018-08-13 23:52:52');
INSERT INTO `xlearn_clock` VALUES ('68', '2018-08-13 23:54:57', '2018-08-13 23:54:57', '2', '0', '2018-08-13 23:54:57', '2018-08-13 23:54:57');
INSERT INTO `xlearn_clock` VALUES ('69', '2018-08-13 23:57:28', '2018-08-13 23:57:28', '2', '0', '2018-08-13 23:57:28', '2018-08-13 23:57:28');
INSERT INTO `xlearn_clock` VALUES ('70', '2018-08-13 23:59:29', '2018-08-13 23:59:29', '2', '0', '2018-08-13 23:59:29', '2018-08-13 23:59:29');
INSERT INTO `xlearn_clock` VALUES ('71', '2018-08-14 00:03:24', '2018-08-14 00:03:24', '2', '0', '2018-08-14 00:03:24', '2018-08-14 00:03:24');
INSERT INTO `xlearn_clock` VALUES ('72', '2018-08-14 00:04:58', '2018-08-14 00:04:58', '2', '0', '2018-08-14 00:04:58', '2018-08-14 00:04:58');
INSERT INTO `xlearn_clock` VALUES ('73', '2018-08-14 00:06:16', '2018-08-14 00:06:16', '2', '0', '2018-08-14 00:06:16', '2018-08-14 00:06:16');
INSERT INTO `xlearn_clock` VALUES ('74', '2018-08-14 00:15:06', '2018-08-14 00:15:06', '2', '0', '2018-08-14 00:15:06', '2018-08-14 00:15:06');
INSERT INTO `xlearn_clock` VALUES ('75', '2018-08-14 00:17:51', '2018-08-14 00:17:51', '2', '0', '2018-08-14 00:17:51', '2018-08-14 00:17:51');
INSERT INTO `xlearn_clock` VALUES ('76', '2018-08-14 00:18:31', '2018-08-14 00:18:31', '2', '0', '2018-08-14 00:18:31', '2018-08-14 00:18:31');
INSERT INTO `xlearn_clock` VALUES ('77', '2018-08-14 00:20:28', '2018-08-14 00:20:28', '2', '0', '2018-08-14 00:20:28', '2018-08-14 00:20:28');
INSERT INTO `xlearn_clock` VALUES ('78', '2018-08-14 00:21:17', '2018-08-14 00:21:17', '2', '0', '2018-08-14 00:21:17', '2018-08-14 00:21:17');
INSERT INTO `xlearn_clock` VALUES ('79', '2018-08-14 00:21:45', '2018-08-14 00:21:45', '2', '0', '2018-08-14 00:21:45', '2018-08-14 00:21:45');
INSERT INTO `xlearn_clock` VALUES ('80', '2018-08-14 00:22:29', '2018-08-14 00:22:29', '2', '0', '2018-08-14 00:22:29', '2018-08-14 00:22:29');
INSERT INTO `xlearn_clock` VALUES ('81', '2018-08-14 00:23:48', '2018-08-14 00:23:48', '2', '0', '2018-08-14 00:23:48', '2018-08-14 00:23:48');

-- ----------------------------
-- Table structure for xlearn_group
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_group`;
CREATE TABLE `xlearn_group` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `group_remark` varchar(1000) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_group
-- ----------------------------

-- ----------------------------
-- Table structure for xlearn_private_task
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_private_task`;
CREATE TABLE `xlearn_private_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_points` int(11) NOT NULL,
  `task_name` varchar(255) NOT NULL,
  `task_value` varchar(1000) NOT NULL,
  `task_cover` varchar(255) DEFAULT NULL,
  `finished` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `task_time` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_private_task
-- ----------------------------
INSERT INTO `xlearn_private_task` VALUES ('6', '3', '3', '3', null, '0', '2', '3', '2018-08-14 01:27:47', '2018-08-14 01:27:47');
INSERT INTO `xlearn_private_task` VALUES ('7', '2', '22', '22', null, '0', '8', '2', '2018-08-14 01:29:31', '2018-08-14 01:29:31');
INSERT INTO `xlearn_private_task` VALUES ('8', '2', '2', '22', null, '0', '8', '2', '2018-08-14 01:29:39', '2018-08-14 01:29:39');
INSERT INTO `xlearn_private_task` VALUES ('9', '2', '2', '2', null, '0', '8', '2', '2018-08-14 01:30:08', '2018-08-14 01:30:08');
INSERT INTO `xlearn_private_task` VALUES ('10', '2222', '2222', '222', null, '0', '2', '2222', '2018-08-14 01:31:24', '2018-08-14 01:31:24');
INSERT INTO `xlearn_private_task` VALUES ('12', '3', '77', '67', null, '1', '2', '1', '2018-08-14 01:33:24', '2018-08-14 01:33:24');

-- ----------------------------
-- Table structure for xlearn_reward
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_reward`;
CREATE TABLE `xlearn_reward` (
  `reward_id` int(11) NOT NULL AUTO_INCREMENT,
  `reward_name` varchar(255) NOT NULL,
  `reward_cover` varchar(255) DEFAULT NULL,
  `reward_consume` int(11) NOT NULL,
  `reward_stock` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`reward_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_reward
-- ----------------------------
INSERT INTO `xlearn_reward` VALUES ('17', '11', null, '1', '2220', '2018-08-09 02:52:51', '2018-08-14 00:28:56');
INSERT INTO `xlearn_reward` VALUES ('18', '5', null, '5', '5', '2018-08-15 00:49:57', '2018-08-15 00:49:57');
INSERT INTO `xlearn_reward` VALUES ('19', '5', null, '5', '5', '2018-08-15 00:50:00', '2018-08-15 00:50:00');
INSERT INTO `xlearn_reward` VALUES ('20', '5', null, '5', '5', '2018-08-15 00:50:03', '2018-08-15 00:50:03');
INSERT INTO `xlearn_reward` VALUES ('21', '3', null, '2', '1', '2018-08-15 00:50:05', '2018-08-15 00:50:05');
INSERT INTO `xlearn_reward` VALUES ('22', '1', null, '23', '4', '2018-08-15 00:50:08', '2018-08-15 00:50:08');
INSERT INTO `xlearn_reward` VALUES ('23', '32', null, '2', '3', '2018-08-15 00:50:11', '2018-08-15 00:50:11');
INSERT INTO `xlearn_reward` VALUES ('24', '3', null, '32', '2', '2018-08-15 00:50:15', '2018-08-15 00:50:15');
INSERT INTO `xlearn_reward` VALUES ('25', '4', null, '5', '6', '2018-08-15 00:50:17', '2018-08-15 00:50:17');
INSERT INTO `xlearn_reward` VALUES ('26', '8', null, '6', '6', '2018-08-15 00:50:20', '2018-08-15 00:50:20');
INSERT INTO `xlearn_reward` VALUES ('27', '1', null, '2', '4', '2018-08-15 00:50:23', '2018-08-15 00:50:23');
INSERT INTO `xlearn_reward` VALUES ('28', '6', null, '6', '6', '2018-08-15 00:50:26', '2018-08-15 00:50:26');

-- ----------------------------
-- Table structure for xlearn_reward_record
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_reward_record`;
CREATE TABLE `xlearn_reward_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_reward` int(11) NOT NULL,
  `record_user` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_reward_record
-- ----------------------------
INSERT INTO `xlearn_reward_record` VALUES ('1', '5', '2', '2018-07-22 22:00:12', '2018-07-22 22:00:12');
INSERT INTO `xlearn_reward_record` VALUES ('2', '17', '2', '2018-08-09 02:53:06', '2018-08-09 02:53:06');
INSERT INTO `xlearn_reward_record` VALUES ('3', '17', '2', '2018-08-14 00:25:06', '2018-08-14 00:25:06');
INSERT INTO `xlearn_reward_record` VALUES ('4', '17', '2', '2018-08-14 00:25:09', '2018-08-14 00:25:09');
INSERT INTO `xlearn_reward_record` VALUES ('5', '17', '2', '2018-08-14 00:25:23', '2018-08-14 00:25:23');
INSERT INTO `xlearn_reward_record` VALUES ('6', '17', '2', '2018-08-14 00:28:53', '2018-08-14 00:28:53');
INSERT INTO `xlearn_reward_record` VALUES ('7', '17', '2', '2018-08-14 00:28:56', '2018-08-14 00:28:56');

-- ----------------------------
-- Table structure for xlearn_task
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_task`;
CREATE TABLE `xlearn_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_points` int(11) NOT NULL,
  `task_name` varchar(255) NOT NULL,
  `task_value` varchar(1000) NOT NULL,
  `task_cover` varchar(255) DEFAULT NULL,
  `finished` int(11) DEFAULT NULL,
  `task_time` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_task
-- ----------------------------
INSERT INTO `xlearn_task` VALUES ('1', '1', '1', '1', null, '0', '9', '2018-08-09 02:15:30', '2018-08-14 00:24:58');
INSERT INTO `xlearn_task` VALUES ('3', '3', '3', '3', null, '1', '1', '2018-08-09 02:30:03', '2018-08-09 02:48:07');
INSERT INTO `xlearn_task` VALUES ('4', '222', '任务名称', '内容', null, '1', '1', '2018-08-09 02:32:31', '2018-08-09 02:47:56');

-- ----------------------------
-- Table structure for xlearn_user
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_user`;
CREATE TABLE `xlearn_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `user_points` int(11) DEFAULT NULL COMMENT '用户积分',
  `regist_time` datetime NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `user_head` varchar(255) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_user
-- ----------------------------
INSERT INTO `xlearn_user` VALUES ('1', 'admin', 'admin', '123', null, '0', '2018-07-16 00:01:17', null, null, null, '2018-07-16 00:01:17', '2018-07-16 00:01:17');
INSERT INTO `xlearn_user` VALUES ('2', 'richard', 'CB20305808B1AF95E2E0A85135DFD01A', '谢轩辚', '', '81', '2018-07-16 23:10:25', null, null, '1', '2018-07-16 23:10:25', '2018-07-16 23:10:25');
INSERT INTO `xlearn_user` VALUES ('3', '123', 'CB20305808B1AF95E2E0A85135DFD01A', '123', null, '0', '2018-07-19 23:54:37', null, null, null, '2018-07-19 23:54:37', '2018-07-19 23:54:37');
INSERT INTO `xlearn_user` VALUES ('4', 'doudou', 'CB20305808B1AF95E2E0A85135DFD01A', 'doudou', null, '0', '2018-07-24 23:47:22', null, null, null, '2018-07-24 23:47:22', '2018-07-24 23:47:22');
INSERT INTO `xlearn_user` VALUES ('5', 'doudou2', '134241EA2572CE99AC8140B2160F1E3D', '123', null, '0', '2018-07-24 23:48:55', null, null, null, '2018-07-24 23:48:55', '2018-07-24 23:48:55');
INSERT INTO `xlearn_user` VALUES ('6', 'doudou3', 'CB20305808B1AF95E2E0A85135DFD01A', '123', null, '0', '2018-07-24 23:49:10', null, null, null, '2018-07-24 23:49:10', '2018-07-24 23:49:10');
INSERT INTO `xlearn_user` VALUES ('7', 'richard2', 'CB20305808B1AF95E2E0A85135DFD01A', '222', null, '0', '2018-08-06 20:41:38', null, null, null, '2018-08-06 20:41:38', '2018-08-06 20:41:38');
INSERT INTO `xlearn_user` VALUES ('8', '2', 'CB20305808B1AF95E2E0A85135DFD01A', '1', null, '0', '2018-08-14 01:29:19', null, '/images/head/0.jpg', null, '2018-08-14 01:29:19', '2018-08-14 01:29:19');

-- ----------------------------
-- Table structure for xlearn_user_group
-- ----------------------------
DROP TABLE IF EXISTS `xlearn_user_group`;
CREATE TABLE `xlearn_user_group` (
  `mem_group_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`mem_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xlearn_user_group
-- ----------------------------
