package org.code4everything.demo.springboot.jpa.service;

import org.code4everything.demo.springboot.jpa.model.UserVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/20
 */
public interface UserService {

    List<UserVO> listUserByJdbc(Long minId, Long maxId, String orderBy) throws SQLException;
}
