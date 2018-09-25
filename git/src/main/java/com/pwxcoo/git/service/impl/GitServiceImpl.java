package com.pwxcoo.git.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pwxcoo.git.service.GitService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

/**
 * @author pwxcoo
 * @package com.pwxcoo.git.service.impl
 * @email pwxcoo@gmail.com
 * @time 2018/09/25 10:04
 * @description
 */
@Service(
        version = "${git.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class GitServiceImpl implements GitService {

    @Value("${gitservice.directory}")
    private String gitServiceDirectory;

    @Override
    public String initRepository(String username, String repositoryName) {
        try {
            File dir = new File(String.format("%s/%s/%s.git", gitServiceDirectory, username, repositoryName));
            Git.init().setDirectory( dir ).setBare( true ).call();
            return dir.getAbsolutePath();
        } catch (GitAPIException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
