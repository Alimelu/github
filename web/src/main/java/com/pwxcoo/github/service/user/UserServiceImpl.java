package com.pwxcoo.github.service.user;

import com.pwxcoo.github.mapper.UserMapper;
import com.pwxcoo.github.model.User;
import com.pwxcoo.github.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service.user
 * @email pwxcoo@gmail.com
 * @time 2018/10/01 12:47
 * @description
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean checkUserIsExist(String email, String username) {

        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Boolean createUser(User user) {
        try {
            user.setSalt(PasswordUtil.getNextSalt().toString());
            user.setPassword(PasswordUtil.hash(user.getPassword().toCharArray(), user.getSalt().getBytes()).toString());
            if (userMapper.insertUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getSalt()) > 0)
                return true;
        } catch (Exception e) {
            log.error("Error when insert User: " + user.toString());
            return false;
        }
        return false;
    }

    @Override
    public Boolean validateUser(String email, String password) {
        User realUser = userMapper.findByEmail(email);
        if (realUser == null) return false;
        log.info(realUser.toString());
        return realUser.getPassword().equals(PasswordUtil.hash(password.toCharArray(), realUser.getSalt().getBytes()));
    }

}
