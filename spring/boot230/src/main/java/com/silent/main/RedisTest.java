package com.silent.main;

import com.silent.redis.RedisThread;
import com.silent.redis.service.LockRedisService;

public class RedisTest {

    public static void main(String[] args) {

        LockRedisService lockRedisService = new LockRedisService();

        for (int i = 0; i < 100; i++) {
            RedisThread redisThread = new RedisThread(lockRedisService);
            redisThread.start();
        }

    }
}
