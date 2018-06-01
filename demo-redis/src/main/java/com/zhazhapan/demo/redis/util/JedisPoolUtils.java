package com.zhazhapan.demo.redis.util;

import com.zhazhapan.demo.redis.config.JedisConfig;
import com.zhazhapan.util.Checker;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool = null;

    public static synchronized void initPool(String host, int port, String password, int maxTotal, int maxIdle, int
            maxWaitMillis) {
        JedisConfig.config(host, port, password, maxTotal, maxIdle, maxWaitMillis);
        initPool();
    }

    public static synchronized void initPool() {
        if (Checker.isNull(jedisPool)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(JedisConfig.maxIdle);
            config.setMaxTotal(JedisConfig.maxTotal);
            config.setMaxWaitMillis(JedisConfig.maxWaitMillis);
            jedisPool = new JedisPool(config, JedisConfig.host, JedisConfig.port);
        }
    }

    public static synchronized Jedis getJedis() {
        initPool();
        Jedis jedis = jedisPool.getResource();
        if (Checker.isNotEmpty(JedisConfig.password)) {
            jedis.auth(JedisConfig.password);
        }
        return jedis;
    }
}
