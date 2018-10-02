package com.pwxcoo.github.controller;

import com.pwxcoo.github.model.User;
import com.pwxcoo.github.service.user.UserService;
import com.pwxcoo.github.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.controller
 * @email pwxcoo@gmail.com
 * @time 2018/10/02 11:28
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserService userService;

    @Before
    public void initiate() {
        log.info("Initiating the before UserController Test steps");
    }

    @Test
    public void testUserSignUp() throws Exception {
        RequestBuilder request = null;

        request = post("/signup")
                .param("email", "test@test.com")
                .param("username", "test-test")
                .param("password", "123")
                .param("confirmPassword", "123");
        mvc.perform(request)
                .andExpect(status().is3xxRedirection());
        User user = userService.getUserByEmail("test@test.com");
        Assert.assertEquals("test-test", user.getUsername());
        Assert.assertEquals(true, PasswordUtil.isExpectedPassword("123".toCharArray(), user.getSalt(), user.getPassword().toCharArray()));
        userService.deleteUserByEmail("test@test.com");
        Assert.assertEquals(null, userService.getUserByEmail("test@test.com"));
    }
}