package com.gf.music.handler;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/*
统一处理controller抛出的异常
 */
@ControllerAdvice
public class ExceptionHandler {

    private final static Logger userLogger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler()
    @ResponseBody
    public EiInfo handler(Exception e) {
        userLogger.error(e.getMessage());
        EiInfo eiInfo = new EiInfo();
        eiInfo.setStatus(CommonConstant.HTTP_STATUS_ERROR);
        eiInfo.setMessage("服务器错误");
        return eiInfo;
    }
}
