package com.example.wwmd.common;

import com.example.wwmd.conf.ShiroConfig;
import lombok.Data;

/**
 * shiro init用到的配置项
 *
 * @see ShiroConfig#shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager)
 * Shiro 特有的拦截机制。
 */

@Data
public class ShiroProperties {

    // shiro redis缓存时长，默认值 1800 秒
    private int expireIn = 1800;
    // session 超时时间，默认 1800000毫秒
    private long sessionTimeout = 1800000L;
    // rememberMe 有效时长，默认为 86400 秒，即一天
    private int cookieTimeout = 86400;

    private String anonUrl;   //设置免认证 url

    private String loginUrl = "/login";

    private String successUrl = "/index";

    private String logoutUrl = "/logout";

    private String unauthorizedUrl;
}