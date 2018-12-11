package com.zhazhapan.demo.springboot.shiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色权限对应表
 *
 * @author pantao
 * @since 2018-12-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission implements Serializable {

    /**
     * 编号
     */
    private String id;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 权限编号
     */
    private String permissionId;
}
