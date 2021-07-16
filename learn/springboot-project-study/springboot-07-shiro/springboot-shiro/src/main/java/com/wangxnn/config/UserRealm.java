package com.wangxnn.config;

import com.wangxnn.pojo.User;
import com.wangxnn.service.UserService;
import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义UserRealm    extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权了"+"doGetAuthorizationInfo");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //得到authentication传过来的user
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        //从数据库查询当前user的访问权限
        info.addStringPermission(currentUser.getPerms());
        //返回info,其中包含了user的权限
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证了"+"doGetAuthenticationInfo");
        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        User user = userService.queryUserByName(userToken.getUsername());
        //验证用户
        if(user==null){
            return null;
        }
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("isLogin",user);
        //验证密码,并传递principal给authorization
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
