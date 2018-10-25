package com.young.FirstSpaceTest.conf;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Configuration
public class GlobleConfig {

    @Bean(name = "redissonClient")
    public RedissonClient getRedissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://122.112.252.131:6379");
        return Redisson.create(config);
    }
}
