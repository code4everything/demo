package com.zhazhapan.demo.mongodb.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.zhazhapan.demo.mongodb.config.MongodbConfig;
import com.zhazhapan.util.Checker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2018/6/1
 */
public class MongodbUtils {

    private static MongoClient mongoClient = null;

    private static Map<String, MongoDatabase> databases = new HashMap<String, MongoDatabase>(4);

    public static synchronized void initMongodb(String url) {
        if (Checker.isNull(mongoClient)) {
            mongoClient = new MongoClient(new MongoClientURI(url));
        }
    }

    public static synchronized void initMongodb() {
        if (Checker.isNull(mongoClient)) {
            mongoClient = new MongoClient(MongodbConfig.host, MongodbConfig.port);
        }
    }

    public static synchronized MongoDatabase getMongodb(String dbName) {
        initMongodb();
        MongoDatabase database = databases.get(dbName);
        if (Checker.isNull(database)) {
            database = mongoClient.getDatabase(dbName);
        }
        return database;
    }
}
