package com.nine.admin.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 02:35
 */
@Getter
@AllArgsConstructor
public class AuthenticationInfo implements Serializable {

    private final String token;

    private final JwtUser user;
}
