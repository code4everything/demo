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
public class Permission implements Serializable {

    /**
     * 权限编号
     */
    private String id;

    /**
     * 权限标识
     */
    private String sign;

    /**
     * 备注
     */
    private String comment;
}
