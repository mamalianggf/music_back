package com.gf.music.controller;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import com.gf.music.domain.User;
import com.gf.music.service.MailService;
import com.gf.music.service.UserService;
import com.gf.music.util.CollectionUtils;
import com.gf.music.util.MD5Utils;
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
    @Autowired
    private MailService mailService;

    private final static Logger userLogger = LoggerFactory.getLogger(UserController.class);

    /*
    登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public EiInfo login(String name, String pwd) throws Exception {
        EiInfo eiInfo = new EiInfo();
        eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
        eiInfo.setMessage("账号或者密码错误");
        //todo.如果size大于1？
        List<User> user = userService.getUser(CollectionUtils.createHashMap("name", name));
        if (user.size() == 0) {//判断账号是否存在
            return eiInfo;
        }
        User param = user.get(0);
        if (!param.isActive()) {//判断是否已经被激活
            mailService.sendMail(param);
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("用户邮箱未激活已发送激活邮件");
        }
        if (MD5Utils.GetMD5Code(pwd).equals(param.getPwd())) {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("登录成功");
            eiInfo.setResult(CollectionUtils.createHashMap("token", param.getId()));
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
            User param = userList.get(0);
            //发送邮件
            mailService.sendMail(param);
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("激活email已发送\n激活后方可登录");
        } else {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("插入空行");
        }
        return eiInfo;
    }

    /*
    返回user对象
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public EiInfo getUser(String token) throws Exception {
        EiInfo eiInfo = new EiInfo();
        List<User> users = userService.getUser(CollectionUtils.createHashMap("id", token));
        if (users.size() > 0) {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
            eiInfo.setMessage("该用户已登录");
            eiInfo.setResult(CollectionUtils.createHashMap("user", users.get(0)));
        } else {
            eiInfo.setStatus(CommonConstant.HTTP_STATUS_MEDIUM);
            eiInfo.setMessage("无效token");
        }
        return eiInfo;
    }

    @RequestMapping("/active")
    @ResponseBody
    public String active(String id) throws Exception {
        userService.updateUser(Integer.valueOf(id));
        return "恭喜您已激活，快去登录吧！";
    }


}
