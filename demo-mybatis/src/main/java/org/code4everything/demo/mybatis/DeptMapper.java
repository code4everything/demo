package org.code4everything.demo.mybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pantao
 * @since 2019/9/30
 */
public interface DeptMapper {

    @Select("select * from test_dept")
    List<Dept> selectList();
}
