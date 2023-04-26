/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : ping

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 26/04/2023 10:03:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo1ck
-- ----------------------------
DROP TABLE IF EXISTS `demo1ck`;
CREATE TABLE `demo1ck`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ckbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ckxx` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `useruuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo1ck
-- ----------------------------
INSERT INTO `demo1ck` VALUES ('123123', '123123', 'A01', '综合窗口', NULL, 'Y');
INSERT INTO `demo1ck` VALUES ('123', '123', 'A02', '综合窗口', NULL, 'Y');

-- ----------------------------
-- Table structure for demo1user
-- ----------------------------
DROP TABLE IF EXISTS `demo1user`;
CREATE TABLE `demo1user`  (
  `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `bh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `xm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sfz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cjsj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ckbh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kssj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `jssj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo1user
-- ----------------------------
INSERT INTO `demo1user` VALUES ('0cae4ee0e5a14611a403591cf1800ac5', 'A008', '牛六', '425154369812387689', '17498622016', '2023-04-25 11:25:45', 'A01', '2023-04-25 11:26:40', '2023-04-25 13:53:48', 1);
INSERT INTO `demo1user` VALUES ('11bfa5513e9c4f06be75623744941197', 'A007', '李四', '425154369812387689', '17498622016', '2023-04-25 11:19:31', 'A01', '2023-04-25 11:20:14', '2023-04-25 11:26:33', 1);
INSERT INTO `demo1user` VALUES ('2f393ae589da47f4b5c276eff0c72aae', 'A009', '张三', '231289199910227689', '15789587451', '2023-04-25 11:26:00', 'A01', '2023-04-25 13:54:00', '', 0);
INSERT INTO `demo1user` VALUES ('38e8877c216e4b3fb46068598f8c3fa5', 'A006', '张三', '231289199910227689', '15789587451', '2023-04-25 11:19:19', 'A01', '2023-04-25 11:19:58', '2023-04-25 11:20:13', 1);
INSERT INTO `demo1user` VALUES ('4a23a8dbb1c34b4c9496863a14fdeda6', 'A004', '王五', '231289199910227689', '18896588888', '2023-04-25 11:02:21', 'A01', '2023-04-25 11:02:34', '2023-04-25 11:19:52', 1);
INSERT INTO `demo1user` VALUES ('72ca8cbbee57491da69bdb8616241ecb', 'A010', '曹建平', '36088845621025478', '07948238815', '2023-04-25 13:53:15', '', '', '', -1);
INSERT INTO `demo1user` VALUES ('7d591f00916d4cca9cd20710d256bfaf', 'A005', '张三', '425154369812387689', '15789587451', '2023-04-25 11:02:51', 'A02', '2023-04-25 11:03:16', '', 0);
INSERT INTO `demo1user` VALUES ('8bed863f120048aba453c7a21b7951fe', 'A003', '牛六', '425154369812387689', '17498622016', '2023-04-25 10:57:55', 'A01', '2023-04-25 10:58:08', '2023-04-25 11:02:33', 1);

SET FOREIGN_KEY_CHECKS = 1;
