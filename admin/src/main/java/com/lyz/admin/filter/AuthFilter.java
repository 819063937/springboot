package com.lyz.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.lyz.admin.property.AdminProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 11:34
 */
@Slf4j
public class AuthFilter implements Filter {

    private AdminProperties adminProperties;

    public AuthFilter(AdminProperties adminProperties) {
        this.adminProperties = adminProperties;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        if (!adminProperties.isAuthEnabled()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
