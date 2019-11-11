package com.gf.music.controller;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import com.gf.music.domain.User;
import com.gf.music.service.UserService;
import com.gf.music.util.CollectionUtils;
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

    /*
    登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public EiInfo login(String name, String pwd) throws Exception {
        EiInfo eiInfo = new EiInfo();
        //todo.如果size大于1？
        List<User> user = userService.getUser(CollectionUtils.createHashMap("name", name));
        if (user.size() > 0 && MD5Utils.GetMD5Code(pwd).equals(user.get(0).getPwd())) {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("登录成功");
            eiInfo.setResult(CollectionUtils.createHashMap("token", user.get(0).getId()));
        } else {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("账号或者密码错误");
        }
        return eiInfo;
    }

    /*
    判断name是否存在
     */
    @RequestMapping(value = "/validateRepeatName", method = RequestMethod.GET)
    @ResponseBody
    public EiInfo validateRepeatName(String name) throws Exception {
        EiInfo eiInfo = new EiInfo();
        List users = userService.getUser(CollectionUtils.createHashMap("name", name));
        if (users.size() > 0) {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("该账号已存在");
        } else {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("该账号不存在");
        }
        return eiInfo;
    }

    /*
    注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public EiInfo register(User user) throws Exception {
        EiInfo eiInfo = new EiInfo();
        List<User> users = new ArrayList<>();
        //todo 未处理空指针可借助optional
        user.setPwd(MD5Utils.GetMD5Code(user.getPwd()));
        users.add(user);
        int result = 0;
        result = userService.insertUser(users);
        if (result > 0) {
            List<User> userList = userService.getUser(CollectionUtils.createHashMap("name", user.getName()));
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("插入成功");
            eiInfo.setResult(CollectionUtils.createHashMap("token", userList.get(0).getId()));
        } else {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("插入空行");
        }
        return eiInfo;
    }


}
