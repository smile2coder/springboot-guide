package com.smile2coder.shiro.controller;

import com.smile2coder.common.response.ResponseData;
import com.smile2coder.common.response.ResponseDataUtil;
import com.smile2coder.shiro.common.ResponseCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ZxT
 * @date 2020-06-05
 * @desc
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseData<String> doLogin(@RequestParam(value = "username") String username,
                                             @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        String authorization = (String) subject.getSession().getId();
        return ResponseDataUtil.response(ResponseCode.SUCCESS, authorization);
    }

    @PostMapping("/logout")
    public ResponseData<String> logout(HttpServletRequest request) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseDataUtil.response(ResponseCode.LOGIN_OUT);
    }

    @GetMapping("/unauth")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseData<String> unAuth() {
        return ResponseDataUtil.response(ResponseCode.UN_AUTH);
    }

    @GetMapping("/unlogin")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseData<String> unLogin() {
        return ResponseDataUtil.response(ResponseCode.UN_LOGIN);
    }
}
