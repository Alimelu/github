package com.pwxcoo.github.api.rpc;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pwxcoo.git.service.RpcService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.api.rpc
 * @email pwxcoo@gmail.com
 * @time 2018/10/01 10:48
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@WebAppConfiguration
public class RpcConsumerControllerTest {
    private MockMvc mvc;

    @Reference(version = "${git.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
    private RpcService rpcService;

    @Before
    public void initiate() {
        log.info("Initiating the before RpcConsumerController Test steps");
        mvc = MockMvcBuilders.standaloneSetup(new RpcConsumerController()).build();
    }

    @After
    public void tearDown() {
        log.info("Ending the After RpcConsumerController Test steps");
    }

    @Test
    public void testRpcConnection() throws Exception{
        Assert.assertEquals("Hello, pwxcoo (from Spring Boot), Test RPC Successfully!", rpcService.sayHello("pwxcoo"));
    }
}