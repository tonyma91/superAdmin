package com.laoma.admin.utils;
 /**
  * @description
  * @author majinming@xiaomi.com
  * @date 2021年 03月19日 19:39
  */
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;



@EnableConfigurationProperties(CacheProperties.class)
@Configuration
@EnableCaching//开启缓存功能，放在这（也可以主类）
public class RedisConfig {
 @Bean
 public RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties){
  RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
          .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
          .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  //将配置文件中的文件拿来，生效
  CacheProperties.Redis redisProperties = cacheProperties.getRedis();
  if (redisProperties.getTimeToLive() != null) {
   config = config.entryTtl(redisProperties.getTimeToLive());
  }

  if (redisProperties.getKeyPrefix() != null) {
   config = config.prefixCacheNameWith(redisProperties.getKeyPrefix());
  }

  if (!redisProperties.isCacheNullValues()) {
   config = config.disableCachingNullValues();
  }

  if (!redisProperties.isUseKeyPrefix()) {
   config = config.disableKeyPrefix();
  }
  return config;

 }

}

