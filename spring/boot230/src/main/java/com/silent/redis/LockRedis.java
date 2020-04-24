package com.silent.redis;

import com.silent.global.GlobalString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * @author liusc
 * 2020-4-21 00:41:20
 */
public class LockRedis {

    private Logger log = LoggerFactory.getLogger(LockRedis.class);

    private JedisPool jedispool;

    public LockRedis(JedisPool jedispool) {
        this.jedispool = jedispool;
    }

    // 基于redis 实现分布式锁代码思路 核心方法 获取锁 释放锁
    // redis 实现分布式锁 有两个超时 时间问题

    /**
     * 两个超时时间含义
     * 1.获取超时锁之前的超过时间 == 在尝试获取锁的时候 如果在规定的时间内还没有获取锁 直接放弃
     * 2.在获取锁之后的超时时间 == 当获取锁成功之后 对应的key 有对应有效期 对应的key 在规定时间内进行失效
     */

    //基于redis实现分布式锁代码思路 核心方法 获取锁 释放锁
    public String getRedisLock(long acquireTimeOut, long timeOut) {
        Jedis jedis = null;
        String identifierValue = null;
        try {
            jedis = jedispool.getResource();
            identifierValue = UUID.randomUUID().toString();

            int expireLockTimeOut = (int) timeOut / 1000; // 以秒为单位
            //定义在获取锁之前的超时时间
            //使用循环机制 如果没有获取到锁,要在规定acquireTimeOut时间 保证重复进行尝试获取锁(乐观锁)

            long endTime = System.currentTimeMillis() + acquireTimeOut;
            while (System.currentTimeMillis() < endTime) {
                //获取锁
                // 使用setnx 命令插入对应的redislockkey 如果返回为1 则获取到锁
                if (jedis.setnx(GlobalString.redisLockKey, identifierValue) == 1) {
                    // 设置有效期时间
                    jedis.expire(GlobalString.redisLockKey, expireLockTimeOut);
                    return identifierValue;
                } else {
                    //获取到锁失败
                    //为什么获取锁之后,还要设置锁的超时时间 目的是为了防止死锁
                    //zk实现分布式锁也需要防止死锁 设置session有效期
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return identifierValue;
    }

    /**
     * 释放redis锁
     *
     * @param identifierValue
     * @return
     */
    public boolean unRedisLock(String identifierValue) {

        // 释放锁有两种方式 key有过期时间
        // 整个程序执行完毕情况下 删除对应的key

        boolean flag = false;

        if (StringUtils.isEmpty(identifierValue)) {
            return flag;
        }

        Jedis jedis = null;
        try {
            jedis = jedispool.getResource();
            String lockName = GlobalString.redisLockKey;
            if (identifierValue.equals(jedis.get(lockName))) {
                jedis.del(lockName);
                log.info("unRedisLock  redis锁释放成功  ThreadName == >" + Thread.currentThread().getName());
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return flag;

    }

}


