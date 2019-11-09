package com.gf.music.controller;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import com.gf.music.domain.User;
import com.gf.music.service.UserService;
import com.gf.music.util.MD5Utils;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private final static Logger userLogger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST/*,produces = "application/json;charset=utf-8"*/)
    @ResponseBody
    public EiInfo login(String name, String pwd) {
        EiInfo eiInfo = new EiInfo();
        HashMap<String, Object> param = new HashMap<>();
        param.put("name", name);
        //todo.如果size大于1？
        List<User> user = null;
        try {
            user = userService.getUser(param);
            if (user.size() > 0 && MD5Utils.GetMD5Code(pwd).equals(user.get(0).getPwd())) {
                eiInfo.setStatus(CommonConstant.QUERY_SUCCESS);
                eiInfo.setMessage("登录成功");
                eiInfo.setToken(user.get(0).getId());
            } else {
                eiInfo.setStatus(CommonConstant.QUERY_NULL);
                eiInfo.setMessage("账号或者密码错误");
            }
        } catch (Exception e) {
            userLogger.error(e.getMessage());
            eiInfo.setStatus(CommonConstant.QUERY_FAIL);
            eiInfo.setMessage("服务器错误");
        }
        return eiInfo;
    }

    @RequestMapping(value = "/validateRepeatName", method = RequestMethod.GET)
    @ResponseBody
    public EiInfo validateRepeatName(String name) {
        EiInfo eiInfo = new EiInfo();
        HashMap<String,Object> para = new HashMap<>();
        para.put("name",name);
        try {
            List users = userService.getUser(para);
            if (users.size()>0){
                eiInfo.setStatus(CommonConstant.QUERY_SUCCESS);
                eiInfo.setMessage("该账号已存在");
            }else{
                eiInfo.setStatus(CommonConstant.QUERY_NULL);
                eiInfo.setMessage("该账号不存在");
            }
        } catch (Exception e) {
            userLogger.error(e.getMessage());
            eiInfo.setStatus(CommonConstant.QUERY_FAIL);
            eiInfo.setMessage("服务器错误");
        }
        return eiInfo;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public EiInfo register(User user) {
        EiInfo eiInfo = new EiInfo();
        List<User> users = new ArrayList<>();
        //todo 未处理空指针可借助optional
        user.setPwd(MD5Utils.GetMD5Code(user.getPwd()));
        users.add(user);
        int result = 0;
        try {
            result = userService.insertUser(users);
            if (result > 0) {
                eiInfo.setStatus(CommonConstant.INSERT_SUCCESS);
                eiInfo.setMessage("插入成功");
            } else {
                eiInfo.setStatus(CommonConstant.INSERT_NULL);
                eiInfo.setMessage("插入空行");
            }
        } catch (Exception e) {
            userLogger.error(e.getMessage());
            eiInfo.setStatus(CommonConstant.INSERT_FAIL);
            eiInfo.setMessage("插入失败");
        }
        return eiInfo;
    }
}
