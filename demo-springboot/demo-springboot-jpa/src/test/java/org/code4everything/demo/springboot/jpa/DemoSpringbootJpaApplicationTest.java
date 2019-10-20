package org.code4everything.demo.springboot.jpa;

import cn.hutool.core.lang.Console;
import org.code4everything.demo.springboot.jpa.entity.User;
import org.code4everything.demo.springboot.jpa.repository.UserRepository;
import org.code4everything.demo.springboot.jpa.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoSpringbootJpaApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testDynamicJpa() throws SQLException {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("CCC", 30));

        Console.log(userService.listUserByJdbc(null, null, null));

        Console.log(userService.listUserByJdbc(2L, null, null));
        Console.log(userService.listUserByJdbc(null, 5L, null));
        Console.log(userService.listUserByJdbc(null, null, "name desc"));

        Console.log(userService.listUserByJdbc(null, 5L, "name desc"));
        Console.log(userService.listUserByJdbc(2L, null, "name desc"));
        Console.log(userService.listUserByJdbc(2L, 5L, null));

        Console.log(userService.listUserByJdbc(2L, 5L, "name desc"));
    }

    @Test
    public void testJpa() {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());
    }
}
