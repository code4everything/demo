package org.code4everything.demo.jvm.outom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/29
 */
public enum OutOfMemoryEnum {

    /**
     * 单例
     */
    SINGLETON;

    private List<String> list = new ArrayList<>();

    public void addEle(String ele) {
        list.add(ele);
    }
}
