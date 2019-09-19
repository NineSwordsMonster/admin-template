package com.nine.admin.entity;

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
@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_password_reset_time")
    private Date lastPasswordResetTime;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("avatar='" + avatar + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("enabled=" + enabled)
                .add("password='" + password + "'")
                .add("createTime=" + createTime)
                .add("lastPasswordResetTime=" + lastPasswordResetTime)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(enabled, user.enabled) &&
                Objects.equals(password, user.password) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(lastPasswordResetTime, user.lastPasswordResetTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, avatar, email, phone, enabled, password, createTime, lastPasswordResetTime);
    }
}

