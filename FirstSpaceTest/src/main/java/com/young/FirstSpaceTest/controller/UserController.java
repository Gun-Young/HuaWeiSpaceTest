package com.young.FirstSpaceTest.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/10/17 0017.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName(){
        return "hi,i am zhangsan";
    }


    /**
     * 保存值到redis
     * @param name
     */
    @RequestMapping(value ="saveToRedis" ,method = RequestMethod.GET)
    public void saveToRedis(@RequestParam("name") String name){
        RBucket<String> bucket = redissonClient.getBucket("name");
        bucket.set(name);
    }

    /**
     * 从redis取值
     */
    @RequestMapping(value = "getFromRedis",method = RequestMethod.GET)
    public String getFromRedis(){
        RBucket<String> bucket = redissonClient.getBucket("name");
        return bucket.get();
    }

    /**
     * 获取reids锁
     * @param lockname
     */
    @RequestMapping(value = "getLock",method = RequestMethod.GET)
    public void getRlock(@RequestParam("lock") String lockname){
        RLock lock = null;
        try{
            lock = redissonClient.getLock(lockname);
            lock.lock(60, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName()+"........获取到了锁.............."+lockname);
        }catch (Exception e){
            lock.unlock();
        }
    }

}




















