-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
                            `role_id` bigint(0) NOT NULL COMMENT '角色ID',
                            `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
                            PRIMARY KEY (`role_id`) USING BTREE,
                            UNIQUE INDEX `idx_role_name`(`role_name`) USING BTREE COMMENT '角色名唯一'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;