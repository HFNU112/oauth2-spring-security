package com.atguigu;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/7 14:44
 */
@Slf4j
@MapperScan("com.atguigu.mapper")
@SpringBootApplication
public class SecurityDemoApplication8001 {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SecurityDemoApplication8001.class, args);

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + "/\n\t" +
                "Swagger3文档: \thttp://" + ip + ":" + port + "/demo/doc.html\n" +
                "----------------------------------------------------------");
    }
}