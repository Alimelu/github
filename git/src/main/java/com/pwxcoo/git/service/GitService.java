package com.pwxcoo.git.service;

import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;

/**
 * @author pwxcoo
 * @package com.pwxcoo.git.service
 * @email pwxcoo@gmail.com
 * @time 2018/09/25 10:03
 * @description
 */
public interface GitService {

    String createNewRepository(String username, String repositoryName) throws GitAPIException, IOException;

    String createNewRepository(File file) throws GitAPIException, IOException;

    void deleteRepository(File file) throws IOException;

    String readFileFromCommit(File file, String filename) throws IOException;

}
