package com.pwxcoo.github.model;

import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model
 * @email pwxcoo@gmail.com
 * @time 2018/09/23 11:20
 * @description
 */
@Data
public class User {

    private Long userId;
    private String email;
    private String avatar;
    private String bio;
    private String location;
    private String link;
    private String username;
    private String password;
    private String salt;
}