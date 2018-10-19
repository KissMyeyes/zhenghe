package com.example.wwmd.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * JedisConnectionFactory的设置连接方法过时(Deprecated)
 * 我们只需在application.properties文件中，添加spring.redis.jedis.pool即可享受redis的好处
 * <p>
 * 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
 * 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
 * <p>
 * 注解 @EnableCaching spring framework中的注解驱动的缓存管理功能。自spring版本3.1起加入了该注解。如果你使用了这个注解，
 * 那么你就不需要在XML文件中配置cache manager了。
 * 当你在配置类(@Configuration)上使用@EnableCaching注解时，会触发一个post processor，
 * 这会扫描每一个spring bean，查看是否已经存在注解对应的缓存。如果找到了，就会自动创建一个代理拦截方法调用，使用缓存的bean执行处理。
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * RedisTemplate配置
     * 实际使用中，我们大多不会直接使用RedisTemplate<Object,Object>，而是会对key,value进行序列化，所以我们还需要新增一个配置类
     * <p>
     * *{@link org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration } 启用自动化配置后
     * RedisAutoConfiguration 会自动使用使用StringRedisSerializer 初始化所有序列化器。
     * 所以代码里面直接
     * 注入  @Autowired
     * private StringRedisTemplate stringRedisTemplate;
     * 既可以快速使用Redis 功能
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);//使用StringRedisSerializer 作为defaultSerializer
//        RedisTemplate<String, String> template = new RedisTemplate<>();//跟JdbcTemplate一样封装了对Redis的一些常用的操作
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型会出现异常信息;
        /**
         *JacksonJsonRedisSerializer和GenericJackson2JsonRedisSerializer，两者都能系列化成json，
         *但是后者会在json中加入@class属性，类的全路径包名，方便反系列化。
         *前者如果存放了List则在反系列化的时候如果没指定TypeReference则会报错java.util.LinkedHashMap cannot be cast to 。
         */
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(factory);
        //key序列化方式
//        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());//默认序列化，init所有
//        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(redisSerializer);
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());//value hashmap序列化
        return template;
    }

    /**
     * 然而在springboot2.x中，RedisCacheManager已经没有了单参数的构造方法
     * 以下是springboot2.x版本
     * Spring Cache集成redis的运行原理：
     * <p>
     * Spring缓存抽象模块通过CacheManager来创建、管理实际缓存组件，
     * 当SpringBoot应用程序引入spring-boot-starter-data-redi依赖后吗， 容器中将注册的是CacheManager实例RedisCacheManager对象，
     * RedisCacheManager来负责创建RedisCache作为缓存管理组件，由RedisCache操作redis服务器实现缓存数据操作。
     * 实际测试发现默认注入的RedisCacheManager操作缓存用的是RedisTemplate<Object, Object>，因此我们需要自定义cacheManager，替换掉默认的序列化器。
     * <p>
     * 所以上面redisTemplate 的配置在spring Cache 的 @Cacheable 注解中是不会生效的。
     * redisTemplate 应用场景更倾向于手动操作Redis时的的一个引用。
     *
     * @param factory
     * @return
     */
    @Primary
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();  // 生成一个默认配置，通过config对象即可对缓存进行自定义配置
//        config = config.entryTtl(Duration.ofMinutes(1))     // 设置缓存的默认过期时间，也是使用Duration设置
//                .disableCachingNullValues();     // 不缓存空值
////        config = config.entryTtl(Duration.ofMinutes(60*60*24*4));
//
//        // 设置一个初始化的缓存空间set集合   与初始化Redis 缓存空间
//        Set<String> cacheNames =  new HashSet<>();
//        cacheNames.add("my-redis-cache1");
//        cacheNames.add("my-redis-cache2");
//
//        // 对每个缓存空间应用不同的配置
//        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
//        configMap.put("my-redis-cache1", config);
//        configMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));
//
//        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)     // 使用自定义的缓存配置初始化一个cacheManager
//                .initialCacheNames(cacheNames)  // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，
//                .withInitialCacheConfigurations(configMap)//再初始化相关的配置
//                .build();
//        return cacheManager;

        //缓存配置对象
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofMinutes(1L)) //设置缓存的默认超时时间：30分钟
                .disableCachingNullValues()             //如果是空值，不缓存
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))         //设置key序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer((new GenericJackson2JsonRedisSerializer())));  //设置value序列化器

        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(factory)) //对获取锁不加限制，50 Millis
                .cacheDefaults(redisCacheConfiguration).build();
    }
    //    @Primary
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        // 设置缓存有效期一小时
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1));
//        // 开启使用缓存名称最为key前缀
//        return RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(redisCacheConfiguration).build();
//    }

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//       /* //设置缓存过期时间
//        // rcm.setDefaultExpiration(60);//秒
//        //设置value的过期时间
//        Map<String,Long> map=new HashMap();
//        map.put("test",60L);
//        rcm.setExpires(map);*/
//        return rcm;
//    }
//
    /**
     * 如果设置 setCaches
     */
//    @Bean
//    public CacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("sampleCache")));//注册名为sampleCache的缓存
//        return cacheManager;
//    }

    /**
     * Spring boot 1.x 的设置方式
     * @param redisTemplate
     * @return
     */
//    @Bean
//    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(3000);
//        return cacheManager;
//    }

}