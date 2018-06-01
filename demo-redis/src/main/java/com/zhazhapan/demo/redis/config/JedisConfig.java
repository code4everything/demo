package com.zhazhapan.demo.redis.config;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class JedisConfig {

    public static String host = "127.0.0.1";

    public static int port = 6379;

    public static String password = "";

    public static int maxTotal = 100;

    public static int maxIdle = 30;

    public static int maxWaitMillis = 1000;

    private JedisConfig() {}

    public static void config(String host, int port, String password) {
        config(host, port);
        JedisConfig.password = password;
    }

    public static void config(String host, int port) {
        JedisConfig.host = host;
        JedisConfig.port = port;
    }

    public static void config(int maxTotal, int maxIdle, int maxWaitMillis) {
        JedisConfig.maxIdle = maxIdle;
        JedisConfig.maxTotal = maxTotal;
        JedisConfig.maxWaitMillis = maxWaitMillis;
    }

    public static void config(String host, int port, String password, int maxTotal, int maxIdle, int maxWaitMillis) {
        config(host, port, password);
        config(maxTotal, maxIdle, maxWaitMillis);
    }
}
