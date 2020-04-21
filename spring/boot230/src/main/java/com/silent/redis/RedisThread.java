package com.silent.redis;

import com.silent.redis.service.LockRedisService;

public class RedisThread extends Thread {

    private LockRedisService lockRedisService;

    public RedisThread(LockRedisService lockRedisService) {
        this.lockRedisService = lockRedisService;
    }

    @Override
    public void run() {
        lockRedisService.seckill();
    }
}
