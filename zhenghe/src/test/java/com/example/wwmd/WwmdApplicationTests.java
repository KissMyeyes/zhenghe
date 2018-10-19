package com.example.wwmd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 你可以使用@SpringBootTest的webEnvironment属性定义怎么运行测试：
 * 	*
 * MOCK - 加载WebApplicationContext，并提供一个mock servlet环境，使用该注解时内嵌servlet容器将不会启动。如果classpath下不存在servlet APIs，该模式将创建一个常规的non-web ApplicationContext。
 * 	*
 * RANDOM_PORT - 加载EmbeddedWebApplicationContext，并提供一个真实的servlet环境。使用该模式内嵌容器将启动，并监听在一个随机端口。
 * 	*
 * DEFINED_PORT - 加载EmbeddedWebApplicationContext，并提供一个真实的servlet环境。使用该模式内嵌容器将启动，并监听一个定义好的端口（比如application.properties中定义的或默认的8080端口）。
 * 	*
 * NONE - 使用SpringApplication加载一个ApplicationContext，但不提供任何servlet环境（不管是mock还是其他）。
 *
 *
 * 注 不要忘记在测试用例上添加@RunWith(SpringRunner.class)，否则该注解将被忽略。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WwmdApplicationTests {

    @Test
    public void contextLoads() {
    }

}

/**
 * /// @SpringApplicationConfiguration
 * //已过时。
 * //截至1.4赞成SpringBootTest或直接使用 SpringBootContextLoader。
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(
//        classes = ReadingListApplication.class)
//@WebAppConfiguration
//public class ReadingListApplicationTests {
//    @Test
//    public void contextLoads() {
//    }
//}