package com.gf.music.service.impl;

import com.gf.music.mapper.SongMapper;
import com.gf.music.service.SongService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public  PageInfo<HashMap<String, Object>> listSongs(int pageNum, int pageSize) throws Exception {
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String,Object>> songs = songMapper.listSongs();
        PageInfo<HashMap<String, Object>> songPage = new PageInfo<>(songs);
        return songPage;
    }
}
