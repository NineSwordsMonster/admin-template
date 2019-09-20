package com.nine.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:33
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<Message> handleBaseException(BaseException e) {
        ResponseStatus responseStatus = findMergedAnnotation(e.getClass(), ResponseStatus.class);
        HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        Message message;
        if (e.getErrorCode() != null) {
            message = new Message(e.getErrorCode().getStatus(), e.getErrorCode().getCode(), e.getErrorCode().getReason());
        } else {
            message = new Message(status.value(), e.getCause().toString(), e.getLocalizedMessage());
        }
        log.error("服务异常", e);
        return new ResponseEntity<>(message, status);
    }

    @ExceptionHandler(AccountExpiredException.class)
    @ResponseBody
    public ResponseEntity<Message> handleAccountExpiredException(AccountExpiredException e) {
        ResponseStatus responseStatus = findMergedAnnotation(e.getClass(), ResponseStatus.class);
        HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.UNAUTHORIZED;
        log.error("服务异常", e);
        return new ResponseEntity<>(new Message(status.value(), HttpStatus.UNAUTHORIZED.name(), e.getMessage()), status);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Message> handleException(Exception e) {
        ResponseStatus responseStatus = findMergedAnnotation(e.getClass(), ResponseStatus.class);
        HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        log.error("服务异常", e);
        return new ResponseEntity<>(new Message(status.value(), "", e.getMessage()), status);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {

        private Integer status;
        private String code;
        private String reason;
    }

}
