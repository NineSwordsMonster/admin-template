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
 * @date 2018-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;
    /**
     * 上级类目
     */
    @Column(name = "pid", nullable = false)
    private Long pid;

    @Column(name = "alias")
    private String alias;

    @ManyToMany(mappedBy = "permissions")
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;

}
