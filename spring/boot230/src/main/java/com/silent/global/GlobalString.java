package com.silent.global;

public interface GlobalString {

    public static String redisLockKey = "redis_lock";
    public static String redisHost = "192.168.0.119";
//    public static String redisHost = "127.0.0.1";
    public static String password = "";
    public static int redisPort = 6379;
    public static int database = 0;

    public static long timeOut = 10000;
    public static int maxConnTotal = 200;
    public static int maxIdle = 8;
    public static long maxWaitMillis = 10000L;
}
