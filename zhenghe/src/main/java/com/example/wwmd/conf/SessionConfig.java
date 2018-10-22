package com.example.wwmd.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Redis集中式Session管理
 * Spring Session提供了3种方式存储session的方式。分别对应3各种注
 *
 * @EnableRedisHttpSession-存放在缓存redis
 * @EnableMongoHttpSession-存放在Nosql的MongoDB
 * @EnableJdbcHttpSession-存放数据库 spring-session-data-redis
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

    /**
     * 设置共享session 的redis实现的序列化工具
     * <p>
     * {@link org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration)
     *
     * @return
     */
    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer springSessionDefaultRedisSerializer() {
        RedisSerializer defaultSerializer = new GenericJackson2JsonRedisSerializer();
        return defaultSerializer;
    }
}