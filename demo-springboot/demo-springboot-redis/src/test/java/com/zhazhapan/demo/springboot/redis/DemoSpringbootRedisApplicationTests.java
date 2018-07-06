package com.zhazhapan.demo.springboot.redis;

import com.zhazhapan.demo.springboot.redis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {}

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        User user = new User("redis", 7);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("memchache", 8);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("ehchache", 9);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        assert 7 == redisTemplate.opsForValue().get("redis").getAge();
        assert 8 == redisTemplate.opsForValue().get("memchahe").getAge();
        assert 9 == redisTemplate.opsForValue().get("ehchache").getAge();
    }
}
