package com.nine.app.config;

import com.nine.app.dal.repository.BaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 10:36
 */
@EnableJpaAuditing(
        auditorAwareRef = "userAuditorAware",
        dateTimeProviderRef = "dateTimeProvider")
@EnableJpaRepositories(
        basePackageClasses = {BaseRepository.class},
        basePackages = {"com.nine.app.dal.repository"})
@EnableTransactionManagement
public class DatasourceConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new UserAuditorAware();
    }
}
