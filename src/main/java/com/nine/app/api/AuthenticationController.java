package com.nine.app.api;

import com.nine.app.config.security.AuthenticationInfo;
import com.nine.app.config.security.AuthorizationUser;
import com.nine.app.config.security.JwtUser;
import com.nine.app.config.security.utils.JwtTokenUtil;
import com.nine.app.dto.UserDTO;
import com.nine.app.service.UserService;
import com.nine.app.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjia
 * @date 2018-11-23
 * 授权、根据token获取用户详细信息
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    /**
     * 登录授权
     *
     * @param authorizationUser
     *
     * @return
     */

    @PostMapping(value = "${jwt.auth.path}")
    public ResponseEntity<String> login(@Validated @RequestBody AuthorizationUser authorizationUser) {

        final UserDTO userDTO = userService.login(authorizationUser.getUsername(), authorizationUser.getPassword());



        // 返回 token
        return ResponseEntity.ok(new AuthenticationInfo(token, jwtUser));
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping(value = "${jwt.auth.account}")
    public ResponseEntity getUserInfo() {
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(SecurityUtils.getUsername());
        return ResponseEntity.ok(jwtUser);
    }
}
