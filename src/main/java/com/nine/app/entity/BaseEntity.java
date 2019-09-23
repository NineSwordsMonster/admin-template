package com.nine.app.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author wangjia at 2018/4/8 下午8:46
 */

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity<U> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    /**
     * 创建时间
     */
    @Column(name = "create_date", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    @CreatedBy
    @Column(name = "create_user", nullable = false)
    protected U createUser;
    /**
     * 更新时间
     */
    @Column(name = "update_date", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateDate;

    @LastModifiedBy
    @Column(name = "update_user", nullable = false)
    protected U updateUser;

    /**
     * 是否删除
     * 0-未删除 1-已删除
     */
    @Column(name = "deleted")
    protected Boolean deleted;

}

