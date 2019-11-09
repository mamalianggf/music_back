package com.gf.music.mapper;

import com.gf.music.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserMapper {

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

}
