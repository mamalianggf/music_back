package com.gf.music.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;


public interface SongService {

    /**
     * 查询歌曲（分页）
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<HashMap<String, Object>> listSongs(int pageNum, int pageSize) throws Exception;
}
