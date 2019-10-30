package com.gf.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.POST/*,produces = "application/json;charset=utf-8"*/)
    @ResponseBody
    public String login(String name, String pwd) {
        if ("gf".equals(name)&&"gf".equals(name)){
            return "success";
        }
        return "failure";
    }
}
