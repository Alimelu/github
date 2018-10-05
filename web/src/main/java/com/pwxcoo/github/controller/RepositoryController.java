package com.pwxcoo.github.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.controller
 * @email pwxcoo@gmail.com
 * @time 2018/10/04 12:04
 * @description
 */
@Controller
@Slf4j
public class RepositoryController {


    @RequestMapping(value = "/{username}/{repositoryName}", method = RequestMethod.GET)
    public String getRepository(ModelMap modelMap, @PathVariable("username") String username, @PathVariable("repositoryName") String repositoryName) {
        log.info("username: " + username  + " repositoryName: " + repositoryName);
        return "code";
    }
}
