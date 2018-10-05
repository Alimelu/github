package com.pwxcoo.github.mapper;

import com.pwxcoo.github.dto.RepositoryDto;
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

    @Select("SELECT * FROM repository LEFT JOIN user ON repository.user_id = user.user_id WHERE username = #{username}")
    List<RepositoryDto> getRepositoriesByUsername(@Param("username") String username);

    @Select("SELECT * FROM repository LEFT JOIN user ON repository.user_id = user.user_id WHERE repository.user_id = #{user_id} AND repository.repository_name = #{repository_name}")
    RepositoryDto getRepositoryByRepositoryNameAndUserId(@Param("user_id") Long userId, @Param("repository_name") String repositoryName);

    @Insert("INSERT INTO repository(user_id, repository_name, description) VALUES(#{user_id}, #{repository_name}, #{description})")
    int insertRepository(@Param("user_id") Long userId, @Param("repository_name") String repositoryName, @Param("description") String description);
}
