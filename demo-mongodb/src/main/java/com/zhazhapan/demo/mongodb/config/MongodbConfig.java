package com.zhazhapan.demo.mongodb.config;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class MongodbConfig {

    public static final String DEFAULT_DATABASE = "db";

    public static String host = "127.0.0.1";

    public static int port = 27017;

    public static String username = "";

    public static String database = DEFAULT_DATABASE;

    public static String password = DEFAULT_DATABASE;

    public static int threadsAllowedToBlockForConnectionMultiplier = 30;

    public static int connectTimeout = 1000 * 60;

    public static int maxWaitTime = connectTimeout;

    public static int connectionsPerHost = 30;

    public static int minConnectionsPerHost = 5;

    public static int maxConnectionIdleTime = connectTimeout * 5;

    public static int maxConnectionLifeTime = maxConnectionIdleTime;

    private MongodbConfig() {}

    public static void config(int threadsAllowedToBlockForConnectionMultiplier, int connectTimeout, int maxWaitTime,
                              int connectionsPerHost, int minConnectionsPerHost, int maxConnectionIdleTime, int
                                      maxConnectionLifeTime) {
        MongodbConfig.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
        MongodbConfig.connectTimeout = connectTimeout;
        MongodbConfig.maxWaitTime = maxWaitTime;
        MongodbConfig.connectionsPerHost = connectionsPerHost;
        MongodbConfig.minConnectionsPerHost = minConnectionsPerHost;
        MongodbConfig.maxConnectionIdleTime = maxConnectionIdleTime;
        MongodbConfig.maxConnectionLifeTime = maxConnectionLifeTime;
    }

    public static void config(String host, int port) {
        MongodbConfig.host = host;
        MongodbConfig.port = port;
    }

    public static void config(String username, String database, String password) {
        MongodbConfig.username = username;
        MongodbConfig.database = database;
        MongodbConfig.password = password;
    }

    public static void config(String host, int port, String username, String database, String password) {
        config(host, port);
        config(username, database, password);
    }

    public static void config(String host, int port, String username, String database, String password, int
            threadsAllowedToBlockForConnectionMultiplier, int connectTimeout, int maxWaitTime,
                              int connectionsPerHost, int minConnectionsPerHost, int maxConnectionIdleTime, int
                                      maxConnectionLifeTime) {
        config(host, port, username, database, password);
        config(threadsAllowedToBlockForConnectionMultiplier, connectTimeout, maxWaitTime, connectionsPerHost,
                minConnectionsPerHost, maxConnectionIdleTime, maxConnectionLifeTime);
    }
}
