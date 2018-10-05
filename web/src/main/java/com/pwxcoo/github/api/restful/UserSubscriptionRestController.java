package com.pwxcoo.github.api.restful;

import com.pwxcoo.github.dto.UserSubscriptionDto;
import com.pwxcoo.github.model.exception.NotFoundException;
import com.pwxcoo.github.model.exception.UnauthorizedException;
import com.pwxcoo.github.service.user.UserService;
import com.pwxcoo.github.service.userSubscription.UserSubscriptionService;
import com.pwxcoo.github.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.api.restful
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 11:52
 * @description
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/userSubscription")
public class UserSubscriptionRestController {

    @Autowired
    UserSubscriptionService userSubscriptionService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserSubscriptionDto> getSubscriptionByCurrentUserId() throws NotFoundException, UnauthorizedException {
        if (SessionUtil.session().isPresent() == false) {
            throw new UnauthorizedException("The user is not logined!");
        } else if (userService.getUserByUserId(SessionUtil.getUserId()) == null) {
            throw new NotFoundException("There is no this user!");
        }

        return userSubscriptionService.getUserSubscriptionByUserId(SessionUtil.getUserId());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserSubscriptionDto> getSubscriptionByUserId(@PathVariable("userId") Long userId) throws NotFoundException {
        if (userService.getUserByUserId(userId) == null) {
            throw new NotFoundException("There is no this user!");
        }

        return userSubscriptionService.getUserSubscriptionByUserId(userId);
    }

}
