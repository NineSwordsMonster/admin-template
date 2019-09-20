package com.nine.app.dal.repository;

import com.nine.app.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author wangjia
 * @date 2018-12-17
 */
@Repository
public interface MenuRepository extends BaseRepository<Menu, Long> {

    /**
     * findByName
     *
     * @param name
     *
     * @return
     */
    Menu findByName(String name);

    /**
     * findByPid
     *
     * @param pid
     *
     * @return
     */
    List<Menu> findByPid(long pid);

    LinkedHashSet<Menu> findByRoles_IdOrderBySortAsc(Long id);
}
