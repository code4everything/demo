package com.zhazhapan.demo.redis.util;

import com.zhazhapan.demo.redis.config.JedisConfig;
import com.zhazhapan.util.Checker;
import redis.clients.jedis.Jedis;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class JedisUtils {

    private static Jedis jedis = null;

    public static Jedis createJedis() {
        Jedis jedis = new Jedis(JedisConfig.host, JedisConfig.port);
        if (Checker.isNotEmpty(JedisConfig.password)) {
            jedis.auth(JedisConfig.password);
        }
        return jedis;
    }

    public static Jedis getInstance() {
        if (Checker.isNull(jedis)) {
            synchronized (JedisConfig.class) {
                if (Checker.isNull(jedis)) {
                    jedis = createJedis();
                }
            }
        }
        return jedis;
    }
}
