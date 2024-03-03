package com.djachtoma.redis;

import com.djachtoma.model.prescription.Prescription;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.Collections;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfiguration extends KeyspaceConfiguration {

    private final RedisProperties properties;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(properties.getPort());
        connectionFactory.setHostName(properties.getHost());
        connectionFactory.setTimeout(properties.getTimeout());
        connectionFactory.setPassword(properties.getPassword());
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Override
    protected Iterable<KeyspaceSettings> initialConfiguration() {
        return Collections.singleton(new KeyspaceSettings(Prescription.class, Prescription.class.getCanonicalName()));
    }
}
