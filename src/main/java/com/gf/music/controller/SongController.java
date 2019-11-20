package com.gf.music.controller;

import com.gf.music.constant.CommonConstant;
import com.gf.music.domain.EiInfo;
import com.gf.music.service.SongService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 获取歌曲
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/listSongs",method = RequestMethod.GET)
    @ResponseBody
    public EiInfo listSongs(@RequestParam int pageNum,@RequestParam int pageSize) throws Exception{
        EiInfo eiInfo = new EiInfo();
        PageInfo<HashMap<String, Object>> songPage = songService.listSongs(pageNum,pageSize);
        eiInfo.setStatus(CommonConstant.HTTP_STATUS_SUCCESS);
        eiInfo.setMessage("查询成功");
        HashMap result = new HashMap();
        result.put("songs",songPage);
        eiInfo.setResult(result);
        return eiInfo;
    }


}
