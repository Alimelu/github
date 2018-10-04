package com.pwxcoo.github.exception;

import com.pwxcoo.github.model.exception.NotFoundException;
import com.pwxcoo.github.model.response.RestfulExceptionInfo;
import com.pwxcoo.github.model.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pwxcoo
 * @package com.pwxcoo.github.exception
 * @email pwxcoo@gmail.com
 * @time 2018/10/04 16:08
 * @description
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView defaultErrorHandler(HttpServletRequest httpServletRequest, Exception e) throws Exception {
        log.error(e.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);

        return modelAndView;
    }

    @ExceptionHandler(value = ServerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestfulExceptionInfo ServerErrorHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) throws ServerException {
        return new RestfulExceptionInfo(org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR,
                                e.getMessage(),
                                httpServletRequest.getRequestURL().toString());
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestfulExceptionInfo NotFoundErrorHandler(HttpServletRequest httpServletRequest, ServerException e) {
        return new RestfulExceptionInfo(org.apache.http.HttpStatus.SC_NOT_FOUND,
                e.getMessage(),
                httpServletRequest.getRequestURL().toString());
    }



}
