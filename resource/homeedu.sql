/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : homeedu

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2017-06-20 11:26:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `level` int(1) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) NOT NULL,
  `surname` char(4) NOT NULL,
  `course1` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `course2` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `course3` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `student_gender` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `student_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `student_status` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `teach_gender` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `teach_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `teach_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `teach_request` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '黄女士', '语文', '数学', '化学', '女', '学生成绩不太好', '高中三年级', '女', '和平区', '星期四和星期五的晚上，每次2小时', '100每小时', '希望老师有耐心，成绩好', '2017-06-07 00:00:00');
INSERT INTO `message` VALUES ('2', '谢先生', '语文', '数学', '化学', '男', '学生成绩不太好', '高中三年级', '女', '和平区', '星期四和星期五的晚上，每次2小时', '100每小时', '希望老师有耐心，成绩好', '2017-06-19 19:52:09');
INSERT INTO `message` VALUES ('3', '王先生', '物理', '数学', '生物', '男', '学生成绩不太好', '高中三年级', '女', '沈河区', '星期四和星期五的晚上，每次2小时', '150每小时', '希望老师有耐心，成绩好', '2017-06-19 20:16:22');
INSERT INTO `message` VALUES ('4', '向先生', '英语', '数学', '生物', '女', '成绩一般', '初中三年级', '男', '大东区', '星期四和星期五的晚上，每次2小时', '90每小时', '希望老师有耐心，成绩好', '2017-06-19 21:18:22');
INSERT INTO `message` VALUES ('5', '王女士', '政治', '数学', '生物', '女', '成绩一般', '初中三年级', '男', '大东区', '星期四和星期五的晚上，每次2小时', '90每小时', '希望老师有耐心，成绩好', '2017-06-19 21:21:22');
INSERT INTO `message` VALUES ('6', '赵女士', '小学数学', '语文', '生物', '男', '调皮成绩差', '小学一年级', '女', '沈河', '星期四和星期五的晚上，每次2小时', '150每小时', '希望老师有耐心，成绩好', '2017-06-19 21:16:22');
INSERT INTO `message` VALUES ('7', '欧阳女士', '初中物理', '语文', '生物', '男', '物理很差，需要好好补补', '初二物理', '女', '和平', '一周五次，每次2小时', '110每小时', '希望老师成绩好', '2017-06-19 21:29:22');
INSERT INTO `message` VALUES ('8', '张先生', '初中化学', '', '', '男', '化学很差，需要耐心的老师', '初三化学', '男', '和平', '一周3次，每次1.5小时', '80每小时', '希望老师成绩好', '2017-06-19 21:30:27');
INSERT INTO `message` VALUES ('9', '吴先生', '化学', '物理', '', '男', '化学很差，需要耐心的老师', '初三化学', '男', '和平', '一周3次，每次1.5小时', '80每小时', '希望老师成绩好', '2017-06-19 21:34:22');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) NOT NULL,
  `teacher_id` int(10) NOT NULL,
  `parent_id` int(10) NOT NULL,
  `message_id` int(10) NOT NULL,
  `deal` int(1) NOT NULL DEFAULT '0',
  `deal_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for parent
-- ----------------------------
DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent` (
  `id` varchar(16) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ID_num` varchar(20) NOT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `level` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parent
-- ----------------------------
INSERT INTO `parent` VALUES ('1001', '王二小', '123456', '500236', '辽宁省', '沈阳市', '和平区', '136353', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `gender` char(2) NOT NULL,
  `birth_year` varchar(4) NOT NULL,
  `birth_month` varchar(2) NOT NULL,
  `sno` varchar(8) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GPA` varchar(6) NOT NULL,
  `portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduction` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `level` int(1) NOT NULL DEFAULT '0',
  `course1` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `course2` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `course3` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `course4` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `course5` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `teach_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ordernum` varchar(10) DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1001', '王', '436603', 'm', '', '', '', '', '', '', '', '', '', '1', '', '', '', '', '', '', '', '', '2017-06-19 22:51:31', '2017-06-19 22:51:31');

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
