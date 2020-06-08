package com.smile2coder.shiro.cluster.config;


import com.smile2coder.shiro.cluster.model.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZxT
 * @date 2020-06-05
 * @desc
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 模拟查询该用户的角色和权限 start
        List<String> roleList = new ArrayList<>();
        roleList.add("admin");
        List<String> permissionList = new ArrayList<>();
        permissionList.add("test");
        // 模拟查询该用户的角色和权限 end

        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();

        // 模拟查询该用户的信息 start
        UserInfo userInfo = new UserInfo();
        userInfo.setName("admin");
        userInfo.setPassword("951cd60dec2104024949d2e0b2af45ae");
        userInfo.setSalt("xbNIxrQfn6COSYn1/GdloA==");
        userInfo.setUsername("zxt");
        userInfo.setId(1L);
        // 模拟查询该用户的信息 end

        if (userInfo == null) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getSalt()),
                getName()
        );

        return simpleAuthenticationInfo;
    }
}
