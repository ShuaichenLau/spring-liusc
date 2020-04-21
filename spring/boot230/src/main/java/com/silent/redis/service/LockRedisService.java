package com.silent.redis.service;

import com.silent.global.GlobalString;
import com.silent.redis.LockRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class LockRedisService {

    private Logger logger = LoggerFactory.getLogger(LockRedisService.class);

    private static JedisPoolConfig jedisPoolConfig = null;
    private static JedisPool jedisPool = null;
    private static LockRedis lockRedis = null;

//    @Value("redisLock")
//    private String redisLockKey;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(GlobalString.maxIdle);
        jedisPoolConfig.setMaxTotal(GlobalString.maxConnTotal);
        jedisPoolConfig.setMaxWaitMillis(GlobalString.maxWaitMillis);
        //在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(jedisPoolConfig, GlobalString.redisHost, GlobalString.redisPort, GlobalString.database);
    }

//    LockRedis lockRedis = new LockRedis(JedisPool);

    public void seckill() {
        lockRedis = new LockRedis(jedisPool);
        String identifierValue = lockRedis.getRedisLock(GlobalString.acquireTimeOut, GlobalString.timeOut);
        if (StringUtils.isEmpty(identifierValue)) {
            try {
                logger.info("seckill 获取锁 fail..." + Thread.currentThread().getName());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        logger.info("seckill 获取锁 success..." + Thread.currentThread().getName());

        try {
            logger.info("start 执行业务逻辑 ThreadName ==> " + Thread.currentThread().getName());
            Thread.sleep(3000);
            logger.info("end 执行业务逻辑 ThreadName ==> " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean falg = lockRedis.unRedisLock(identifierValue);
        if (falg) {
            logger.info("释放锁 success " + Thread.currentThread().getName());
        } else {
            logger.info("释放锁 fail " + Thread.currentThread().getName());
        }


    }


}
