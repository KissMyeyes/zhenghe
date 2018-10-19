package com.example.wwmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MapperScan  因为Mapper文件上面加@Mapper 注解和mapper 插件有点冲突，这里使用扫描的方式
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.wwmd.dao.mapper")
public class Application implements CommandLineRunner{
    private Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //可以家 @Order(value = 2) 注解
        logger.info("服务启动完成!执行加载数据等操作 MyStartupRunner2 order 1");
    }
}
