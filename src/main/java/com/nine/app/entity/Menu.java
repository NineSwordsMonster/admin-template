package com.nine.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author wangjia
 * @date 2018-12-17
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(unique = true)
    private Long sort;
    @Column(name = "path")
    private String path;
    @Column(name = "icon")
    private String component;
    @Column(name = "icon")
    private String icon;
    /**
     * 上级菜单ID
     */
    @Column(name = "pid", nullable = false)
    private Long pid;

    /**
     * 是否为外链 true/false
     */
    @Column(name = "i_frame")
    private Boolean iFrame;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles;
}
