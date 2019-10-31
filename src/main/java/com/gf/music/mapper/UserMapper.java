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
}
