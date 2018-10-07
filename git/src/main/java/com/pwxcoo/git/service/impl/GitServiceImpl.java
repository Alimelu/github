package com.pwxcoo.git.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pwxcoo.git.api.GitHelper;
import com.pwxcoo.git.service.GitService;
import com.pwxcoo.git.util.GitUtil;
import org.eclipse.jgit.api.errors.GitAPIException;

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

    @Override
    public String createNewRepository(String username, String repositoryName) throws GitAPIException, IOException {
        return createNewRepository(GitUtil.getFile(username, repositoryName));
    }

    @Override
    public String createNewRepository(File file) throws GitAPIException, IOException {
        File f = GitHelper.createNewRepository(file);
        return f.getAbsolutePath();
    }

    @Override
    public void deleteRepository(File file) throws IOException {
        GitHelper.deleteRepository(file);
    }

    @Override
    public String readFileFromCommit(File file, String filename) throws IOException {
        return GitHelper.readFileFromCommit(file, filename);
    }
}
