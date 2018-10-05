package com.pwxcoo.github.service.userSubscription;

import com.pwxcoo.github.dto.UserSubscriptionDto;
import com.pwxcoo.github.mapper.UserSubscriptionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service.userSubscription
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 12:18
 * @description
 */
@Service
@Slf4j
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    @Autowired
    UserSubscriptionMapper userSubscriptionMapper;

    @Override
    public List<UserSubscriptionDto> getSubscriptionByUserId(Long userId) {
        return userSubscriptionMapper.getSubscriptionByUserId(userId);
    }
}
