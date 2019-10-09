package org.code4everything.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 认证测试
 *
 * @author pantao
 * @since 2019/10/9
 */
public class SimpleAuthenticatorTest {

    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        accountRealm.addAccount("mark", "123456", "admin", "user");
    }

    @Test
    public void testAuthentication() {
        // 创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(accountRealm);

        // 注册SecurityManager，获取主体Subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        // 主体（Subject）提交认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123456");
        // 登录失败会抛出异常
        subject.login(token);
        System.out.println("is authenticated: " + subject.isAuthenticated());

        // 查看用户是否有某个角色（没有则抛出异常）
        subject.checkRoles("user", "admin");

        // 登出
        subject.logout();
        System.out.println("is authenticated: " + subject.isAuthenticated());
    }
}
