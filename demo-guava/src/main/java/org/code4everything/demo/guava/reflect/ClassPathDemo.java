package org.code4everything.demo.guava.reflect;

import cn.hutool.core.lang.Console;
import com.google.common.reflect.ClassPath;

import java.io.IOException;

/**
 * @author pantao
 * @since 2019/10/4
 */
@SuppressWarnings("UnstableApiUsage")
public class ClassPathDemo {

    public static void main(String[] args) throws IOException {
        // 使用ClassLoader扫描ClassPath
        ClassPath classpath = ClassPath.from(ClassPathDemo.class.getClassLoader());
        final String basePackage = "org.code4everything.demo.guava";
        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClassesRecursive(basePackage)) {
            Console.log(classInfo);
        }
    }
}
