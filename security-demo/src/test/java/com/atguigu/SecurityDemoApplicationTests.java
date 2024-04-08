package com.atguigu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * @Author Husp
 * @Date 2024/4/7 21:47
 */
@Slf4j
@SpringBootTest
public class SecurityDemoApplicationTests {

    @Test
    @Order(value = 1)
    @DisplayName(value = "测试生成表结构")
    public void testGeneratorTableUser(){
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/simpledemo?charactEncoding=UTF-8&serverTimezone=UTC", "root", "root")
                //1.全局配置
                .globalConfig(builder -> {
                    builder.author("shunpeng.hu")
//                            .enableSwagger()
                            .fileOverride()  // 是否覆盖
                            .outputDir("E:\\spring_security\\oauth2-spring-security\\security-demo\\src\\main\\java") // 设置生成路径
                            .dateType(DateType.ONLY_DATE);
                })
                //2.包的配置
                .packageConfig(builder -> {
                    builder.moduleName("generator")
                            .parent("com.atguigu")  // 设置父目录
                            .entity("entities")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("impl")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\spring_security\\oauth2-spring-security\\security-demo\\src\\main\\resources\\mapper")); // 设置映射文件目录路径
                })
                //3.策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("tb_user") // 设置要映射的表
                            .addTablePrefix("tb_")  // 设置过滤表前缀
                            .entityBuilder().enableLombok() // 自动lombok
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .logicDeletePropertyName("deleted");  // 逻辑删除
                })
                //4.Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    @Test
    @Order(value = 2)
    @DisplayName(value = "测试密码加密效果")
    public void testPassword(){
        // 密码加密工作因子值越大，解密速度越慢 默认值：10 最小值：4 最大值：31
        PasswordEncoder encoder = new BCryptPasswordEncoder(4);

        //明文加密
        String result = encoder.encode( "password");
        log.info("密文：{}", result);
        Assertions.assertTrue(encoder.matches("password", result), "两次密码不一致");
    }
}
