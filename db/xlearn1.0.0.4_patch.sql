/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : xlearn

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-08-15 00:27:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
