package com.usian.service;

import com.jiyun.vo.ItemContentVo;

import java.util.List;

public interface ContentService {

    /*
     * 首页大广告位接口
     * */
    List<ItemContentVo> selectFrontendContentByAD();

}
