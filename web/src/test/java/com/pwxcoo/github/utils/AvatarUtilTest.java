package com.pwxcoo.github.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.utils
 * @email pwxcoo@gmail.com
 * @time 2018/10/02 14:40
 * @description
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AvatarUtilTest {

    @Value("${avatar.directory}")
    private String avatarPath;

    @Test
    public void testAvatar() {
        String f = AvatarUtil.generateAvatar();
        File file = new File(avatarPath + f);
        Assert.assertEquals(true, AvatarUtil.deleteAvatar(f));
    }
}