package org.code4everything.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author pantao
 * @since 2019/10/9
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {
        // 创建Realm
        CustomRealm customRealm = new CustomRealm();

        // 创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        // 注册SecurityManager，获取主体Subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        // 主体（Subject）提交认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123456");
        // 登录失败会抛出异常
        subject.login(token);
        System.out.println("is authenticated: " + subject.isAuthenticated());

        // 查看用户是否有某个角色（没有则抛出异常）
        subject.checkRoles("admin");
        // 查看用户是否有某个权限（没有则抛出异常）
        subject.checkPermission("user:delete");

        // 登出
        subject.logout();
        System.out.println("is authenticated: " + subject.isAuthenticated());
    }
}
