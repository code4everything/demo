package com.zhazhapan.demo.springboot.redis.serializer;

import com.zhazhapan.util.Checker;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author pantao
 * @since 2018/7/6
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private static final byte[] EMPTY_ARRAY = new byte[0];

    private Converter<Object, byte[]> serializer = new SerializingConverter();

    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return Checker.isNull(o) ? EMPTY_ARRAY : serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return Checker.isEmpty(bytes) ? null : deserializer.convert(bytes);
    }
}
