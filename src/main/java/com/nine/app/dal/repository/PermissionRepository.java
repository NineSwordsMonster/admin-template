package com.nine.app.dal.repository;

import com.nine.app.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjia
 * @date 2018-12-03
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     *
     * @param name
     *
     * @return
     */
    Permission findByName(String name);

    /**
     * findByPid
     *
     * @param pid
     *
     * @return
     */
    List<Permission> findByPid(long pid);
}
