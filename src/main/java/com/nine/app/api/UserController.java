package com.nine.app.api;

import com.nine.app.dto.UserDTO;
import com.nine.app.service.RoleService;
import com.nine.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/create")
//    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_CREATE')")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UserDTO> create(@Validated @RequestBody UserDTO resources, Authentication authentication) {
//        authentication.getDetails()
//        checkLevel(resources);
        final UserDTO userDTO = userService.create(resources);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

//    @PutMapping(value = "/users")
//    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_EDIT')")
//    public ResponseEntity update(@Validated(User.Update.class) @RequestBody User resources){
//        checkLevel(resources);
//        userService.update(resources);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping(value = "/users/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN','USER_ALL','USER_DELETE')")
//    public ResponseEntity delete(@PathVariable Long id){
//        Integer currentLevel =  Collections.min(roleService.findByUsers_Id(SecurityUtils.getUserId()).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList()));
//        Integer optLevel =  Collections.min(roleService.findByUsers_Id(id).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList()));
//
//        if (currentLevel > optLevel) {
//            throw new BadRequestException("角色权限不足");
//        }
//        userService.delete(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    /**
//     * 修改密码
//     * @param user
//     * @return
//     */
//    @PostMapping(value = "/users/updatePass")
//    public ResponseEntity updatePass(@RequestBody UserPassVo user){
//        UserDetails userDetails = SecurityUtils.getUserDetails();
//        if(!userDetails.getPassword().equals(EncryptUtils.encryptPassword(user.getOldPass()))){
//            throw new BadRequestException("修改失败，旧密码错误");
//        }
//        if(userDetails.getPassword().equals(EncryptUtils.encryptPassword(user.getNewPass()))){
//            throw new BadRequestException("新密码不能与旧密码相同");
//        }
//        userService.updatePass(userDetails.getUsername(),EncryptUtils.encryptPassword(user.getNewPass()));
//        return new ResponseEntity(HttpStatus.OK);
//    }

    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     *
     * @param resources
     */
//    private void checkLevel(User resources) {
//        Integer currentLevel = roleService.findByUsers_Id(SecurityUtils.getUserId()).stream().map(RoleSmallDTO::getLevel).
//        Integer optLevel = roleService.findByRoles(resources.getRoles());
//        if (currentLevel > optLevel) {
//            throw new BadRequestException("角色权限不足");
//        }
//    }
}
