package com.pwxcoo.github.api.restful;

import com.pwxcoo.github.model.Repository;
import com.pwxcoo.github.service.repository.RepositoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.api.restful
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 11:54
 * @description
 */
@RestController
@RequestMapping(value = "/api/repository")
public class RepositoryRestController {

    @Autowired
    RepositoryService repositoryService;

    @ApiOperation(value="Get all repositories", notes="By username")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<Repository> getRepositoriesByUsername(@PathVariable String username) {
        return repositoryService.getRepositoriesByUsername(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createRepository(@RequestBody Repository repository) {
        if (repositoryService.createRepository(repository)) {
            return "success";
        }
        return "fail";
    }
}
