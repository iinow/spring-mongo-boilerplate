package com.example.springmongoboilerplate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@RequiredArgsConstructor
@Configuration
public class RedisConfig {

  private final RedisProperties properties;

  @Bean
  public RedisTemplate<String, Object> redisTemplateJson() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory());
    redisTemplate.setKeySerializer(StringRedisSerializer.UTF_8);
    redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer());
    redisTemplate.setHashKeySerializer(StringRedisSerializer.UTF_8);
    redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer());
    redisTemplate.setEnableDefaultSerializer(false);
    return redisTemplate;
  }

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    configuration.setHostName(properties.getHost());
    configuration.setPassword(properties.getPassword());
    configuration.setPort(properties.getPort());
    return new LettuceConnectionFactory(configuration);
  }

  @Bean
  public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
    return new GenericJackson2JsonRedisSerializer();
  }
}
