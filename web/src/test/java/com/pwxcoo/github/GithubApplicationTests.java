package com.pwxcoo.github;

import com.pwxcoo.github.api.rpc.RpcConsumerControllerTest;
import com.pwxcoo.github.controller.UserControllerTest;
import com.pwxcoo.github.mapper.UserMapperTest;
import com.pwxcoo.github.utils.AvatarUtilTest;
import com.pwxcoo.github.utils.PasswordUtilTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		UserMapperTest.class,
		RpcConsumerControllerTest.class,
		PasswordUtilTest.class,
		UserControllerTest.class,
		AvatarUtilTest.class
})
public class GithubApplicationTests {

	@Test
	public void contextLoads() {
	}

}
