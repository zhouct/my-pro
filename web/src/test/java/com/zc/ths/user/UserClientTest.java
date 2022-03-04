package com.zc.ths.user;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.service.UserService;
import com.zc.ths.user.vo.UserParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class UserClientTest {

    @Autowired
    private UserService userService;

    private ThreadLocalRandom random = ThreadLocalRandom.current();

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testInsert(){

        User user = new User();
        user.setId(random.nextLong());
        user.setUsername("张三——"+random.nextInt(17));
        user.setAccountName("read_" + random.nextInt(47));
        user.setPassword("password_" + random.nextInt(1000));

        userService.insert(user);

        testFind();
    }

    @Test
    public void testFind(){

        UserParam userParam = new UserParam();
        userParam.setUsername("name_04-01-00");
        List<User> userList = userService.getUserList(userParam);
        System.out.println(userList);
    }



}
