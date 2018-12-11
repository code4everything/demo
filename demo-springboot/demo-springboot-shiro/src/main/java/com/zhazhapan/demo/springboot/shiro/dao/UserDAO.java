package com.zhazhapan.demo.springboot.shiro.dao;

import cn.hutool.core.util.IdUtil;
import com.zhazhapan.demo.springboot.shiro.domain.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2018-12-11
 */
@Repository
public class UserDAO {

    private static final String SALT = "salt";

    private static final String PASSWORD = new SimpleHash("SHA-256", "123456", SALT, 16).toString();

    private static final Map<String, User> USER_MAP = new HashMap<>(4);

    private static final List<UserRole> USER_ROLE_LIST = new ArrayList<>(4);

    private static final Map<String, Role> ROLE_MAP = new HashMap<>(4);

    private static final Map<String, Permission> PERMISSION_MAP = new HashMap(4);

    private static final List<RolePermission> ROLE_PERMISSION_LIST = new ArrayList<>(4);

    /**
     * 这里初始化数据，为了简化，没有跟数据库关联
     */
    static {
        // 添加权限
        String pid1 = IdUtil.simpleUUID();
        PERMISSION_MAP.put(pid1, new Permission(pid1, "res:get", ""));
        String pid2 = IdUtil.simpleUUID();
        PERMISSION_MAP.put(pid2, new Permission(pid2, "res:delete", ""));
        // 添加角色
        String rid1 = IdUtil.simpleUUID();
        ROLE_MAP.put(rid1, new Role(rid1, "admin", ""));
        String rid2 = IdUtil.simpleUUID();
        ROLE_MAP.put(rid2, new Role(rid2, "user", ""));
        // 添加角色对应的权限
        ROLE_PERMISSION_LIST.add(new RolePermission(IdUtil.simpleUUID(), rid1, pid1));
        ROLE_PERMISSION_LIST.add(new RolePermission(IdUtil.simpleUUID(), rid1, pid2));
        ROLE_PERMISSION_LIST.add(new RolePermission(IdUtil.simpleUUID(), rid2, pid1));
        // 添加用户
        String uid1 = IdUtil.simpleUUID();
        USER_MAP.put("admin", new User(uid1, "admin", PASSWORD, SALT));
        String uid2 = IdUtil.simpleUUID();
        USER_MAP.put("test_user", new User(uid2, "test_user", PASSWORD, SALT));
        // 添加用户对应的角色
        USER_ROLE_LIST.add(new UserRole(IdUtil.simpleUUID(), rid1, uid1));
        USER_ROLE_LIST.add(new UserRole(IdUtil.simpleUUID(), rid2, uid2));
    }

    /**
     * 通过用户名查找用户
     */
    public User getByUsername(String username) {
        return USER_MAP.get(username);
    }

    /**
     * 查找用户权限
     */
    public List<String> getUserPermissions(String userId) {
        List<String> perms = new ArrayList<>();
        USER_ROLE_LIST.forEach(userRole -> {
            if (userRole.getUserId().equals(userId)) {
                ROLE_PERMISSION_LIST.forEach(rolePermission -> {
                    if (rolePermission.getRoleId().equals(userRole.getRoleId())) {
                        perms.add(PERMISSION_MAP.get(rolePermission.getPermissionId()).getSign());
                    }
                });
            }
        });
        return perms;
    }
}
