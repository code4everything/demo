package com.zhazhapan.demo.springboot.shiro.shiro;

import com.zhazhapan.demo.springboot.shiro.dao.UserDAO;
import com.zhazhapan.demo.springboot.shiro.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @author pantao
 * @since 2018-12-10
 */
@Component
public class UserRealm extends AuthorizingRealm {

    private final UserDAO userDAO;

    @Autowired
    public UserRealm(UserDAO userDAO) {this.userDAO = userDAO;}

    /**
     * 授权，验证权限时调用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(new HashSet<>(userDAO.getUserPermissions(user.getId())));
        return info;
    }

    /**
     * 认证，登录时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = userDAO.getByUsername(((UsernamePasswordToken) token).getUsername());
        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("用户名或密码不正确");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName("SHA-256");
        shaCredentialsMatcher.setHashIterations(16);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
