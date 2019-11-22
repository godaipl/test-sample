package com.china.test.sample.tsapi.controller;

import java.util.Calendar;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.china.test.sample.tsservice.service.JedisClient;
import com.google.common.util.concurrent.RateLimiter;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * 这是一个测试controller
 *
 * @author yandongjun
 */
@RestController
@RequestMapping("limit")
@Slf4j
public class TestLimitController {

    // guava 配置 该方法定义每秒钟允许数量
    public static final RateLimiter limiter = RateLimiter.create(1); // 允许每秒最多1个任务

    // java自带信号量实现
    public static final Semaphore semaphore = new Semaphore(2, true);

    // java自带锁
    private static final Lock lock = new ReentrantLock();
    private static final Lock tryLockNotGood = new ReentrantLock();
    private static final Lock tryLock = new ReentrantLock();

    // 示例代码 不使用自动注解
    JedisClient jedisClient;

    /**
     * http://ip:port/ts/limit/guava
     * 
     * @return
     */
    @RequestMapping("/guava")
    public String guava() {
        try {
            // 请求令牌,超过许可会被阻塞
            limiter.acquire();
            log.info("guava limit {}", Calendar.getInstance().getTime());
        } catch (Exception e) {
            log.error("guava error", e);
        } finally {
        }

        return "guava";
    }

    /**
     * http://ip:port/ts/limit/semaphore
     * 
     * @return
     */
    @RequestMapping("/semaphore")
    public String semaphore() {
        try {
            // 请求令牌,超过许可会被阻塞
            semaphore.acquire();
            Thread.sleep(1000);
            log.info("semaphore limit {}", Calendar.getInstance().getTime());
        } catch (Exception e) {
            log.info("semaphore error", e);
        } finally {
            semaphore.release(); // 释放信号量
        }
        return "semaphore";
    }

    /**
     * http://ip:port/ts/limit/lock
     * 
     * @return
     */
    @RequestMapping("/lock")
    public String lock() {
        try {
            // 阻塞
            lock.lock();
            Thread.sleep(1000);
            log.info("lock limit {}", Calendar.getInstance().getTime());
        } catch (Exception e) {
            log.info("lock error", e);
        } finally {
            lock.unlock(); // 释放锁
        }
        return "lock";
    }

    /**
     * http://ip:port/ts/limit/tryLockNotGood
     * 
     * @return
     */
    @RequestMapping("/tryLockNotGood")
    public String tryLockNotGood() {
        try {
            // 外部请求等待2秒，如果2秒内业务执行完成即可获得锁的控制权
            if (tryLockNotGood.tryLock(2, TimeUnit.SECONDS)) {
                Thread.sleep(3000);
                log.info("tryLockNotGood limit {}", Calendar.getInstance().getTime());
            }
        } catch (Exception e) {
            log.info("tryLockNotGood error", e);
        } finally {
            tryLockNotGood.unlock(); // 释放锁
        }
        return "tryLockNotGood";
    }

    /**
     * http://ip:port/ts/limit/tryLock
     * 
     * @return
     */
    @RequestMapping("/tryLock")
    public String tryLock() {
        try {
            // 外部请求等待2秒，如果2秒内业务执行完成即可获得锁的控制权
            if (tryLock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    Thread.sleep(3000);
                    log.info("tryLock limit {}", Calendar.getInstance().getTime());
                } catch (Exception e) {
                    log.info("tryLock do error", e);
                } finally {
                    tryLock.unlock(); // 释放锁
                }
            } else {
                log.info("tryLock tryLock fail {}", Calendar.getInstance().getTime());
            }
        } catch (Exception e) {
            log.info("tryLock error", e);
        } finally {
            // tryLock.unlock(); // 释放锁
        }
        return "tryLock";
    }

    /**
     * http://ip:port/ts/limit/redisLockNotGoodEnough
     * 
     * @return
     */
    @RequestMapping("/redisLockNotGoodEnough")
    public String redisLockNotGoodEnough() {
        try {
            // 获取当前时间 2019-11-22 15:21
            String currentTime = "2019-11-22 15:21";

            // 判断当前分钟请求数量
            if (Integer.parseInt(jedisClient.get(currentTime)) > 4) {
                jedisClient.incr(currentTime, 120);
                Thread.sleep(1000);
                log.info("redisLockNotGoodEnough limit {}", Calendar.getInstance().getTime());
            }
        } catch (Exception e) {
            log.info("redisLockNotGoodEnough error", e);
        } finally {
            // tryLock.unlock(); // 释放锁
        }
        return "redisLockNotGoodEnough";
    }

    /**
     * http://ip:port/ts/limit/redisLock
     * 
     * @return
     */
    @RequestMapping("/redisLock")
    public String redisLock() {
        try {
            // 获取当前时间 2019-11-22 15:21
            String currentTime = "2019-11-22 15:21";

            // 判断当前分钟请求数量
            if (Integer.parseInt(jedisClient.get(currentTime)) <= 4) {
                if (jedisClient.incr(currentTime, 120) <= 4) {
                    Thread.sleep(1000);
                    log.info("redisLock limit {}", Calendar.getInstance().getTime());
                }
            }
        } catch (Exception e) {
            log.info("redisLock error", e);
        } finally {
            // tryLock.unlock(); // 释放锁
        }
        return "redisLock";
    }
}
