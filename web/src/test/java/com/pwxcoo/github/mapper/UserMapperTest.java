package com.pwxcoo.github.mapper;

import com.pwxcoo.github.model.User;
import com.pwxcoo.github.utils.AvatarUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.mapper
 * @email pwxcoo@gmail.com
 * @time 2018/09/30 20:10
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void initiate() {
        log.info("Initiating the before UserMapper Test steps");
    }

    @After
    public void tearDown() {
        log.info("Ending the After UserMapper Test steps");
    }

    @Test
    @Rollback
    public void InsertOneUserTest() throws Exception {
        Assert.assertEquals(null, userMapper.findUserByEmail("test-pwxcoo@gmail.com"));
        int result = userMapper.insertUser("test-pwxcoo", AvatarUtil.generateAvatar(),"test-pwxcoo@gmail.com", "123456", "git");
        Assert.assertEquals(1, result);

        User user = userMapper.findUserByEmail("test-pwxcoo@gmail.com");
        Assert.assertEquals("test-pwxcoo", user.getUsername());
        Assert.assertEquals(true, AvatarUtil.deleteAvatar(user.getAvatar()));
        Assert.assertEquals("123456", user.getPassword());
        Assert.assertEquals("git", user.getSalt());
        Assert.assertEquals(user, userMapper.findUserByUsername("test-pwxcoo"));
    }


}