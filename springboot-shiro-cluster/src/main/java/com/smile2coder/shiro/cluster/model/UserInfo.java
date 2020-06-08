package com.smile2coder.shiro.cluster.model;


import lombok.Data;

import java.io.Serializable;

/**
 * @author ZxT
 * @date 2020-06-05
 * @desc 用户实体
 */
@Data
public class UserInfo implements Serializable {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String salt;
}
