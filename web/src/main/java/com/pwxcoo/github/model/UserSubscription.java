package com.pwxcoo.github.model;

import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 17:00
 * @description
 */
@Data
public class UserSubscription {

    private Long userSubscriptionId;
    private Long userId;
    private Integer action; // 1: 'follow'
    private Long actionId;

}
