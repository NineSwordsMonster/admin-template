//package com.nine.app.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//import javax.sql.DataSource;
//
///**
// * Create by 王佳
// *
// * @author 王佳
// * @date 2019/9/22 21:42
// */
//
//@EnableOAuth2Sso
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    private AuthenticationManager authenticationManager;
//    private DataSource dataSource;
//    private PasswordEncoder passwordEncoder;
//
//    public AuthorizationServerConfig(@Autowired AuthenticationConfiguration authenticationConfiguration,
//                                     @Autowired DataSource dataSource,
//                                     @Autowired PasswordEncoder passwordEncoder
//    ) throws Exception {
//        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
//        this.dataSource = dataSource;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        super.configure(security);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//    }
//}
