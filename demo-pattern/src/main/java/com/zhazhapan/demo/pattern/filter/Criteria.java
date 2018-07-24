package com.zhazhapan.demo.pattern.filter;

import java.util.List;

/**
 * @author pantao
 * @since 2018-07-24
 */
public interface Criteria {

    /**
     * 过滤
     */
    List<Person> meetCriteria(List<Person> personList);
}
