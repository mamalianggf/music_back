package com.gf.music.handler;

import com.gf.music.constant.CommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截请求源不正确的请求
 */
public class RequestInterceptor implements HandlerInterceptor {

    private final static Logger requestInterceptorLogger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            return false;
        }
        if (referer.startsWith(CommonConstant.APPOINT_REFERER)) {
            return true;
        }
        requestInterceptorLogger.warn("请求来源不明，禁止访问");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("请求来源不明，禁止访问");
        return false;
    }

}
