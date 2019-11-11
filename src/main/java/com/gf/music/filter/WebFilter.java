package com.gf.music.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
过滤未登录的用户,url后缀命中规则走过滤器
暂时放弃
 */
/*@Component*/
@javax.servlet.annotation.WebFilter(filterName = "webFilter")
public class WebFilter implements Filter {

    private final static Logger userLogger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userLogger.info("创建过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        userLogger.info("执行过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                //todo
                //存在token已登录

            }
        }
        //不存在token未登录
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        userLogger.info("过滤器被销毁");
    }
}
