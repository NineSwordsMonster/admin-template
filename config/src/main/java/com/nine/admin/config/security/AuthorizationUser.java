package com.nine.admin.config.security;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 02:41
 */
@Data
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";

    @Override
    public String toString() {
        return "{username=" + username + ", password= ******}";
    }
}
