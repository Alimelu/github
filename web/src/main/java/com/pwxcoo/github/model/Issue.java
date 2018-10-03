package com.pwxcoo.github.model;

import lombok.Data;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model
 * @email pwxcoo@gmail.com
 * @time 2018/10/03 17:10
 * @description
 */
@Data
public class Issue {

    private Long issueId;
    private Long issueNumber;
    private Long repositoryId;
    private Long userId;
    private String text;
    private Integer status;     // 1: 'open', 2: 'closed'
    private Long commentCount;
}
