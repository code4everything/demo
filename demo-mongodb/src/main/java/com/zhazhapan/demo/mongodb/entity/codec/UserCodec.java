package com.zhazhapan.demo.mongodb.entity.codec;

import com.zhazhapan.demo.mongodb.entity.User;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.Date;

/**
 * @author pantao
 * @since 2018/6/4
 */
public class UserCodec implements Codec<User> {

    private final String NAME = "name";

    private final String GENDER = "gender";

    private final String BIRTH = "birth";

    @Override
    public User decode(BsonReader bsonReader, DecoderContext decoderContext) {
        User user = new User();
        bsonReader.readStartDocument();
        String id = "_id";
        bsonReader.readObjectId(id);
        user.setName(bsonReader.readString(NAME));
        user.setGender(bsonReader.readString(GENDER));
        user.setBirth(new Date(bsonReader.readDateTime(BIRTH)));
        bsonReader.readEndDocument();
        return user;
    }

    @Override
    public void encode(BsonWriter bsonWriter, User user, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeString(NAME, user.getName());
        bsonWriter.writeString(GENDER, user.getGender());
        bsonWriter.writeDateTime(BIRTH, user.getBirth().getTime());
        bsonWriter.writeEndDocument();
    }

    @Override
    public Class<User> getEncoderClass() {
        return User.class;
    }
}
