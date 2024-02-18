package com.lyz.admin.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import com.lyz.admin.filter.AuthFilter;
import com.lyz.admin.property.AdminProperties;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 11:02
 */
@Configuration
public class WebConfig {

    @Autowired
    private AdminProperties adminProperties;

    @Bean
    public ExecutorService commonExecutorService() {
        ExecutorService executorService = new ThreadPoolExecutor(adminProperties.getCorePoolSize(),
            adminProperties.getMaximumPoolSize(), adminProperties.getKeepAliveTime(), adminProperties.getUnit(),
            new LinkedBlockingQueue<Runnable>(), new CustomizableThreadFactory("common-pool-"));
        return executorService;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new AuthFilter(adminProperties));
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setName("adminProperties");
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

}
