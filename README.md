# zhenghe
spring boot

集成Mybatis

    使用Mybatis 作为DB工具，因为xml 手动写太麻烦，所以做了下面的集成
集成开源组件 Mapper 和 PageHelper

    可以使用 generatorConfig.xml 映射 DB 一键生成项目文件
    提供了自动生成的 add save selectById 等基础方法。
    提供了基础的分页查询功能
    支持xml + 注解 + 自动生成方法混用。

集成Redis

    同时使用 Redis 注解实现自动缓存，以及 Redis集中式Session管理。
    使用Redis作为Session 的基于全局的统一管理工。
    
集成Swagger2 

    Swagger 提供了自动生成的面向 Controller的 Api 文档。
    在编写接口是，使用 @ApiImplicitParams 编辑接口描述和 参数 描述，就可以生成Api 页面。
    提供了MOCK 功能
    功能没有YAPI这种强，但是胜在维护简单，API 可以和master 代码保持一致
    
集成Shiro
    
    Shiro作为权限管理系统。
    权限系统关系为传统的 ：用户-角色-资源  模型。
    同时使用shiro-redis开源组件，，Shiro 登录 session 集群共享。
    
    
