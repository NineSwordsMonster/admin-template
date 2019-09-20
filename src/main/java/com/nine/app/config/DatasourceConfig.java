package com.nine.app.config;

import com.nine.app.dal.repository.BaseRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 10:36
 */
@EnableJpaAuditing
@EnableJpaRepositories(
        basePackageClasses = {BaseRepository.class},
        basePackages = {"com.nine.app.dal.repository"})
@EnableTransactionManagement
public class DatasourceConfig {
}
