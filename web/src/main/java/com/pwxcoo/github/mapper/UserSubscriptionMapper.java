package com.pwxcoo.github.mapper;

import com.pwxcoo.github.dto.UserSubscriptionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.mapper
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 11:53
 * @description
 */
@Mapper
@Repository
public interface UserSubscriptionMapper {


    @Select("SELECT * FROM user_subscription WHERE user_id = #{user_id}")
    List<UserSubscriptionDto> getSubscriptionByUserId(@Param("user_id") Long userId);
}
