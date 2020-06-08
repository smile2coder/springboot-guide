package com.smile2coder.shiro.config;

import com.smile2coder.common.response.ResponseData;
import com.smile2coder.common.response.ResponseDataUtil;
import com.smile2coder.shiro.common.ResponseCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author ZxT
 * @date 2019-11-08
 * @desc 全局异常捕获
 */
@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public ResponseData<String> incorrectCredentialsException() {
        return ResponseDataUtil.response(ResponseCode.INCORRECT_CREDENTIALS);
    }

    @ExceptionHandler(value = LockedAccountException.class)
    public ResponseData<String> lockedAccountException() {
        return ResponseDataUtil.response(ResponseCode.LOCKED_ACCOUNT);
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public ResponseData<String> unknownAccountException() {
        return ResponseDataUtil.response(ResponseCode.UNKNOWN_ACCOUNT);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseData<String> unauthorizedException() {
        return ResponseDataUtil.response(ResponseCode.UN_AUTH);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseData<String> noHandlerFoundException() {
        return ResponseDataUtil.response(ResponseCode.URL_NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseData<String> exception(Exception e) {
        e.printStackTrace();
        return ResponseDataUtil.response(ResponseCode.ERROR);
    }

}
