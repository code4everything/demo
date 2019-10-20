package org.code4everything.demo.springboot.jpa.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.code4everything.demo.springboot.jpa.model.UserVO;
import org.code4everything.demo.springboot.jpa.service.UserService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/20
 */
@Service
public class UserServiceImpl implements UserService {

    private final DataSource dataSource;

    public UserServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 自定义动态SQL
     */
    @Override
    public List<UserVO> listUserByJdbc(Long minId, Long maxId, String orderBy) throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        StringBuilder sqlBuilder = new StringBuilder("select name, count(name) count from user");
        String sep = " where";
        if (ObjectUtil.isNotNull(minId)) {
            sqlBuilder.append(sep).append(" id>").append(minId);
            sep = " and";
        }
        if (ObjectUtil.isNotNull(maxId)) {
            sqlBuilder.append(sep).append(" id<").append(maxId);
        }
        sqlBuilder.append(" group by name");
        if (StrUtil.isNotEmpty(orderBy)) {
            sqlBuilder.append(" order by ").append(orderBy);
        }
        String sql = sqlBuilder.toString();
        System.out.println();
        System.out.println(sql);

        List<UserVO> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            UserVO userVO = new UserVO();
            userVO.setName(resultSet.getString("name"));
            userVO.setCount(resultSet.getInt("count"));
            list.add(userVO);
        }
        return list;
    }
}
