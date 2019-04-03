package com.zhazhapan.demo.algorithm.common.annotation;

import com.zhazhapan.demo.algorithm.common.enums.LeetCodeDifficulty;

import java.lang.annotation.*;

/**
 * @author pantao
 * @since 2019/4/3
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LeetCode {

    int problemId();

    String problemTitle();

    LeetCodeDifficulty difficulty();

    String description() default "";

    boolean important() default false;

    boolean resolved() default true;
}
