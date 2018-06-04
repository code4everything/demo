package com.zhazhapan.demo.redis;

import com.zhazhapan.demo.redis.util.JedisPoolUtils;
import com.zhazhapan.modules.constant.ValueConsts;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://redisdoc.com/">see redis command</a>
 *
 * @author pantao
 * @since 2018/6/1
 */
public class JedisApplication {

    private static final Logger LOGGER = Logger.getLogger(JedisApplication.class);

    private Jedis jedis;

    public static void main(String[] args) {
        JedisPoolUtils.initPool();
        JedisApplication application = new JedisApplication();
        application.jedisString();
        application.jedisHash();
        application.jedisList();
        application.jedisCollection();
        System.exit(ValueConsts.ZERO_INT);
    }

    private void jedisCollection() {
        LOGGER.info("==============start to test redis collection=============");
        jedis = JedisPoolUtils.getJedis();
        String key = "collection";
        String[] value = {"windows", "linux", "mackintosh"};
        LOGGER.info("set key[" + key + "] value[" + Arrays.toString(value) + "]");
        jedis.sadd(key, value);
        LOGGER.info("see key[" + key + "] value[" + jedis.smembers(key) + "]");
        jedis.close();
    }

    private void jedisList() {
        LOGGER.info("==============start to test redis list=============");
        jedis = JedisPoolUtils.getJedis();
        String key = "list";
        String[] value = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        LOGGER.info("set key[" + key + "] value[" + Arrays.toString(value) + "]");
        jedis.lpush(key, value);
        LOGGER.info("see key[" + key + "] value: " + jedis.lrange(key, ValueConsts.ZERO_INT, value.length));
        jedis.close();
    }

    private void jedisHash() {
        LOGGER.info("==============start to test redis hash=============");
        jedis = JedisPoolUtils.getJedis();
        String key = "hash";
        Map<String, String> value = new HashMap<String, String>();
        value.put("name", "pantao");
        value.put("gender", "boy");
        LOGGER.info("set key[" + key + "] value[" + value + "]");
        jedis.hmset(key, value);
        LOGGER.info("see key[" + key + "] value: " + jedis.hgetAll(key));
        jedis.close();
    }

    private void jedisString() {
        LOGGER.info("==============start to test redis string==============");
        jedis = JedisPoolUtils.getJedis();
        String key = "redis";
        String value = "hello word";
        LOGGER.info("set key[" + key + "] value[" + value + "]");
        jedis.set(key, value);
        see(key);
        int start = 3;
        int end = 7;
        LOGGER.info("see key[" + key + "] child[" + start + "," + end + "] string: " + jedis.getrange(key, start, end));
        LOGGER.info("reset key[" + key + "] value[" + value + value + "]");
        jedis.getSet(key, value + value);
        jedis.expire(key, ValueConsts.ONE_HUNDRED_INT);
        see(key);
        jedis.close();
    }

    private void see(String key) {
        LOGGER.info("see key[" + key + "] value: " + jedis.get(key));
    }
}
