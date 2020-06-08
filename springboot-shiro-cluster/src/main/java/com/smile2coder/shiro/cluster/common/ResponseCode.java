package com.smile2coder.shiro.cluster.common;


import com.smile2coder.common.response.ResponseCodeBase;

/**
 * @author ZxT
 * @date 2020-06-07
 * @desc 应用通用返回码
 */
public enum ResponseCode implements ResponseCodeBase {

    SUCCESS(200, "成功"),
    URL_NOT_FOUND(404, "URL没有找到"),
    ERROR(500, "失败"),
    INCORRECT_CREDENTIALS(505, "密码错误"),
    LOCKED_ACCOUNT(506, "该用户已被禁用"),
    UNKNOWN_ACCOUNT(507, "该用户不存在"),
    UN_LOGIN(510, "用户未登录"),
    UN_AUTH(515, "用户没有权限"),
    LOGIN_OUT(520, "用户退出登录"),
    ;

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
