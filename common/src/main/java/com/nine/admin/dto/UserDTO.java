package com.nine.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 09:22
 */
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    @JsonIgnore
    private String password;

    private Date createTime;

    private Date lastPasswordResetTime;

    private Set<RoleSmallDTO> roles;

    private Long deptId;
}
