package com.zhazhapan.demo.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pantao
 * @since 2019/2/14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 分数
     */
    private Integer score;
}
