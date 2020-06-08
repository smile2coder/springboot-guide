package com.smile2coder.shiro.controller;

import com.smile2coder.common.response.ResponseData;
import com.smile2coder.common.response.ResponseDataUtil;
import com.smile2coder.shiro.common.ResponseCode;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZxT
 * @date 2020-06-05
 * @desc
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    @RequiresRoles(value = {"admin"})
    public ResponseData<String> admin() {
        return ResponseDataUtil.response(ResponseCode.SUCCESS);
    }

    @GetMapping("/admin2")
    @RequiresRoles(value = {"admin"})
    @RequiresPermissions(value = {"aaf"})
    public ResponseData<String> admin2() {
        return ResponseDataUtil.response(ResponseCode.SUCCESS);
    }

    @GetMapping("/user")
    @RequiresRoles(value = {"user"})
    public ResponseData<String> user() {
        return ResponseDataUtil.response(ResponseCode.SUCCESS);
    }
}
