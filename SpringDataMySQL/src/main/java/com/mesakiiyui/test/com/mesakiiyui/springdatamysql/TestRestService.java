package com.mesakiiyui.test.com.mesakiiyui.springdatamysql;

import com.mesakiiyui.springdatamysql.Entity.User;
import com.mesakiiyui.springdatamysql.service.RestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRestService {

    private static Logger logger = LoggerFactory.getLogger(TestRestService.class);

    @Autowired
    private RestService restService;

    @Test
    public void testGetPostsPlainJSON(){
        String res = restService.getPostsPlainJSON();
        logger.info("res:"+res);

    }

    @Test
    public void testAssert(){
        User user = new User();
        Assert.notNull(user.getPasswd(), "passWordNull");
    }

}
