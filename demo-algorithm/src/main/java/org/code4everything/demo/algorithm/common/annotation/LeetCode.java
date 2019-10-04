package org.code4everything.demo.algorithm.common.annotation;

import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.lang.annotation.*;

/**
 * @author pantao
 * @since 2019/4/3
 **/
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LeetCode {

    int id();

    String title();

    Difficulty difficulty();

    String description() default "";

    boolean important() default false;

    /**
     * 自己是否解决了该问题，在没有看答案的情况下
     */
    boolean selfResolved() default true;

    /**
     * 答案参考
     */
    String refer() default "";
}
