package com.pwxcoo.github.model;

import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 17:02
 * @description
 */
@Data
public class RepositorySubscription {

    private Long repositorySubscriptionId;
    private Long userId;
    private Integer action;     // 1: 'star', 2: 'create', 3: 'fork'
    private Long repositoryId;
}
