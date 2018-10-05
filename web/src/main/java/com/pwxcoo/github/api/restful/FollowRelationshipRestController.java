package com.pwxcoo.github.api.restful;

import com.pwxcoo.github.dto.FollowRelationshipDto;
import com.pwxcoo.github.model.exception.ServerException;
import com.pwxcoo.github.model.exception.UnauthorizedException;
import com.pwxcoo.github.service.followRelationship.FollowRelationshipService;
import com.pwxcoo.github.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.api.restful
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 18:56
 * @description
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/followRelationship")
public class FollowRelationshipRestController {

    @Autowired
    FollowRelationshipService followRelationshipService;


    @RequestMapping(value = "/{followingUsername}", method = RequestMethod.GET)
    public Boolean getFollowRelationship(@PathVariable String followingUsername) throws UnauthorizedException {
        if (SessionUtil.session().isPresent()) {

            return followRelationshipService.checkFollowRelationshipByUsername(SessionUtil.getUsername(), followingUsername);
        } else throw new UnauthorizedException("The user is not logined!");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean createFollowRelationship(@RequestBody FollowRelationshipDto followRelationshipDto) throws UnauthorizedException, ServerException {
        if (followRelationshipDto.getFollowerId() == null) {
            if ( SessionUtil.session().isPresent() == false) {
                throw new UnauthorizedException("The user is not logined!");
            }
        }

        log.info(followRelationshipDto.toString());
        if (followRelationshipService.addFollowRelationship(SessionUtil.getUsername(),followRelationshipDto.getFollowingUsername())) {
            return followRelationshipService.checkFollowRelationshipByUsername(SessionUtil.getUsername(),followRelationshipDto.getFollowingUsername());
        }
        throw new ServerException("create follow relationship failed!");
    }

    @RequestMapping(value = "/{followingUsername}", method = RequestMethod.DELETE)
    public Boolean deleteFollowRelationship(@PathVariable String followingUsername) throws UnauthorizedException, ServerException {
        if (SessionUtil.session().isPresent()) {

            return followRelationshipService.deleteFollowRelationship(SessionUtil.getUsername(), followingUsername);
        } else throw new UnauthorizedException("The user is not logined!");
    }
}
