package com.open.capacity.security.advice;

import com.open.capacity.security.dto.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 异常处理
 *
 * @author caoheyang
 * @version 20180727
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    /**
     * 403 Forbidden
     *
     * @param exception 异常
     *                  {@link AccessDeniedException}
     * @return
     */
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseInfo badRequestException(AccessDeniedException exception) {
        return new ResponseInfo(HttpStatus.FORBIDDEN.value() + "", exception.getMessage());
    }

    /**
     * 服务器400
     *
     * @param exception 异常
     *                  {@link MissingServletRequestParameterException}
     *                  {@link HttpMessageNotReadableException}
     *                  {@link UnsatisfiedServletRequestParameterException}
     *                  {@link MethodArgumentTypeMismatchException}
     *                  {@link IllegalArgumentException}
     * @return
     * @Description 服务器不理解请求的语法
     */
    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class,
            UnsatisfiedServletRequestParameterException.class, MethodArgumentTypeMismatchException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseInfo badRequestException(Exception exception) {
        return new ResponseInfo(HttpStatus.BAD_REQUEST.value() + "", exception.getMessage());
    }

    /**
     * 服务器500
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInfo exception(Throwable throwable) {
        log.error("系统异常", throwable);
        return new ResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.value() + "", throwable.getMessage());
    }
}
