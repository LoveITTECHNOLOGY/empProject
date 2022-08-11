/*
 Navicat MySQL Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50541
 Source Host           : localhost:3306
 Source Schema         : emp

 Target Server Type    : MySQL
 Target Server Version : 50541
 File Encoding         : 65001

 Date: 11/08/2022 16:56:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for empmanager
-- ----------------------------
DROP TABLE IF EXISTS `empmanager`;
CREATE TABLE `empmanager`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of empmanager
-- ----------------------------
INSERT INTO `empmanager` VALUES ('admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
