-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
                                 `id` bigint(0) NOT NULL COMMENT '主键id',
                                 `user_id` bigint(0) NOT NULL COMMENT '用户ID',
                                 `role_id` bigint(0) NOT NULL COMMENT '角色ID',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;