package com.nine.app.dal.repository;

import com.nine.app.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;


/**
 * @author wangjia
 * @date 2018-12-03
 */
@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    /**
     * findByName
     *
     * @param name
     *
     * @return
     */
    Role findByName(String name);

    Set<Role> findByUsers_Id(Long id);

    Set<Role> findByMenus_Id(Long id);
}
