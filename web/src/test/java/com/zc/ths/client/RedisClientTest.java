package com.zc.ths.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import com.zc.ths.user.entity.User;
import com.zc.ths.utils.EncryptionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.security.provider.MD5;
import sun.security.provider.SHA;
import sun.security.rsa.RSASignature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/application-context.xml")
public class RedisClientTest {

    @Autowired
    private RedisTemplate redisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void beforeTest(){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
    }

    @Test
    public void testString() throws InterruptedException {
        redisTemplate.opsForValue().set("name", "zhouc");
        redisTemplate.expire("name", 10, TimeUnit.SECONDS);

        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);
        Thread.sleep(10000);
        name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);

    }

    @Test
    public void testHash() throws NoSuchAlgorithmException, InterruptedException {
        User user = new User();
        user.setUsername("zhouc");
        String password = "123456";
        user.setPassword(EncryptionUtil.SHA1Encrypt(password));

        redisTemplate.opsForHash().put(user.getUsername(), "username", user.getUsername());
        redisTemplate.opsForHash().put(user.getUsername(), "password", user.getPassword());

        redisTemplate.expire(user.getUsername(), 10, TimeUnit.SECONDS);

        System.out.println(redisTemplate.opsForHash().putIfAbsent(user.getUsername(), "username", "zhouch"));

        Map<String, Object> map = redisTemplate.opsForHash().entries(user.getUsername());
        System.out.println(map);

        Thread.sleep(10000);

        map = redisTemplate.opsForHash().entries(user.getUsername());
        System.out.println(map);

        System.out.println(redisTemplate.opsForHash().putIfAbsent(user.getUsername(), "username", "zhouc"));

    }

}