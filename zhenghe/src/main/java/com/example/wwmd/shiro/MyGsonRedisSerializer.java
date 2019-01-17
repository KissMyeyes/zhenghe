package com.example.wwmd.shiro;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.crazycake.shiro.serializer.RedisSerializer;
import org.springframework.cache.support.NullValue;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class MyGsonRedisSerializer implements RedisSerializer<Object> {

    private final ObjectMapper mapper;

    public MyGsonRedisSerializer() {
        this((String) null);
    }

    public MyGsonRedisSerializer(@Nullable String classPropertyTypeName) {

        this(new ObjectMapper());

        // simply setting {@code mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)} does not help here since we need
        // the type hint embedded for deserialization using the default typing feature.
        mapper.registerModule(new SimpleModule().addSerializer(new NullValueSerializer(classPropertyTypeName)));

        if (StringUtils.hasText(classPropertyTypeName)) {
            mapper.enableDefaultTypingAsProperty(DefaultTyping.NON_FINAL, classPropertyTypeName);
        } else {
            mapper.enableDefaultTyping(DefaultTyping.NON_FINAL, As.PROPERTY);
        }
    }

    /**
     * Setting a custom-configured {@link ObjectMapper} is one way to take further control of the JSON serialization
     * process. For example, an extended {@link SerializerFactory} can be configured that provides custom serializers for
     * specific types.
     *
     * @param mapper must not be {@literal null}.
     */
    public MyGsonRedisSerializer(ObjectMapper mapper) {

        Assert.notNull(mapper, "ObjectMapper must not be null!");
        this.mapper = mapper;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#serialize(java.lang.Object)
     */
    @Override
    public byte[] serialize(@Nullable Object source) throws SerializationException {

        if (source == null) {
            return new byte[0];
        }

        try {
            return mapper.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Could not write JSON: " + e.getMessage(), e);
        }
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#deserialize(byte[])
     */
    @Override
    public Object deserialize(@Nullable byte[] source) throws SerializationException {
        return deserialize(source, Object.class);
    }

    /**
     * @param source can be {@literal null}.
     * @param type   must not be {@literal null}.
     * @return {@literal null} for empty source.
     * @throws SerializationException
     */
    @Nullable
    public <T> T deserialize(@Nullable byte[] source, Class<T> type) throws SerializationException {

        Assert.notNull(type,
                "Deserialization type must not be null! Pleaes provide Object.class to make use of Jackson2 default typing.");

        if ((source == null || source.length == 0)) {
            return null;
        }

        try {
            return mapper.readValue(source, type);
        } catch (Exception ex) {
            throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }

    /**
     * {@link StdSerializer} adding class information required by default typing. This allows de-/serialization of
     * {@link NullValue}.
     *
     * @author Christoph Strobl
     * @since 1.8
     */
    private class NullValueSerializer extends StdSerializer<NullValue> {

        private static final long serialVersionUID = 1999052150548658801L;
        private final String classIdentifier;

        /**
         * @param classIdentifier can be {@literal null} and will be defaulted to {@code @class}.
         */
        NullValueSerializer(@Nullable String classIdentifier) {

            super(NullValue.class);
            this.classIdentifier = StringUtils.hasText(classIdentifier) ? classIdentifier : "@class";
        }

        /*
         * (non-Javadoc)
         * @see com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
         */
        @Override
        public void serialize(NullValue value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {

            jgen.writeStartObject();
            jgen.writeStringField(classIdentifier, NullValue.class.getName());
            jgen.writeEndObject();
        }
    }
}
