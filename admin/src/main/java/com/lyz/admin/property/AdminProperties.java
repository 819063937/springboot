package com.lyz.admin.property;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 9:38
 */
@Component
@Data
@ConfigurationProperties(prefix = "admin")
public class AdminProperties {
    private boolean authEnabled;

    private int corePoolSize = 5;

    private int maximumPoolSize = 10;

    private long keepAliveTime = 10;

    private TimeUnit unit = TimeUnit.MILLISECONDS;

}
