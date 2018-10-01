package com.pwxcoo.github.service.user;

import com.pwxcoo.github.model.User;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.service
 * @email pwxcoo@gmail.com
 * @time 2018/10/01 12:43
 * @description
 */
public interface UserService {

    Boolean checkUserIsExist(String email, String username);

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    Boolean createUser(User user);

    Boolean validateUser(String email, String password);

}
