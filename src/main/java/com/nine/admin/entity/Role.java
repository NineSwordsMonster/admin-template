package com.nine.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 01:27
 */
@Entity
@Table(name = "role")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = {Update.class})
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(name = "data_scope")
    private String dataScope = "本级";

    @Column(name = "level")
    private Integer level = 3;

    @Column
    private String remark;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "roles_permissions", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<Permission> permissions;

    @ManyToMany
    @JoinTable(name = "roles_menus", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<Menu> menus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(dataScope, role.dataScope) &&
                Objects.equals(level, role.level) &&
                Objects.equals(remark, role.remark) &&
                Objects.equals(createTime, role.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dataScope, level, remark, createTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Role.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("dataScope='" + dataScope + "'")
                .add("level=" + level)
                .add("remark='" + remark + "'")
                .add("users=" + users)
                .add("createTime=" + createTime)
                .toString();
    }

    public interface Update {
    }
}
