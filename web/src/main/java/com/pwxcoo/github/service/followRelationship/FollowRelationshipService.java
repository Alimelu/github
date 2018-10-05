package com.pwxcoo.github.service.followRelationship;

import com.pwxcoo.github.model.data.FollowRelationship;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service.followRelationship
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 18:51
 * @description
 */
public interface FollowRelationshipService {

    Boolean checkFollowRelationshipByUserId(Long followerId, Long followingId);

    Boolean checkFollowRelationshipByUserId(FollowRelationship followRelationship);

    Boolean checkFollowRelationshipByUsername(String followerUsername, String followingUsername);

    Boolean addFollowRelationship(Long followerId, Long followingId);

    Boolean addFollowRelationship(String followerUsername, String followingUsername);

    Boolean addFollowRelationship(FollowRelationship followRelationship);

    Boolean deleteFollowRelationship(Long followerId, Long followingId);

    Boolean deleteFollowRelationship(String followerUsername, String followingUsername);
}
