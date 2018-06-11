package com.zhazhapan.demo.mongodb.util;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.zhazhapan.demo.mongodb.config.MongodbConfig;
import com.zhazhapan.modules.constant.ValueConsts;
import com.zhazhapan.util.Checker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class MongodbUtils {

    private static MongoClient mongoClient = null;

    private static Map<String, MongoDatabase> databases = new HashMap<>(4);

    private static synchronized MongoClientOptions getOption() {
        MongoClientOptions.Builder builder = MongoClientOptions.builder();
        builder.threadsAllowedToBlockForConnectionMultiplier(MongodbConfig
                .threadsAllowedToBlockForConnectionMultiplier);
        builder.connectTimeout(MongodbConfig.connectTimeout);
        builder.maxWaitTime(MongodbConfig.maxWaitTime);
        builder.connectionsPerHost(MongodbConfig.connectionsPerHost);
        builder.minConnectionsPerHost(MongodbConfig.minConnectionsPerHost);
        builder.maxConnectionIdleTime(MongodbConfig.maxConnectionIdleTime);
        builder.maxConnectionLifeTime(MongodbConfig.maxConnectionLifeTime);
        return builder.build();
    }

    public static synchronized void initMongodb(String url) {
        if (Checker.isNull(mongoClient)) {
            mongoClient = new MongoClient(new MongoClientURI(url));
        }
    }

    public static synchronized void initMongodb() {
        if (Checker.isNull(mongoClient)) {
            ServerAddress address = new ServerAddress(MongodbConfig.host, MongodbConfig.port);
            MongoCredential credential = null;
            if (!ValueConsts.EMPTY_STRING.equals(MongodbConfig.username) && !MongodbConfig.password.equals
                    (MongodbConfig.database)) {
                credential = MongoCredential.createCredential(MongodbConfig.username, MongodbConfig
                        .database, MongodbConfig.password.toCharArray());
            }
            if (Checker.isNull(credential)) {
                mongoClient = new MongoClient(address, getOption());
            } else {
                mongoClient = new MongoClient(address, credential, getOption());
            }
        }
    }

    public static synchronized MongoDatabase getMongodb() {
        return getMongodb(MongodbConfig.DEFAULT_DATABASE);
    }

    public static synchronized MongoDatabase getMongodb(String dbName) {
        initMongodb();
        MongoDatabase database = databases.get(dbName);
        if (Checker.isNull(database)) {
            database = mongoClient.getDatabase(dbName);
            databases.put(dbName, database);
        }
        return database;
    }
}
