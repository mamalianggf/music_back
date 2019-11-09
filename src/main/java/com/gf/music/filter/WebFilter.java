package com.gf.music.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/*
过滤未登录的用户,url后缀命中规则走过滤器
 */
@javax.servlet.annotation.WebFilter(filterName = "webFilter",urlPatterns = "*.do")
public class WebFilter implements Filter {

    private final static Logger userLogger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userLogger.info("创建过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        userLogger.info("执行过滤器");
    }

    @Override
    public void destroy() {
        userLogger.info("过滤器被销毁");
    }
}
