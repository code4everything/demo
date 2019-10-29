package org.code4everything.demo.jvm;

import cn.hutool.core.util.RandomUtil;
import org.code4everything.demo.jvm.outom.OutOfMemoryEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/29
 */
public class OutOfMemory {

    /**
     * 测试内存溢出，并用JavaVisualVM分析dump文件，启动参数：-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        // 做一些其他无关紧要的工作
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(RandomUtil.randomLong());
        }
        // 内存溢出代码块
        while (true) {
            OutOfMemoryEnum.SINGLETON.addEle(RandomUtil.randomString(16));
        }
    }
}
