package com.gf.music.constant;

import org.springframework.beans.factory.annotation.Value;

public class CommonConstant {

    public final static int HTTP_STATUS_ERROR = 500;   //服务器报错
    public final static int HTTP_STATUS_SUCCESS = 200; //成功f处理请求
    public final static int HTTP_STATUS_MEDIUM = 204;  //成功处理但是没返回想要的东西

    public final static String USER_IMG_URL_PREFIX = "http://106.15.248.92:8083/userImg/";//userImg的url前缀

    public final static String APPOINT_REFERER = "http://localhost:8081/music_front/";//请求来源
}
