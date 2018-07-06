package com.zhazhapan.demo.springboot.mongodb.repository;

import com.zhazhapan.demo.springboot.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author pantao
 * @since 2018/7/6
 */
public interface UserRepository extends MongoRepository<User, Long> {

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     *
     * @return {@link User}
     */
    User findByUsername(String username);
}
