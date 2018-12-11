package com.zhazhapan.demo.springboot.shiro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色表
 *
 * @author pantao
 * @since 2018-12-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    /**
     * 角色编号
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String comment;
}
