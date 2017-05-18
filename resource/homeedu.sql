/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : homeedu

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2017-05-18 16:27:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(5) NOT NULL,
  `UserId` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '201401', 'arron', '123');
INSERT INTO `test` VALUES ('2', '201402', 'ming', '345');
