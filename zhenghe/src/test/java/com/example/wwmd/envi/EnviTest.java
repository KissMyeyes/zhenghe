package com.example.wwmd.envi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wang3
 * @Title: EnviTest
 * @Description:
 * @date 2019/4/315:09
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.version=1.0"})
public class EnviTest {

    @Autowired
    public Environment environment;

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Test
    public void testValue() {
        Assert.assertEquals("10000", environment.getProperty("spring.redis.timeout"));
        System.out.println(environment.getProperty("spring.redis.timeout"));
    }

    /**
     * TestPropertyValues EnvironmentTestUtils 已废弃 https://github.com/spring-projects/spring-boot/issues/14475
     */
    @Before
    public void init() {
//        EnvironmentTestUtils.addEnvironment(configurableEnvironment,"app.admin.user=zhangsan");
        TestPropertyValues.of("app.admin.user:wangwei").applyTo(this.configurableEnvironment);

    }

    @Test
    public void testApplication() {
        Assert.assertEquals("1.0", configurableEnvironment.getProperty("app.version"));
        Assert.assertEquals("wangwei", configurableEnvironment.getProperty("app.admin.user"));
    }

}