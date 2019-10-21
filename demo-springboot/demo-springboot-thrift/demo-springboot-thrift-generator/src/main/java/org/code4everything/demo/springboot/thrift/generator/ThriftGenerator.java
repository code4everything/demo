package org.code4everything.demo.springboot.thrift.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author pantao
 * @since 2019/10/16
 */
public class ThriftGenerator {

    public static void main(String[] args) {
        // 获取当前工作目录
        String workDir = Paths.get(".").toAbsolutePath().normalize().toString();

        // thrift资源目录
        String generatorModuleName = "demo-springboot-thrift-generator";
        File thriftFolder = FileUtil.file(workDir, generatorModuleName, "src", "main", "resources");

        // 编译输出目录
        String commonModuleName = "demo-springboot-thrift-common";
        String output = FileUtil.file(workDir, commonModuleName, "src", "main", "java").getAbsolutePath();

        // 所有资源文件
        File[] thriftFiles = FileUtil.ls(thriftFolder.getAbsolutePath());

        // 编译thrift文件
        String cmd = "thrift -gen java -out {} {}";
        for (File thriftFile : thriftFiles) {
            RuntimeUtil.execForStr(StrUtil.format(cmd, output, thriftFile.getAbsoluteFile()));
        }
    }
}
