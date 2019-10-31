package com.gf.music.controller;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import com.gf.music.domain.User;
import com.gf.music.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
            if (user.size() > 0 && user.get(0).getPwd().equals(pwd)) {
                eiInfo.setStatus(CommonConstant.STAUS_SUCCESS);
                eiInfo.setMessage(CommonConstant.RETURN_MESSAGE_VALUE_SUCCESS_LOGIN);
            } else {
                eiInfo.setStatus(CommonConstant.STAUS_NULL);
                eiInfo.setMessage(CommonConstant.RETURN_MESSAGE_VALUE_NULL_LOGIN);
            }
        } catch (Exception e) {
            eiInfo.setStatus(CommonConstant.STAUS_FAIL);
            eiInfo.setMessage(CommonConstant.RETURN_MESSAGE_FAIL);
        }
        return eiInfo;
    }
}
