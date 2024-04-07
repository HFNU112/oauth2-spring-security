SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
                            `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
                            `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                            `enabled` tinyint(0) NOT NULL DEFAULT 1 COMMENT '是否禁用1：表示true启用；0：表示false禁用',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `idx_user_username`(`username`) USING BTREE COMMENT '用户名唯一且不能重复'
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (7, 'admin', '{bcrypt}$2a$04$xQJzkYw550OfXxEqIbt75Ogwm.P7IE9KYKGvrkCu05Ujw7zQrzwxK', 1);
INSERT INTO `tb_user` VALUES (8, 'husp', '{bcrypt}$2a$04$xQJzkYw550OfXxEqIbt75Ogwm.P7IE9KYKGvrkCu05Ujw7zQrzwxK', 1);
INSERT INTO `tb_user` VALUES (9, 'tianlongbabu', '{bcrypt}$2a$10$VH5qe2uz3xuuU/iX7w2pCOq4D5vHy2RLvNOma7ZEHkwSjllyYplpy', 1);
INSERT INTO `tb_user` VALUES (10, 'ry', '{bcrypt}$2a$10$6poHBo5TcEPesYQ8tcv5H.uwOJ9Pyr0r6WWTbzfA9tA.7O2U9zIPq', 1);
INSERT INTO `tb_user` VALUES (11, 'ry1', '{bcrypt}$2a$10$5yAWH8spdY6Ql1x7B6/.le5DukjB2VIg8Sq12Lh3iqLCFEPflqk7a', 1);
INSERT INTO `tb_user` VALUES (12, 'ry2', '{bcrypt}$2a$10$LgdTmwkgSmoxXVFaBlJOw.Q/TqQwyomc2hTF4YicQZOGZlpoMUsz6', 1);
INSERT INTO `tb_user` VALUES (13, 'ry3', '{bcrypt}$2a$10$it4UrXZX9KhmnlAMnkhfKOQ5OxzUsCPIQMWN/bPkokmc.zmz1nPCu', 1);
INSERT INTO `tb_user` VALUES (14, 'ry4', '{bcrypt}$2a$10$VExPk3AJsh4g0kNZAWahJu1RJQifnLG4Ew2y/xhXOWjj9PxkTiHwe', 1);
INSERT INTO `tb_user` VALUES (15, 'ry5', '{bcrypt}$2a$10$WT3dZvFcVojWyRhaX95rwOkmpJ3Y.IQtrNNJ2NoZ3aa0bLMzQrK82', 1);

SET FOREIGN_KEY_CHECKS = 1;
