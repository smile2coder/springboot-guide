package com.smile2coder.common.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ZxT
 * @date 2020-06-07
 * @desc web应用返回类
 */
@Getter
@Setter
@ToString
public class ResponseData<T> {

    private int code;
    private String message;
    private T data;

    public ResponseData() {
    }

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
