package com.gf.music.service;

import com.gf.music.domain.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    /**
     * 返回user对象或者集合
     * @param map
     * @return
     */
    List<User> getUser(HashMap<String,Object> map) throws Exception;
}
