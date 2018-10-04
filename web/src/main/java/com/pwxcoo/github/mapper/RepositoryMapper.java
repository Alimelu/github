package com.pwxcoo.github.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.mapper
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 11:54
 * @description
 */
@Mapper
@Repository
public interface RepositoryMapper {

//    @Select("SELECT repository_name AS repositoryName, repository_star AS repositoryStar, " +
//                    "repository_fork AS repositoryFork, description AS description " +
//            "FROM repository LEFT JOIN user ON repository.user_id = user.user_id " +
//            "WHERE username = #{username}")
    @Select("SELECT * FROM repository LEFT JOIN user ON repository.user_id = user.user_id WHERE username = #{username}")
    List<com.pwxcoo.github.model.data.Repository> getRepositoriesByUsername(@Param("username") String username);

    @Insert("INSERT INTO repository(user_id, repository_name) VALUES(#{user_id}, #{repository_name})")
    int insertRepository(@Param("user_id") Long userId, @Param("repository_name") String repositoryName);
}
