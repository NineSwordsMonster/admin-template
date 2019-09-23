package com.nine.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * 角色
 *
 * @author wangjia
 * @date 2018-11-22
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role")
public class Role extends BaseEntity<Long> {

    @Column(nullable = false)
    @NotBlank
    private String name;

    /**
     * 数据权限类型 全部 、 本级 、 自定义
     */
    @Column(name = "data_scope")
    private String dataScope = "本级";

    /**
     * 数值越小，级别越大
     */
    @Column(name = "level")
    private Integer level = 3;

    @Column
    private String remark;

    @ManyToMany(mappedBy = "roles")
    @EqualsAndHashCode.Exclude
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "roles_permissions",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "roles_menus",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<Menu> menus;
}
