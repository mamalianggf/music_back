package com.gf.music.service.impl;

import com.gf.music.domain.User;
import com.gf.music.mapper.UserMapper;
import com.gf.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 返回user对象或者集合
     * @param map
     * @return
     */
    @Override
    public List<User> getUser(HashMap<String, Object> map) throws Exception {
        return userMapper.getUser(map);
    }
}
