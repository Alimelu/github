package com.pwxcoo.github.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pwxcoo.git.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.controller
 * @email pwxcoo@gmail.com
 * @time 2018/09/23 16:02
 * @description
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${git.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
//            url = "dubbo://localhost:12345")
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }

}