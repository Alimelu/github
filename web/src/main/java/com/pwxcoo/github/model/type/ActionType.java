package com.pwxcoo.github.model.type;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.model.type
 * @email pwxcoo@gmail.com
 * @time 2018/10/05 12:04
 * @description
 */
public enum  ActionType {

    FOLLOW("follow");

    private final String actionType;

    ActionType(final String actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return actionType;
    }

}
