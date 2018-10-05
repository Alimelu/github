package com.pwxcoo.github.mapper;

import com.pwxcoo.github.model.data.FollowRelationship;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.mapper
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 18:40
 * @description
 */
@Mapper
@Repository
public interface FollowRelationshipMapper {

    @Select("SELECT * FROM follow_relationship WHERE follower_id = #{follower_id} AND following_id = #{following_id}")
    FollowRelationship getFollowRelationship(@Param("follower_id") Long followId, @Param("following_id") Long followingId);

    @Insert("INSERT INTO follow_relationship(follower_id, following_id) VALUES (#{follower_id}, #{following_id})")
    int addFollowRelationship(@Param("follower_id") Long followId, @Param("following_id") Long followingId);

    @Delete("DELETE FROM follow_relationship WHERE follower_id = #{follower_id} AND following_id = #{following_id}")
    int deleteFollowRelationship(@Param("follower_id") Long followId, @Param("following_id") Long followingId);

//    @
//    FollowRelationshipDto()
}
