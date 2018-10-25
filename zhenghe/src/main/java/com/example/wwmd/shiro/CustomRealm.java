package com.example.wwmd.shiro;


import com.example.wwmd.enums.UserStatusEnum;
import com.example.wwmd.model.Role;
import com.example.wwmd.model.User;
import com.example.wwmd.service.PermService;
import com.example.wwmd.service.RoleService;
import com.example.wwmd.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 这个类是参照JDBCRealm写的，主要是自定义了如何查询用户信息，如何查询用户的角色和权限，如何校验密码等逻辑
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermService permService;

    //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashMatcher.setStoredCredentialsHexEncoded(false);
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
    }

    /**
     * 授权模块，获取用户角色和权限
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
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
        List<Menu> permissionList = this.menuService.findUserPermissions(userName);
        Set<String> permissionSet = new HashSet<>();
        for (Menu m : permissionList) {
            // 处理用户多权限 用逗号分隔
            permissionSet.addAll(Arrays.asList(m.getPerms().split(",")));
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    //定义如何获取用户信息的业务逻辑，给shiro做登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        User userDB = userService.findUserByName(username);


        if (userDB == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }

        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
        Set<String> roles = roleService.getRolesByUserId(userDB.getUid());
        Set<String> perms = permService.getPermsByUserId(userDB.getUid());
        userDB.getRoles().addAll(roles);
        userDB.getPerms().addAll(perms);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPwd(), getName());
        if (userDB.getSalt() != null) {
            info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
        }

        return info;

    }


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
        return new SimpleAuthenticationInfo(user, password, getName());
    }

}
