package com.nine.app.service.impl;

import com.nine.app.dal.repository.UserRepository;
import com.nine.app.dto.UserDTO;
import com.nine.app.entity.User;
import com.nine.app.exception.EntityExistException;
import com.nine.app.exception.EntityNotFoundException;
import com.nine.app.mapper.detail.UserMapper;
import com.nine.app.service.UserService;
import com.nine.app.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangjia
 * @date 2018-11-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    //
//    @Autowired
//    private RedisService redisService;
//
//    @Override
//    public Object queryAll(UserQueryCriteria criteria, Pageable pageable) {
//        Page<User> page = userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
//        return PageUtil.toPage(page.map(userMapper::toDto));
//    }
//
//    @Override
//    public UserDTO findById(long id) {
//        Optional<User> user = userRepository.findById(id);
//        ValidationUtil.isNull(user,"User","id",id);
//        return userMapper.toDto(user.get());
//    }
//
    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public UserDTO create(UserDTO resources) {
        if (userRepository.findByUsername(resources.getUsername()) != null) {
            throw new EntityExistException(User.class, "username", resources.getUsername());
        }
        final User user = userMapper.toEntity(resources);

        user.setEnabled(true);
        return userMapper.toDTO(userRepository.save(user));
    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void update(User resources) {
//        Optional<User> userOptional = userRepository.findById(resources.getId());
//        ValidationUtil.isNull(userOptional,"User","id",resources.getId());
//
//        User user = userOptional.get();
//
//        User user1 = userRepository.findByUsername(user.getUsername());
//        User user2 = userRepository.findByEmail(user.getEmail());
//
//        if(user1 !=null&&!user.getId().equals(user1.getId())){
//            throw new EntityExistException(User.class,"username",resources.getUsername());
//        }
//
//        if(user2!=null&&!user.getId().equals(user2.getId())){
//            throw new EntityExistException(User.class,"email",resources.getEmail());
//        }
//
//        // 如果用户的角色改变了，需要手动清理下缓存
//        if (!resources.getRoles().equals(user.getRoles())) {
//            String key = "role::loadPermissionByUser:" + user.getUsername();
//            redisService.delete(key);
//            key = "role::findByUsers_Id:" + user.getId();
//            redisService.delete(key);
//        }
//
//        user.setUsername(resources.getUsername());
//        user.setEmail(resources.getEmail());
//        user.setEnabled(resources.getEnabled());
//        user.setRoles(resources.getRoles());
//        user.setDept(resources.getDept());
//        user.setJob(resources.getJob());
//        user.setPhone(resources.getPhone());
//        userRepository.save(user);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void delete(Long id) {
//        userRepository.deleteById(id);
//    }

    @Cacheable(key = "'loadUserByUsername:'+#p0")
    @Override
    public UserDTO findByName(String userName) {
        User user = null;
        if (ValidationUtil.isEmail(userName)) {
            user = userRepository.findByEmail(userName);
        } else {
            user = userRepository.findByUsername(userName);
        }
        if (user == null) {
            throw new EntityNotFoundException(User.class, "name", userName);
        } else {
            return userMapper.toDTO(user);
        }
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void updatePass(String username, String pass) {
//        userRepository.updatePass(username,pass,new Date());
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void updateAvatar(String username, String url) {
//        userRepository.updateAvatar(username,url);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void updateEmail(String username, String email) {
//        userRepository.updateEmail(username,email);
//    }
}
