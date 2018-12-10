package com.zhazhapan.demo.springboot.shiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pantao
 * @since 2018-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

    /**
     * 编号
     */
    private String id;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 用户编号
     */
    private String userId;
}
