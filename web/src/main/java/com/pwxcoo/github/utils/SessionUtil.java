package com.pwxcoo.github.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.utils
 * @email pwxcoo@gmail.com
 * @time 2018/10/01 19:22
 * @description
 * @from https://stackoverflow.com/questions/1629211/how-do-i-get-the-session-object-in-spring
 */
public class SessionUtil {
    public static Optional<HttpSession> session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return Optional.ofNullable(attr.getRequest().getSession(false)); // true == allow create
    }
}
