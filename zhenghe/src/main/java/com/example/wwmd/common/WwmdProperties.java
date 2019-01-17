package com.example.wwmd.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 总配置类
 * 使用 注解 @Configuration 自动注入
 * 使用 注解 ConfigurationProperties 匹配yml的wwmd 配置节点
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wwmd")
public class WwmdProperties {

    private ShiroProperties shiro = new ShiroProperties();

    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    private String timeFormat = "yyyy-MM-dd HH:mm:ss";

    private boolean openAopLog = true;

}
