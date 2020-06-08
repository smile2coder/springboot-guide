package com.smile2coder.shiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZxT
 * @date 2020-06-05
 * @desc 用户实体
 */
@Data
public class UserInfo {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String salt;
}
