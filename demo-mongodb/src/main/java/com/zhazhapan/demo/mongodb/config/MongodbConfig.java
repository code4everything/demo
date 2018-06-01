package com.zhazhapan.demo.mongodb.config;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class MongodbConfig {

    public static String host = "127.0.0.1";

    public static int port = 27017;

    public static String user = "user";

    public static String database = "db";

    public static String password = "password";

    private MongodbConfig() {}

    public static void config(String host, int port) {
        MongodbConfig.host = host;
        MongodbConfig.port = port;
    }

    public static void config(String user, String database, String password) {
        MongodbConfig.user = user;
        MongodbConfig.database = database;
        MongodbConfig.password = password;
    }

    public static void config(String host, int port, String user, String database, String password) {
        config(host, port);
        config(user, database, password);
    }
}
