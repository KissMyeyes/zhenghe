package com.example.wwmd.shiro;


import com.example.wwmd.enums.UserStatusEnum;
import com.example.wwmd.model.Permission;
import com.example.wwmd.model.Role;
import com.example.wwmd.model.User;
import com.example.wwmd.service.PermService;
import com.example.wwmd.service.RoleService;
import com.example.wwmd.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 这个类是参照JDBCRealm写的，主要是自定义了如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 * <p>
 * 在Shiro中，最终是通过Realm来获取应用程序中的用户、角色及权限信息的
 * 在Realm中会直接从我们的数据源中获取Shiro需要的验证信息。可以说，Realm是专用于安全框架的DAO.
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;

    //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
//    {
//        //设置用于匹配密码的CredentialsMatcher
//        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
//        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
//        hashMatcher.setStoredCredentialsHexEncoded(false);
//        hashMatcher.setHashIterations(1024);
//        this.setCredentialsMatcher(hashMatcher);
//    }

    /**
     * 授权模块，获取用户角色和权限
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     * <p>
     * 授权用户权限
     * 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * 如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     * <p>
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * <p>
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole()); authorizationInfo.addStringPermission(p.getPermission());
     * <p>
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles); authorizationInfo.setStringPermissions(stringPermissions);
     * <p>
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "perms[权限添加]");
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     * <p>
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put("/add", "roles[100002]，perms[权限添加]");
     * 就说明访问/add这个链接必须要有 "权限添加" 这个权限和具有 "100002" 这个角色才可以访问
     *
     * @param principal principal
     * @return AuthorizationInfo 权限信息
     */

//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        //null usernames are invalid
//        if (principals == null) {
//            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
//        }
//
//        User user = (User) getAvailablePrincipal(principals);
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        System.out.println("获取角色信息：" + user.getRoles());
//        System.out.println("获取权限信息：" + user.getPerms());
//        info.setRoles(user.getRoles());
//        info.setStringPermissions(user.getPerms());
//        return info;
//    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //null usernames are invalid
        if (principal == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        User user = (User) getAvailablePrincipal(principal);
//        String userName = user.getUserName();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<Role> roleList = this.roleService.getRolesByUserId(user.getId());
        Set<String> roleSet = roleList.stream().map(Role::getName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<Permission> permissionList = this.permService.findUserPermissions(user.getId());
        Set<String> permissionSet = new HashSet<>();
        for (Permission permission : permissionList) {
            // 处理用户多权限 用逗号分隔
            permissionSet.addAll(Arrays.asList(permission.getPerms().split(",")));
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    //定义如何获取用户信息的业务逻辑，给shiro做登录
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        String username = upToken.getUsername();
//
//        // Null username is invalid
//        if (username == null) {
//            throw new AccountException("Null usernames are not allowed by this realm.");
//        }
//
//        User userDB = userService.findUserByName(username);
//
//
//        if (userDB == null) {
//            throw new UnknownAccountException("No account found for admin [" + username + "]");
//        }
//
//        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
//        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
//        Set<String> roles = roleService.getRolesByUserId(userDB.getUid());
//        Set<String> perms = permService.getPermsByUserId(userDB.getUid());
//        userDB.getRoles().addAll(roles);
//        userDB.getPerms().addAll(perms);
//
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPwd(), getName());
//        if (userDB.getSalt() != null) {
//            info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
//        }
//
//        return info;
//
//    }

    /**
     * 用户认证
     *
     * @param token AuthenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 通过用户名到数据库查询用户信息
        User user = this.userService.findUserByName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (UserStatusEnum.STATUS_LOCK.equals(user.getLocked())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
//        return new SimpleAuthenticationInfo(user, password, getName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
//        if (user.getSalt() != null) {
//            info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
//        }
        return info;
    }

//
//    /**
//     * 重写方法,清除当前用户的的 授权缓存
//     *
//     * @param principals
//     */
//    @Override
//    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthorizationInfo(principals);
//    }
//
//    /**
//     * 重写方法，清除当前用户的 认证缓存
//     *
//     * @param principals
//     */
//    @Override
//    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
//        super.clearCachedAuthenticationInfo(principals);
//    }
//
//    @Override
//    public void clearCache(PrincipalCollection principals) {
//        super.clearCache(principals);
//    }
//
//    /**
//     * 自定义方法：清除所有 授权缓存
//     */
//    public void clearAllCachedAuthorizationInfo() {
//        getAuthorizationCache().clear();
//    }
//
//    /**
//     * 自定义方法：清除所有 认证缓存
//     */
//    public void clearAllCachedAuthenticationInfo() {
//        getAuthenticationCache().clear();
//    }
//
//    /**
//     * 自定义方法：清除所有的  认证缓存  和 授权缓存
//     */
//    public void clearAllCache() {
//        clearAllCachedAuthenticationInfo();
//        clearAllCachedAuthorizationInfo();
//    }

}
