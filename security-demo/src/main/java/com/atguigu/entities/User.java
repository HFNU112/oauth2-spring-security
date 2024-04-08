package com.atguigu.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-04-07
 */
@Schema(title = "用户实体", name = "用户实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Schema(title = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @Schema(title = "账号")
    private String username;

    /**
     * 密码
     */
    @Schema(title = "密码")
    private String password;

    /**
     * 是否禁用1：表示true启用；0：表示false禁用
     */
    @Schema(title = "是否禁用, false：禁用表示0；true：启用表示1")
    private Byte enabled;
}
