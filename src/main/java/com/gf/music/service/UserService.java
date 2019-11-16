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

    /**
     * 插入一个或者多个user对象
     * @param users
     * @return
     * @throws Exception
     */
    int insertUser(List<User> users) throws Exception;

    /**
     * 根据参数修改对应user记录
     * @param id
     * @return
     * @throws Exception
     */
    int updateUser(int id) throws Exception;
}
