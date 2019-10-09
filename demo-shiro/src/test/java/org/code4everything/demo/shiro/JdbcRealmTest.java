package org.code4everything.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author pantao
 * @since 2019/10/9
 */
public class JdbcRealmTest {

    @Test
    @Ignore
    public void testJdbcRealm() {
        // 创建Realm
        JdbcRealm jdbcRealm = new JdbcRealm();
        // 我们需要设置DataSource，还可以设置自定义查询SQL，这里不做演示
        jdbcRealm.setDataSource(null);
        jdbcRealm.setPermissionsLookupEnabled(true);

        // 创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);

        // 注册SecurityManager，获取主体Subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        // 主体（Subject）提交认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("mark", "123456");
        // 登录失败会抛出异常
        subject.login(token);
        System.out.println("is authenticated: " + subject.isAuthenticated());

        // 登出
        subject.logout();
        System.out.println("is authenticated: " + subject.isAuthenticated());
    }
}
