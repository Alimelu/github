package com.pwxcoo.github.model.data;

import com.pwxcoo.github.model.type.ActionType;
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
    private ActionType action;  // 'follow'
    private Long actionId;

}
