package com.nine.app.dal.repository;

import com.nine.app.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjia
 * @date 2018-12-03
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {

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
