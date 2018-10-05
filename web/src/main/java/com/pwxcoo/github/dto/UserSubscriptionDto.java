package com.pwxcoo.github.dto;

import com.pwxcoo.github.model.type.Action;
import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.dto
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 12:01
 * @description
 */
@Data
public class UserSubscriptionDto {

    private Long userSubscriptionId;
    private Long userId;
    private Action action;  // 'follow'
    private Long actionId;

}
