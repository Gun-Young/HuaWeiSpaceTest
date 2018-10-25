package com.young.FirstSpaceTest.testpackage;

import com.young.FirstSpaceTest.FirstSpaceTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FirstSpaceTestApplication.class})
public class MyTest {

    @Autowired
    private RedissonClient redisson;


    /**
     * RLock 测试
     */
    @Test
    public void rlockTest(){
        RLock lock = null;
        try{
            lock = redisson.getLock("uid");
            lock.lock(60, TimeUnit.SECONDS);
        }catch (Exception e){
            lock.unlock();
        }

    }

    @Test
    public void getFromRedis(){
        RBucket<String> bucket = redisson.getBucket("name");
        System.out.println(bucket.get());
    }
}
