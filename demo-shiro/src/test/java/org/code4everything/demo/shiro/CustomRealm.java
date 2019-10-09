package org.code4everything.demo.shiro;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Sets;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * 自定义Realm
 *
 * @author pantao
 * @since 2019/10/9
 */
public class CustomRealm extends AuthorizingRealm {

    {
        super.setName("customRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 从主体传过来的认证信息中获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库或缓存中获取角色和权限信息
        Set<String> roles = listRolesByUsername(username);
        Set<String> permissions = listPermissionsByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    private Set<String> listPermissionsByUsername(String username) {
        // 开发中应该到数据库中去取，这里为了简单，就不做了
        return Sets.newHashSet("user:add", "user:delete");
    }

    private Set<String> listRolesByUsername(String username) {
        // 开发中应该到数据库中去取，这里为了简单，就不做了
        return Sets.newHashSet("admin", "user");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从主体传过来的认证信息中获取用户名
        String username = (String) authenticationToken.getPrincipal();
        // 通过用户名到数据库中读取凭证
        String password = getPasswordByUsername(username);
        if (StrUtil.isEmpty(password)) {
            return null;
        }
        // 盐值一般是程序为用户分配随机固定长度的字符串
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("salt"), "customRealm");
    }

    private String getPasswordByUsername(String username) {
        // 开发中应该到数据库中去取，这里为了简单，就不做了（盐值一般为随机字符串）
        return new SimpleHash("MD5", "123456", "salt", 3).toString();
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        // 加密工具类
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(3);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }
}
