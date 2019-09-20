package com.nine.app.service;

import com.nine.app.dto.UserDTO;
import com.nine.app.entity.User;

/**
 * @author wangjia
 * @date 2018-11-23
 */

public interface UserService {

//    /**
//     * get
//     * @param id
//     * @return
//     */
//    @Cacheable(key = "#p0")
//    UserDTO findById(long id);
//

    /**
     * create
     *
     * @param resources
     *
     * @return
     */
    UserDTO create(User resources);
//
//    /**
//     * update
//     * @param resources
//     */
//    @CacheEvict(allEntries = true)
//    void update(User resources);
//
//    /**
//     * delete
//     * @param id
//     */
//    @CacheEvict(allEntries = true)
//    void delete(Long id);

    /**
     * findByName
     *
     * @param userName
     *
     * @return
     */
    UserDTO findByName(String userName);

//    /**
//     * 修改密码
//     * @param username
//     * @param encryptPassword
//     */
//    @CacheEvict(allEntries = true)
//    void updatePass(String username, String encryptPassword);
//
//    /**
//     * 修改头像
//     * @param username
//     * @param url
//     */
//    @CacheEvict(allEntries = true)
//    void updateAvatar(String username, String url);
//
//    /**
//     * 修改邮箱
//     * @param username
//     * @param email
//     */
//    @CacheEvict(allEntries = true)
//    void updateEmail(String username, String email);
}
