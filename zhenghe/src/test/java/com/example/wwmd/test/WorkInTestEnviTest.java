package com.example.wwmd.test;

import com.example.wwmd.test.entity.Cat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 分别使用@TestComponent和@TestConfiguration二个注解修饰，这些类只在测试环境生效
 *
 * @author wang3
 * @Title: WorkInTestEnviTest
 * @Description:
 * @date 2019/4/315:02
 * @see org.springframework.boot.test.context.TestComponent
 * @see org.springframework.boot.test.context.TestConfiguration
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestBeanConfiguration.class, Cat.class})
public class WorkInTestEnviTest {

    @Autowired
    public ApplicationContext context;

    @Test
    public void testNotNull() {
        Runnable runnable = context.getBean(Runnable.class);
        runnable.run();
        System.out.println("--------");

        Cat cat = context.getBean(Cat.class);
        cat.index();
    }
}