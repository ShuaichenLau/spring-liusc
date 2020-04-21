package com.silent.global;

public interface GlobalString {

    String redisLockKey = "redis_lock";
    String redisHost = "192.168.0.119";
    // String redisHost = "127.0.0.1";
    String password = "";
    int redisPort = 6379;
    int database = 0;

    long timeOut = 5000;
    long acquireTimeOut = 10000;
    int maxConnTotal = 200;
    int maxIdle = 8;
    long maxWaitMillis = 1000 * 100;
}
