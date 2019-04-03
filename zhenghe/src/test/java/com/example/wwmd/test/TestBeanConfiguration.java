package com.example.wwmd.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author wang3
 * @Title: TestBeanConfiguration
 * @Description:
 * @date 2019/4/315:00
 */
@TestConfiguration
public class TestBeanConfiguration {

    @Bean
    public Runnable createRunnable() {
        return () -> System.out.println("=====createRunnable=======");
    }
}