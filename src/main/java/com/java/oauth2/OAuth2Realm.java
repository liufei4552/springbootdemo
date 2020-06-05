/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.java.oauth2;


import com.java.utils.RedisKeys;
import com.java.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 认证
 *

 */
@Component
@Slf4j
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private RedisUtil redisUtil;

   /* @Resource
    private MgsSysUserMapper mgsSysUserMapper;
    @Resource
    private MgsSysMenuMapper mgsSysMenuMapper;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }*/

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("------------------------------------->12312");
        /*SysUserVo user = (SysUserVo)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();*/

        List<String> permsList;

       /* //系统管理员，拥有最高权限
        if(userId == CodeConstants.SUPER_ADMIN){
            List<SysMenu> menuList = mgsSysMenuMapper.getAllMenuList();
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = mgsSysUserMapper.queryAllPerms(userId);
        }*/

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        /*for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }*/

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        log.info(permsSet.toString());
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        String accessToken = (String) authcToken.getPrincipal();
        /*LoginUserVo loginUserVo = (LoginUserVo)redisUtil.get(RedisKeys.getWebTokenKey(accessToken));
        if(loginUserVo==null){
            throw new LockedAccountException("token失效，请重新登陆");
        }
        //查询用户信息
        SysUserVo SysUserVo = new SysUserVo();
        SysUserVo.setUsername(loginUserVo.getUserName());
        SysUserVo = mgsSysUserMapper.selectUserByUser(SysUserVo);*/

       /* //账号不存在
        if(SysUserVo == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //账号锁定
        if("0".equals(SysUserVo.getStatus())){
            throw new LockedAccountException("账号已失效,请联系管理员");
        }*/

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("SysUserVo", accessToken, getName());
        //this.doGetAuthorizationInfo(info.getPrincipals());
        return info;
    }

}
