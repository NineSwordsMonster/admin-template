package com.nine.app.config.security;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:03
 */
@Data
@ToString
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";
}
