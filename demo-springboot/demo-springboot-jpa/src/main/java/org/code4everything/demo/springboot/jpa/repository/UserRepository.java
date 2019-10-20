package org.code4everything.demo.springboot.jpa.repository;

import org.code4everything.demo.springboot.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author pantao
 * @since 2018/7/6
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过名字查找用户
     *
     * @param name 名字
     *
     * @return {@link User}
     */
    User findByName(String name);

    /**
     * 通过名字和年龄查找名字
     *
     * @param name 名字
     * @param age 年龄
     *
     * @return {@link User}
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * 自定义查询
     *
     * @param name 名字
     *
     * @return {@link User}
     */
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
