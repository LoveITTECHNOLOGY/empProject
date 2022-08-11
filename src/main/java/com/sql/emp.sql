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

 Date: 11/08/2022 16:56:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` double NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '我爱吃屎', 4000, 34);

SET FOREIGN_KEY_CHECKS = 1;
