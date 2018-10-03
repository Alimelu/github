package com.pwxcoo.github.model;

import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 17:05
 * @description
 */
@Data
public class Notification {

    private Long notificationId;
    private Long userId;
    private Long repositoryId;
    private Integer action;  // 1: 'pull request', 2: 'issue'

}
