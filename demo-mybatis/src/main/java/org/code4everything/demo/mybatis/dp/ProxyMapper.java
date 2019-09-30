package org.code4everything.demo.mybatis.dp;

import org.apache.ibatis.annotations.Select;

/**
 * @author pantao
 * @since 2019/9/30
 */
public interface ProxyMapper {

    @Select("select * from proxy")
    void selectProxy();
}
