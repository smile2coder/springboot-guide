package com.smile2coder.common.response;

/**
 * @author ZxT
 * @date 2020-06-07
 * @desc web应用返回类工具类
 */
public class ResponseDataUtil {

    public static ResponseData response(ResponseCodeBase responseCodeBase) {
        return new ResponseData(responseCodeBase.getCode(), responseCodeBase.getMessage());
    }

    public static <T> ResponseData response(ResponseCodeBase responseCodeBase, T data) {
        return new ResponseData(responseCodeBase.getCode(), responseCodeBase.getMessage(), data);
    }

}
