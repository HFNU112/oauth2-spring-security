-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`  (
                                       `id` bigint(0) NOT NULL COMMENT '主键',
                                       `role_id` bigint(0) NOT NULL COMMENT '角色ID',
                                       `permission_id` bigint(0) NOT NULL COMMENT '资源权限ID',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;