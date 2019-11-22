package com.china.test.sample.tsservice.service;

/**
 * @author yandongjun
 */
public interface JedisClient {

    String set(String key, String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key, int seconds);

    Long ttl(String key);

    Long incr(String key);

    Long incr(String key, int expireSeconds);

    Long hset(String key, String field, String value);

    String hget(String key, String field);

    Long hdel(String key, String... field);
}