package com.nine.admin.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 09:23
 */
@Data
public class RoleSmallDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
