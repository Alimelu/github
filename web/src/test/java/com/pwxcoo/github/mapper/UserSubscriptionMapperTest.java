package com.pwxcoo.github.mapper;

import com.pwxcoo.github.model.type.Action;
import lombok.extern.slf4j.Slf4j;
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
 * @time 2018/10/05 15:16
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserSubscriptionMapperTest {

    @Autowired
    UserSubscriptionMapper userSubscriptionMapper;

    @Test
    @Rollback
    public void InsertOneUserSubscriptionTest() throws Exception {
        userSubscriptionMapper.insertUserSubscription(1l, Action.FOLLOW, 2l);

        log.info(userSubscriptionMapper.getSubscriptionByUserId(1l).toString());
    }
}