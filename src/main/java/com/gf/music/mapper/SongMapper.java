package com.gf.music.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SongMapper {

    /**
     * 返回song集合
     * @return
     * @throws Exception
     */
    List<HashMap<String,Object>> listSongs() throws Exception;



}
