package com.pwxcoo.github.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.utils
 * @email pwxcoo@gmail.com
 * @time 2018/10/01 13:30
 * @description
 */
@SpringBootTest
@Slf4j
public class PasswordUtilTest {

    @Test
    public void testPasswordUtil() {
        String password = PasswordUtil.generateRandomPassword(20);
        String salt = PasswordUtil.getNextSalt();
        String securePassword = PasswordUtil.hash(password.toCharArray(), salt);
//        log.info(securePassword.toString());
        Assert.assertEquals(true, PasswordUtil.isExpectedPassword(password.toCharArray(), salt, securePassword.toCharArray()));
    }
}