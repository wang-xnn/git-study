package com.wangxnn.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //realm对象 第一步创建Realm
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //DefaultWebSecurityManager  第二步 由创建的realm导入webSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //ShiroFilterFactoryBean 第三步
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器
        /**
         anon：无需认证就可以访问
         authc:必须认证了才可以访问
         user:必须拥有记住我功能才能访问
         perms:拥有对某个资源的权限才能访问
         role:拥有某个角色才能访问
         */
        Map<String,String> filterMap=new LinkedHashMap<>();
//        filterMap.put("/user/add.html","authc");
//        filterMap.put("/user/update.html","authc");
        filterMap.put("/user/add.html","perms[user:add]");
        filterMap.put("/user/update.html","perms[user:update]");
        filterMap.put("/user/*","authc");

        factoryBean.setFilterChainDefinitionMap(filterMap);
        factoryBean.setLoginUrl("/toLogin");
        factoryBean.setUnauthorizedUrl("/authorize");
        return factoryBean;
    }

    //整合shiroDialect:用来整合shiro 和 thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
