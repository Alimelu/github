package com.pwxcoo.github.service.repository;

import com.pwxcoo.github.mapper.RepositoryMapper;
import com.pwxcoo.github.model.data.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service.repository
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 12:02
 * @description
 */
@Service
@Slf4j
public class RepositoryServiceImpl implements RepositoryService{

    @Autowired
    RepositoryMapper repositoryMapper;

    @Override
    public List<Repository> getRepositoriesByUsername(String username) {
        return repositoryMapper.getRepositoriesByUsername(username);
    }

    @Override
    public Boolean createRepository(Repository repository) {
        try {
            if (repositoryMapper.insertRepository(repository.getUserId(), repository.getRepositoryName()) > 0)
                return true;
            else {
                log.error("Unknown Error when insert Repository: " + repository.toString());
                return false;
            }
        } catch (Exception e) {
            log.error("Error when insert Repository: " + repository.toString());
            return false;
        }
    }
}
