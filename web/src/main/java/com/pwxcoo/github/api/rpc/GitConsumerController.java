package com.pwxcoo.github.api.rpc;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pwxcoo.git.service.GitService;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.api
 * @email pwxcoo@gmail.com
 * @time 2018/09/25 10:17
 * @description
 */
@RestController
public class GitConsumerController {
    @Reference(version = "${git.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
    private GitService gitService;

    @RequestMapping("/initRep")
    public String createNewRepository(@RequestParam String username, @RequestParam String repositoryName) throws GitAPIException, IOException {
        return gitService.createNewRepository(username, repositoryName);
    }
}
