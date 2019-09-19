package com.nine.admin.biz.service;


import com.nine.admin.common.dto.UserDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/19 09:19
 */
@CacheConfig(cacheNames = "user")
public interface UserService {

    /**
     * get
     *
     * @param id
     *
     * @return
     */
    @Cacheable(key = "#p0")
    UserDTO findById(long id);

    /**
     * create
     *
     * @param resources
     *
     * @return
     */
    @CacheEvict(allEntries = true)
    UserDTO create(User resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(User resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * findByName
     *
     * @param userName
     *
     * @return
     */
    @Cacheable(key = "'loadUserByUsername:'+#p0")
    UserDTO findByName(String userName);

    /**
     * 修改密码
     *
     * @param username
     * @param encryptPassword
     */
    @CacheEvict(allEntries = true)
    void updatePass(String username, String encryptPassword);

    /**
     * 修改头像
     *
     * @param username
     * @param url
     */
    @CacheEvict(allEntries = true)
    void updateAvatar(String username, String url);

    /**
     * 修改邮箱
     *
     * @param username
     * @param email
     */
    @CacheEvict(allEntries = true)
    void updateEmail(String username, String email);

    @Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(UserQueryCriteria criteria, Pageable pageable);
}
