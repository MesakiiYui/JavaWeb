package com.mesakiiyui.springdatamysql.JUnitTest;

import com.mesakiiyui.dm.common.utils.redis.RedisUtils;
import com.mesakiiyui.dm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        User user = new User();
        user.setUserName("朝雾轻寒");
        user.setPasswd("123");
        serializableRedisTemplate.opsForValue().set("user", user);
        User user2 = (User) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:" + user2.getUserName() + "," + user2.getPasswd());
    }

    @Test
    public void testRedisUtils() {
        String key = "user";
        String value = "tom";
        redisUtils.set(key, value);
        String result = redisUtils.get(key);
        System.out.println(result);

    }


}
