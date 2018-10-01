package com.pwxcoo.github.mapper;

import com.pwxcoo.github.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.mapper
 * @email pwxcoo@gmail.com
 * @time 2018/09/30 19:56
 * @description
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(@Param("email") String email);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Insert("INSERT INTO USER(username, email, password, salt) VALUES(#{username}, #{email}, #{password}, #{salt})")
    int insertUser(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("salt") String salt);
}
