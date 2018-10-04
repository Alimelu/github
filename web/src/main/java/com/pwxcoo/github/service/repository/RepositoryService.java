package com.pwxcoo.github.service.repository;

import com.pwxcoo.github.model.data.Repository;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service.repository
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 12:00
 * @description
 */
public interface RepositoryService {

    List<Repository> getRepositoriesByUsername(String username);

    Boolean createRepository(Repository repository);
}
