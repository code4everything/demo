package com.zhazhapan.demo.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.zhazhapan.demo.mongodb.config.MongodbConfig;
import com.zhazhapan.demo.mongodb.entity.User;
import com.zhazhapan.demo.mongodb.entity.codec.UserCodec;
import com.zhazhapan.demo.mongodb.util.MongodbUtils;
import com.zhazhapan.modules.constant.ValueConsts;
import com.zhazhapan.util.Formatter;
import com.zhazhapan.util.RandomUtils;
import org.apache.log4j.Logger;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.Date;

/**
 * @author pantao
 * @since 2018/6/4
 */
public class MongodbApplication {

    private static final Logger LOGGER = Logger.getLogger(MongodbConfig.class);

    public static void main(String[] args) {
        MongoDatabase database = MongodbUtils.getMongodb();
        LOGGER.info("database name: " + database.getName());
        final String user = "user";
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UserCodec()),
                MongoClient.getDefaultCodecRegistry());
        MongoCollection<User> users = database.getCollection(user, User.class).withCodecRegistry(codecRegistry);
        users.insertOne(new User("hei", "b", new Date()));
        LOGGER.info("birth: " + Formatter.datetimeToString(users.find().first().getBirth()));
        database.createCollection(RandomUtils.getRandomStringOnlyLowerCase(ValueConsts.THREE_INT));
        for (String name : database.listCollectionNames()) {
            LOGGER.info("collection name: " + name);
        }
    }
}
