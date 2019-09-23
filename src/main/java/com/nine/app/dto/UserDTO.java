package com.nine.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author wangjia
 * @date 2018-11-23
 */
@Data
public class UserDTO implements Serializable {

    private Long id;
    private String token;

    private String username;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    private String password;

    private Date createTime;

    private Date lastPasswordResetTime;

    private Set<RoleSmallDTO> roles;

}
