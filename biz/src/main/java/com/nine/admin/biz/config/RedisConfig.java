package com.nine.admin.biz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 02:26
 */
@Configuration
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setPort(6366);
        return new LettuceConnectionFactory(configuration);
    }
}
